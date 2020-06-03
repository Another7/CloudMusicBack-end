package star.sky.another.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import star.sky.another.dao.*;
import star.sky.another.model.entity.Music;
import star.sky.another.model.entity.MusicSheet;
import star.sky.another.model.entity.User;
import star.sky.another.model.entity.UserCollectionSheet;
import star.sky.another.service.RecommendServiceInterface;
import star.sky.another.util.CityCoverTagUtil;
import star.sky.another.util.TimeCoverTagUtil;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/30 10:21
 **/
@Service
public class RecommendServiceInterfaceImpl implements RecommendServiceInterface {
    private final UserMapper userMapper;
    private final FollowMapper followMapper;
    private final MusicMapper musicMapper;
    private final MusicSheetMapper musicSheetMapper;
    private final UserCollectionSheetMapper userCollectionSheetMapper;

    public RecommendServiceInterfaceImpl(UserMapper userMapper, FollowMapper followMapper, MusicMapper musicMapper, MusicSheetMapper musicSheetMapper, UserCollectionSheetMapper userCollectionSheetMapper) {
        this.userMapper = userMapper;
        this.followMapper = followMapper;
        this.musicMapper = musicMapper;
        this.musicSheetMapper = musicSheetMapper;
        this.userCollectionSheetMapper = userCollectionSheetMapper;
    }

    @Override
    public List<Music> userCFRecommend(Long userId) {
        List<Music> musicList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        // 查询相似tag的用户
        User user = userMapper.selectByPrimaryKey(userId);
        ArrayNode tagArray = null;
        try {
            tagArray = (ArrayNode) objectMapper.readTree(user.getTag());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert tagArray != null;
        if (tagArray.size() > 0) {
            tagArray.forEach((tag) -> {
                userList.addAll(userMapper.selectSimilarUserByTag(tag.asInt()));
            });
        }
        // 查询关注的用户
        Set<Long> followId = followMapper.selectFollower(userId);
        userList.addAll(userMapper.selectUserByIds(followId));
        // 相似用户的标签id集合
        Set<Integer> tagIdSet = new HashSet<>();
        for (User userTemp : userList) {
            try {
                tagArray = (ArrayNode) objectMapper.readTree(userTemp.getTag());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tagArray.size() > 0) {
                tagArray.forEach((tag) -> {
                    tagIdSet.add(tag.asInt());
                });
            }
        }
        // 查询推荐的音乐
        for (Integer tagId : tagIdSet) {
            musicList.addAll(musicMapper.selectMusicByTag(tagId));
        }
        // 去重
        return musicList.stream().distinct().collect(Collectors.toList());
//        Set<Music> userSet = new HashSet<>(musicList);
//        return new ArrayList<>(userSet);
    }

    @Override
    public List<MusicSheet> itemCFRecommend(Long userId) {
        List<MusicSheet> musicSheetList = new ArrayList<>();
        // 创建的歌单
        List<MusicSheet> musicSheetListTemp = new ArrayList<>(musicSheetMapper.selectByCreatorId(userId));
        // 收藏的歌单
        List<UserCollectionSheet> userCollectionSheetList = userCollectionSheetMapper.selectByUserId(userId);
        List<Long> sheetIdList = new ArrayList<>();
        userCollectionSheetList.forEach((userCollectionSheet) -> {
            sheetIdList.add(userCollectionSheet.getSheetId());
        });
        musicSheetListTemp.addAll(musicSheetMapper.selectMusicSheetByIdList(sheetIdList));
        // 相似歌单
        ObjectMapper objectMapper = new ObjectMapper();
        Set<Integer> tagIdSet = new HashSet<>();
        ArrayNode tagArray = null;
        for (MusicSheet musicSheet : musicSheetListTemp) {
            try {
                tagArray = (ArrayNode) objectMapper.readTree(musicSheet.getTag());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tagArray != null && tagArray.size() > 0) {
                tagArray.forEach((tag) -> tagIdSet.add(tag.asInt()));
            }
        }
        for (Integer tagId : tagIdSet) {
            musicSheetList.addAll(musicSheetMapper.selectMusicSheetByTag(tagId));
        }
        musicSheetList = musicSheetList.stream()
                .filter((musicSheet) -> !musicSheet.getCreatorId().equals(userId))
                .distinct()
                .unordered()
                .skip(new Random().nextInt(musicSheetList.size()))
                .limit(4)
                .collect(Collectors.toList());
        if (musicSheetList.size() == 0) {
            return musicSheetMapper.randMusicSheet();
        }
        return musicSheetList;
    }

    @Override
    public List<Music> contextRecommend(Long userId, String ip) {
        List<Music> musicList = new ArrayList<>();
        Set<Integer> tagIdSet = new HashSet<>();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode tagNode = null;
        // 用户个人信息
        User user = userMapper.selectByPrimaryKey(userId);
        try {
            tagNode = (ArrayNode) objectMapper.readTree(user.getTag());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert tagNode != null;
        if (tagNode.size() > 0) {
            tagNode.forEach((tag) -> {
                tagIdSet.add(tag.asInt());
            });
        }
        // 时间
        tagIdSet.addAll(TimeCoverTagUtil.toTag(LocalTime.now().getHour()));
        // 地点
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ak", "bqk76uFTm5s5OOK6XZ2ahlQj8GFwZOFV");
        paramMap.put("ip", ip);
//        String ip = "192.168.0.107";
//        String ip = "192.168.227.1";
//        {
//            address: "CN|北京|北京|None|CHINANET|1|None",    #详细地址信息
//            content:    #结构信息
//            {
//                address: "北京市",    #简要地址信息
//                address_detail:    #结构化地址信息
//                {
//                    city: "北京市",    #城市
//                    city_code: 131,    #百度城市代码
//                    province: "北京市",    #省份
//                },
//                point:    #当前城市中心点
//                {
//                    x: "116.39564504",    #当前城市中心点经度
//                    y: "39.92998578"    #当前城市中心点纬度
//                }
//            },
//            status: 0    #结果状态返回码
//        }
//        result json结构
        String result = restTemplate.getForObject("http://api.map.baidu.com/location/ip?ak={ak}&ip={ip}",
                String.class, paramMap);
        JsonNode locationInfo = null;
        String cityCode = "";
        try {
            locationInfo = objectMapper.readTree(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (locationInfo.get("status").asInt() == 0) {
            cityCode = locationInfo.get("content").get("address_detail").get("city_code").asText();
        }
        tagIdSet.addAll(CityCoverTagUtil.toTag(cityCode));
        // 查询推荐的音乐
        for (Integer tagId : tagIdSet) {
            musicList.addAll(musicMapper.selectMusicByTag(tagId));
        }
        return musicList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Music> randRecommend() {
        return musicMapper.randMusic();
    }
}
