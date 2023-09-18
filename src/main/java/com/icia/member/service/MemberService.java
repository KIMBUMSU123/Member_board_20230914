package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.dto.MemberFileDTO;
import com.icia.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) throws IOException {
        if (memberDTO.getMemberProfile().get(0).isEmpty()) {
            // 0번째 인덱스에 파일이없어서 값이 없다
            memberDTO.setFileAttached(0);
            memberRepository.save(memberDTO);
        } else {
            memberDTO.setFileAttached(1);
            MemberDTO savedMember = memberRepository.save(memberDTO);

            for(MultipartFile memberFile: memberDTO.getMemberProfile()) {
                String originalFilename = memberFile.getOriginalFilename();
                System.out.println("originalFilename = " + originalFilename);
                System.out.println(System.currentTimeMillis());
                String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
                System.out.println("storedFileName = " + storedFileName);

                MemberFileDTO memberFileDTO = new MemberFileDTO();
                memberFileDTO.setOriginalFileName(originalFilename);
                memberFileDTO.setStoredFileName(storedFileName);
                memberFileDTO.setMemberId(savedMember.getId());

                String savePath = "D:\\spring_img\\" + storedFileName;
                memberFile.transferTo(new File(savePath));
                // board_file_table 저장 처리
                memberRepository.saveFile(memberFileDTO);
            }
        }
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO dto = memberRepository.login(memberDTO);
        if(dto != null) {
            return true;
        } else {
            return false;
        }
    }
}