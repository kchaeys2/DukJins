package com.duksung.dukjins.src.mark;

import com.duksung.dukjins.domain.Mark;
import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.src.mark.dto.MarkListRes;
import com.duksung.dukjins.src.mark.dto.MarkNameReq;
import com.duksung.dukjins.src.mark.dto.MarkReq;
import com.duksung.dukjins.src.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;
    private final MemberRepository memberRepository;
    //즐겨찾기 생성
    @Transactional
    public void createMark(MarkReq markReq){
        Member member = memberRepository.findOne(markReq.getMember());
        Mark mark = Mark.createMark(member,markReq.getEndPoint(),markReq.getRouteName());
        markRepository.save(mark);
    }
    //즐겨찾기 경로 하나 조회
    public String getMarkOne(Long id){return markRepository.findOne(id);}
    //즐겨찾기 목록 조회
    public List<MarkListRes> getMarkAll(Long id){
        Member member = memberRepository.findOne(id);
        return markRepository.findAll(member);
    }
    //즐겨찾기 이름 수정
    @Transactional
    public void patchMarkName(MarkNameReq nameReq){
        Mark mark = markRepository.changeMark(nameReq.getId());
        mark.setMarkName(nameReq.getName());
    }
    //즐겨찾기 삭제
    @Transactional
    public void deleteMark(Long id){
        Mark mark = markRepository.changeMark(id);
        mark.deleteMark(mark);
    }
}
