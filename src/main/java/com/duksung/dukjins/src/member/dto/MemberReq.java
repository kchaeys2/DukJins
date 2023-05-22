package com.duksung.dukjins.src.member.dto;

import com.duksung.dukjins.domain.MemberStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberReq {
    private String nickname;
    private String email;
    private String pw;
    private MemberStatus status;
}
