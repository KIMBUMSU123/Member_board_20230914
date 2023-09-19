package com.icia.member.controller;
import com.icia.member.dto.PageDTO;
import com.icia.member.dto.PostDTO;
import com.icia.member.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/save")
    private String boardsaveForm(){
        return "boardPages/boardSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PostDTO postDTO) {
        boolean result =commentService.save(postDTO);
        if(result){
        return "/memberPages/memberMain";
        }else{
            return "/memberPages/memberMain";

        }
    }

    @GetMapping("/list")
    private String boardListForm(){
        return "boardPages/boardList";
    }
}
