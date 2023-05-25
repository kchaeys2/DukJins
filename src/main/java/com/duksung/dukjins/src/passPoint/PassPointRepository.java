package com.duksung.dukjins.src.passPoint;

import com.duksung.dukjins.domain.Object;
import com.duksung.dukjins.domain.PassPoint;
import com.duksung.dukjins.domain.Route;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PassPointRepository {
    private final EntityManager em;
    public void saveAll(List<PassPoint> passPoints){
        for(PassPoint passPoint:passPoints){
            em.persist(passPoint);
        }
    }
    public List<PassPoint> findList(Route route){
        return em.createQuery("select routes,point from PassPoint "+
                        "where routes = :routeId", PassPoint.class)
                .setParameter("routeId",route)
                .getResultList();
    }
}
