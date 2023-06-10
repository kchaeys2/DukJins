package com.duksung.dukjins.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @Column
    private String endPoint;
    @Column
    private String markName;
    @Enumerated(EnumType.STRING)
    private MarkStatus status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    //생성자
    public static Mark createMark(Member member,String endPoint,String markName){
        Mark mark = new Mark();
        mark.member = member;
        mark.endPoint = endPoint;
        if(markName == null){
            mark.markName = endPoint;
        }else{
            mark.markName = markName;
        }
        mark.createAt = LocalDateTime.now();
        mark.status = MarkStatus.ACTIVE;
        return mark;
    }
    //즐겨찾기 삭제
    public void deleteMark(Mark mark){
        mark.status = MarkStatus.INACTIVE;
        mark.updateAt = LocalDateTime.now();
    }
    //즐겨찾기 이름 수정
    public void setMarkName(String markName){
        this.markName = markName;
    }
}
