package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Route;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RouteRepository {
    private final EntityManager em;
    public void save(Route route){
        em.persist(route);
    }
    public Route findOne(Long id){
        return em.find(Route.class,id);
    }
//    public List<Route> findAllById(RouteSearch search){
//        return em.createQuery("select r from Route r" +
//                        " where r.mark = :mark "+
//                        " and r.memberId = :memberId ",Route.class)
//                .setParameter("mark", 1) //동적쿼리로 변경해야함
//                .setParameter("memberId",search.getMember())
//                .setMaxResults(1000) //최대 1000건
//                .getResultList();
//    }
}
