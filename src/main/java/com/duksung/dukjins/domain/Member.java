package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(nullable = false,length = 50)
    private String nickname;
    @Column(nullable = false,length = 100)
    private String email;
    @Column(nullable = false)
    private String pw;
    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    private LocalDateTime createAt;
    //생성자
    public static Member creatMember(String nickname,String email,String pw,
                                     MemberStatus status){
        Member member = new Member();
        member.nickname = nickname;
        member.email = email;
        member.pw = pw;
        member.createAt = LocalDateTime.now();
        if(status != null){
            member.status = status;
        }else{
            member.status = MemberStatus.ACTIVE;
        }
        return member;
    }
    //탈퇴
    //비밀번호 변경
}
