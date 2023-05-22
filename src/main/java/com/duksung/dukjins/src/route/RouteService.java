package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.route.dto.RouteReq;
import com.duksung.dukjins.src.route.dto.RouteSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    @Transactional
    public void save(Route route){
        routeRepository.save(route);
    }
    @Transactional
    public void cancelMark(Long routeId){
        Route route = routeRepository.findOne(routeId);
        route.markCancel();
    }
    public List<Route> getMarks(RouteSearch search){
        return routeRepository.findAllById(search);
    }
}
