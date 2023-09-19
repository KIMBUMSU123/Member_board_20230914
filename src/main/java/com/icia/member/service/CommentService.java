package com.icia.member.service;

import com.icia.member.dto.PageDTO;
import com.icia.member.dto.PostDTO;
import com.icia.member.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    public  boolean save(PostDTO postDTO) {
        int result = commentRepository.save(postDTO);
        System.out.println(postDTO + " service");
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

}
