package com.duksung.dukjins.src.mark;

import com.duksung.dukjins.domain.Mark;
import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.src.mark.dto.MarkListRes;
import com.duksung.dukjins.src.mark.dto.MarkNameReq;
import com.duksung.dukjins.src.route.dto.RouteRes;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarkRepository {
    private final EntityManager em;
    public void save(Mark mark){
        em.persist(mark);
    }
    //즐겨찾기 경로 하나 조회
    public String findOne(Long id){
        return em.createQuery("select r.endPoint from Mark r" +
                        " where r.id = :id",String.class)
                .setParameter("id",id)
                .getSingleResult();
    }
    //즐겨찾기 목록 조회
    public List<MarkListRes> findAll(Member member){
        return em.createQuery("select new com.duksung.dukjins.src.mark.dto.MarkListRes(m.markName,m.id) from Mark m " +
                "where m.member = :member and m.status = 'ACTIVE'",MarkListRes.class)
                .setParameter("member",member)
                .getResultList();
    }
    //즐겨찾기 이름 수정 및 삭제
    public Mark changeMark(Long id){
        return em.find(Mark.class,id);
    }
}
