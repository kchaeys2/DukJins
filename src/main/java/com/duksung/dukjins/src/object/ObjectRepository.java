package com.duksung.dukjins.src.object;

import com.duksung.dukjins.domain.Object;
import com.duksung.dukjins.domain.Point;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.route.dto.RouteRes;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ObjectRepository {
    private final EntityManager em;
    public void saveAll(List<Object> objects){
        for(Object object:objects){
            em.persist(object);
        }
    }
    //List<Point> objectPoint
    public List<Point> findAll(Long id){
        return em.createQuery("select o.point from Object o "+
                "where routes.id = :routeId", Point.class)
                .setParameter("routeId",id)
                .getResultList();
    }
}
