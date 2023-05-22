package com.duksung.dukjins.src.member;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.src.member.dto.MemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    //회원가입
    @ResponseBody
    @PostMapping("/new")
    public BaseResponse<BaseResponseStatus> create(@RequestBody MemberReq memberReq){
        Member member = Member.creatMember(memberReq.getNickname(),memberReq.getEmail(),memberReq.getPw(),
                memberReq.getStatus());
        memberService.join(member);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
