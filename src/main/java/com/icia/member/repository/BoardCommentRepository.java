package com.icia.member.repository;

import com.icia.member.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardCommentRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public void save(CommentDTO commentDTO) {
        sql.insert("Board_Comment.save",commentDTO);

    }

    public List<CommentDTO> findALl(int boardId) {
        return sql.selectList("Board_Comment.findAll",boardId);
    }
}
