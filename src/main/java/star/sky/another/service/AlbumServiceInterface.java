package star.sky.another.service;

import star.sky.another.model.entity.Album;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/1 9:50
 **/
public interface AlbumServiceInterface {
    /**
     * 发布专辑
     *
     * @param album
     * @return
     */
    Album publishAlbum(Album album);

    /**
     * 根据id查询专辑
     *
     * @param albumId
     * @return
     */
    Album selectAlbumById(Long albumId);

    /**
     * 根据歌手id查询专辑列表
     *
     * @param singerId
     * @return
     */
    List<Album> selectAlbumBySingerId(Long singerId);
}
