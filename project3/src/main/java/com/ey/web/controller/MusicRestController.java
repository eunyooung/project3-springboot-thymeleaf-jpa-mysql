package com.ey.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.web.dao.*;

@RestController
public class MusicRestController {
    
    @Autowired
    private MusicDAO dao;

    @PostMapping("/music/like")
    public String music_detail(int no) {
        
        dao.updateLike(no);
        
        return "yes";
    }
}