package com.duksung.dukjins.src.object;

import com.duksung.dukjins.domain.Object;
import com.duksung.dukjins.domain.Route;
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
    public List<Object> findList(Route route){
        return em.createQuery("select routes,point from Object "+
                "where routes = :routeId", Object.class)
                .setParameter("routeId",route)
                .getResultList();
    }
}
