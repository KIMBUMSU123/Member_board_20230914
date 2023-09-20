package com.icia.member.service;

import com.icia.member.dto.CommentDTO;
import com.icia.member.repository.BoardCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentService {
    @Autowired
    private BoardCommentRepository boardCommentRepository;
    public void save(CommentDTO commentDTO) {
        boardCommentRepository.save(commentDTO);
    }

    public List<CommentDTO> findAll(int boardId) {
        return boardCommentRepository.findALl(boardId);
    }
}
