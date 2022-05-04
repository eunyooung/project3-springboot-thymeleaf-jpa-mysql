package com.ey.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "music")
@Setter
@Getter
public class MusicEntity {
    
    @Id
    int no;
    int cate;
    int ranks;
    int increments;
    String state;
    String title;
    String album;
    String singer;
    String genre;
    String time;
    String writer1; // 작사가
    String writer2; // 작곡가
    String editor;  // 편곡
    String lyric;
    String youtube;
    String poster;
    int likes;
}
