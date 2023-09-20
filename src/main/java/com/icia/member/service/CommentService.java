package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
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

    public List<PostDTO> findAll(){
        return commentRepository.findAll();
    }
    public List<PostDTO> pagingList(int page) {
        int pageLimit = 5; // 한페이지당 보여줄 글 갯수
        int pagingStart = (page - 1) * pageLimit; // 요청한 페이지에 보여줄 첫번째 게시글의 순서
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        return commentRepository.pagingList(pagingParams);
    }

    public PageDTO pageNumber(int page) {
        int pageLimit = 3; // 한페이지에 보여줄 글 갯수
        int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
        // 전체 글 갯수 조회
        int boardCount = commentRepository.boardCount();
        // 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double)boardCount / pageLimit));
        // 시작 페이지 값 계산(1, 4, 7, 10 ~~)
        int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 마지막 페이지 값 계산(3, 6, 9, 12 ~~)
        int endPage = startPage + blockLimit - 1;
        // 전체 페이지 갯수가 계산한 endPage 보다 작을 때는 endPage 값을 maxPage 값과 같게 세팅
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setStartPage(startPage);
        return pageDTO;
    }

    public List<PostDTO> searchList(String q, String type, int page) {
        Map<String, Object> searchParam = new HashMap<>();
        searchParam.put("q", q);
        searchParam.put("type", type);

        int pageLimit = 3; // 한페이지당 보여줄 글 갯수
        int pagingStart = (page - 1) * pageLimit; // 요청한 페이지에 보여줄 첫번째 게시글의 순서
        searchParam.put("start", pagingStart);
        searchParam.put("limit", pageLimit);

        return commentRepository.searchList(searchParam);
    }

    public PageDTO searchPageNumber(String q, String type, int page) {
        int pageLimit = 3; // 한페이지에 보여줄 글 갯수
        int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
        Map<String, String> pagingParams = new HashMap<>();
        pagingParams.put("q", q);
        pagingParams.put("type", type);
        // 검색어 기준 글 갯수 조회
        int boardCount = commentRepository.boardSearchCount(pagingParams);
        // 검색어 기준 전체 페이지 갯수 계산
        int maxPage = (int) (Math.ceil((double)boardCount / pageLimit));
        // 검색어 기준 시작 페이지 값 계산(1, 4, 7, 10 ~~)
        int startPage = (((int)(Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
        // 검색어 기준 마지막 페이지 값 계산(3, 6, 9, 12 ~~)
        int endPage = startPage + blockLimit - 1;
        // 검색어 기준 전체 페이지 갯수가 계산한 endPage 보다 작을 때는 endPage 값을 maxPage 값과 같게 세팅
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setStartPage(startPage);
        return pageDTO;
    }


    public PostDTO findById(Long id) {
        PostDTO postDTO = commentRepository.findbyId(id);
        return postDTO;
    }

    public void updateHits(Long id) {
        commentRepository.updateHits(id);
    }
}
