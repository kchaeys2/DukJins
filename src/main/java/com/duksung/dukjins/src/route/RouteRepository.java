package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.route.dto.RouteChangeName;
import com.duksung.dukjins.src.route.dto.RouteListRes;
import com.duksung.dukjins.src.route.dto.RouteRes;
import com.duksung.dukjins.src.route.dto.RouteSearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RouteRepository {
    private final EntityManager em;
    public void save(Route route){
        em.persist(route);
    }
    //경로 그냥 하나 조회 id로
    public RouteRes findOne(Long id){
        return em.createQuery("select new com.duksung.dukjins.src.route.dto.RouteRes(r.id,r.startPoint,r.endPoint,r.routeName) from Route r" +
                " where r.id = :id",RouteRes.class)
                .setParameter("id",id)
                .getSingleResult();
    }
    //즐겨찾기 목록
    public List<RouteListRes> findAllMark(Member member){
        List<RouteListRes> resultList = em.createQuery("select new com.duksung.dukjins.src.route.dto.RouteListRes(r.id, r.routeName) " +
                        "from Route r where r.member = :member and r.mark = 1", RouteListRes.class)
                .setParameter("member", member)
                .getResultList();
        return resultList;
    }
    // passPoint추가 장애물 피해서 가장 적은 장애물 경로 선택해서 시작점이랑 끝점이랑
    public RouteRes findBestOne(RouteSearch search){
        return em.createQuery("SELECT new com.duksung.dukjins.src.route.dto.RouteRes(r.id, r.startPoint, r.endPoint, r.routeName) " +
                "FROM Object o " +
                "JOIN Route r ON o.routes.id = r.id " +
                        "WHERE r.startPoint = :startPoint AND r.endPoint = :endPoint " +
                "GROUP BY r.id " +
                "ORDER BY COUNT(o.id) " +
                "LIMIT 1 ",RouteRes.class)
                .setParameter("startPoint",search.getStartPoint())
                .setParameter("endPoint",search.getEndPoint())
                .getSingleResult();
    }
    //즐겨찾기 취소
    public Route changeMark(Long id){
        return em.find(Route.class,id);
    }
    //routeName 변경
    public Route changeRouteName(RouteChangeName changeName){
        return em.find(Route.class,changeName.getId());
    }
}
