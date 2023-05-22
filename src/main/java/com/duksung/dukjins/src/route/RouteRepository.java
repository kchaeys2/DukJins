package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.PassPoint;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.domain.RouteStatus;
import com.duksung.dukjins.src.route.dto.RouteSearch;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RouteRepository {
    private final EntityManager em;
    public void save(Route route){
        em.persist(route);
    }
    public void savePP(PassPoint point){ em.persist(point);}
    public Route findOne(Long id){
        return em.find(Route.class,id);
    }
    public List<Route> findAllById(RouteSearch search){
        return em.createQuery("select r from Route r" +
                        " where r.mark = :mark "+
                        " and r.memberId = :memberId ",Route.class)
                .setParameter("mark", 1) //동적쿼리로 변경해야함
                .setParameter("memberId",search.getMemberId())
                .setMaxResults(1000) //최대 1000건
                .getResultList();
    }
}
