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
//에헤이조젔네이거
    @PostMapping("/list")
        private String boardListForm(){
            return "boardPages/boardList";
    }

    @GetMapping("/list")
    public String findAll(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                          @RequestParam(value = "q", required = false, defaultValue = "") String q,
                          @RequestParam(value = "type", required = false, defaultValue = "boardTitle") String type,
                          Model model) {
        // 검색이든 아니든 필요한 정보: boardList, paging
        List<PostDTO> postDTOList = null;
        PageDTO pageDTO = null;


        // 검색요정인자 아닌지 구분
        if(q.equals("")){
            //일반 페이지 요청
            postDTOList = commentService.pagingList(page);
            pageDTO = commentService.pageNumber(page);
        }else{
            // 검색 페이지 요청
            postDTOList = commentService.searchList(q, type, page);
            pageDTO = commentService.searchPageNumber(q, type, page);
        }
        model.addAttribute("boardList", postDTOList);
        model.addAttribute("paging", pageDTO);
        model.addAttribute("q",q);
        model.addAttribute("type",type);
        model.addAttribute("page",page);
        return "boardPages/boardList";
    }
}
