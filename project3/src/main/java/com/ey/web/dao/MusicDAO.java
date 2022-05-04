package com.ey.web.dao;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ey.web.entity.*;

@Repository
public interface MusicDAO extends JpaRepository<MusicEntity, Integer> {
    
    @Query(value = "SELECT * "
            + "FROM music WHERE cate=:cate ORDER BY no ASC "
            + "limit :start,100", nativeQuery = true)
    public List<MusicEntity> musicList(@Param("cate") Integer cate, @Param("start") Integer start);
    
    @Query(value = "SELECT CEIL(COUNT(*)/100.0) FROM music "
            + "WHERE cate=:cate", nativeQuery = true)
    public int musicTotalPage(@Param("cate") Integer cate);
    
    public MusicEntity findByNo(int no);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE music "
            + "SET likes=likes+1 WHERE no=:no", nativeQuery = true)
    public void updateLike(@Param("no") Integer no);
    
    public List<MusicEntity> findByTitleContainingOrSingerContainingOrAlbumContaining(@Param("title") String title, @Param("singer") String singer, @Param("album") String album);
}