package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.UserCollectionSheetMapper;
import star.sky.another.model.entity.UserCollectionSheet;
import star.sky.another.service.UserCollectionSheetInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/24 10:03
 **/
@Service
public class UserCollectionSheetInterfaceImpl implements UserCollectionSheetInterface {
    private final UserCollectionSheetMapper userCollectionSheetMapper;

    public UserCollectionSheetInterfaceImpl(UserCollectionSheetMapper userCollectionSheetMapper) {
        this.userCollectionSheetMapper = userCollectionSheetMapper;
    }

    @Override
    public int insertUserCollectionSheet(UserCollectionSheet userCollectionSheet) {
        return userCollectionSheetMapper.insert(userCollectionSheet);
    }

    @Override
    public List<UserCollectionSheet> selectUserCollectionSheetByUserId(Long userId) {
        return userCollectionSheetMapper.selectByUserId(userId);
    }
}
