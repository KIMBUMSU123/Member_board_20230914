package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public void save(MemberDTO memberDTO) throws IOException {
        if (memberDTO.getMemberProfile().get(0).isEmpty()) {
            // 파일이 없을 경우
            memberDTO.setMemberProfile(0);
            memberRepository.save(memberDTO);
        }
    }
}