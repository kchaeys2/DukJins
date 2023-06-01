package com.duksung.dukjins.src.passPoint;

import com.duksung.dukjins.domain.Object;
import com.duksung.dukjins.domain.PassPoint;
import com.duksung.dukjins.domain.Point;
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
    public List<Point> findAll(Long routeId){
        return em.createQuery("select p.point from PassPoint p "+
                        "where routes.id = :routeId", Point.class)
                .setParameter("routeId",routeId)
                .getResultList();
    }
}
