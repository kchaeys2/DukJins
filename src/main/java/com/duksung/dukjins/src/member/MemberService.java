package com.duksung.dukjins.src.member;

import com.duksung.dukjins.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    //회워가입
    @Transactional
    public Long join(Member member){
        memberRepository.save(member);
        return member.getId();
    }
}
