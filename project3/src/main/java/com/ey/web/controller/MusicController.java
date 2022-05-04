package com.ey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.ey.web.dao.*;
import com.ey.web.entity.*;

@Controller
public class MusicController {

    @Autowired
    private MusicDAO dao;
    
    @RequestMapping("/")
    public String main() {
        return "redirect:/music";
    }
    
    @GetMapping("/music")
    public String music(String cate, String page, Model model) {
        
        String[] title = {"TOP-200", "가요", "POP", "OST", "재즈", "클래식", "동요"};
        if (page == null) page = "1";
        if (cate == null) cate = "1";
        int curpage = Integer.parseInt(page);
        int rowSize = 100;
        int start = (rowSize * curpage) - rowSize;
        
        List<MusicEntity> list = dao.musicList(Integer.parseInt(cate), start);
        int totalpage = dao.musicTotalPage(Integer.parseInt(cate));
        final int BLOCK = 10;
        int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
        int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
         
        if (endPage > totalpage)
            endPage = totalpage;
        
        model.addAttribute("curpage", curpage);
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("cate", cate);
        model.addAttribute("title", title[Integer.parseInt(cate)-1]);
        model.addAttribute("list", list);
        model.addAttribute("main_content", "music/list");
        return "main";
    }
    
    @GetMapping("/music/search")
    public String music_search(@RequestParam(value = "search") String search, Model model) {
        
        List<MusicEntity> list = dao.findByTitleContainingOrSingerContainingOrAlbumContaining(search, search, search);
        model.addAttribute("list", list);
        model.addAttribute("main_content", "music/search");
        return "main";
    }
    
    @GetMapping("/music/detail")
    public String music_detail(String no, Model model) {
        
        MusicEntity vo = dao.findByNo(Integer.parseInt(no));
        model.addAttribute("vo", vo);
        model.addAttribute("main_content", "music/detail");
        return "main";
    }
}