package com.icia.member.repository;

import com.icia.member.dto.MemberDTO;
import com.icia.member.dto.PageDTO;
import com.icia.member.dto.PostDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(PostDTO postDTO) {

        return sql.insert("Comment.save",postDTO);
    }

    public List<PostDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Comment.pagingList", pagingParams);
    }

    public int boardCount() {
        return sql.selectOne("Comment.count");
    }

    public List<PostDTO> searchList(Map<String, Object> searchParam) {
        return sql.selectList("Comment.search", searchParam);
    }

    public int boardSearchCount(Map<String, String> pagingParams) {
        return sql.selectOne("Comment.searchCount", pagingParams);
    }

    public List<PostDTO> findAll() {
        return sql.selectList("Comment.findAll");
    }


    public PostDTO findbyId(Long id) {
        return sql.selectOne("Comment.findById",id);
    }

    public void updateHits(Long id) {
        sql.update("Comment.updateHits",id);
    }
}
