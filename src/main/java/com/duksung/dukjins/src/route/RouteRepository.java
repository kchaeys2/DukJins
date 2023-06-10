package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.route.dto.RouteRes;
import com.duksung.dukjins.src.route.dto.RouteSearch;
import jakarta.persistence.EntityManager;
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
    // passPoint추가 장애물 피해서 가장 적은 장애물 경로 선택해서 시작점이랑 끝점이랑
    public RouteRes findBestOne(RouteSearch search){
        return em.createQuery("SELECT new com.duksung.dukjins.src.route.dto.RouteRes(r.id, r.startPoint, r.endPoint) " +
                "FROM Object o " +
                "RIGHT JOIN Route r ON o.routes.id = r.id " +
                        "WHERE r.startPoint = :startPoint AND r.endPoint = :endPoint " +
                "GROUP BY r.id " +
                "ORDER BY COUNT(o.id) " +
                "LIMIT 1 ",RouteRes.class)
                .setParameter("startPoint",search.getStartPoint())
                .setParameter("endPoint",search.getEndPoint())
                .getSingleResult();
    }
}
