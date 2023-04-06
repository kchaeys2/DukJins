package com.duksung.dukjins.src.route;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {
    private RouteDao memberDao;

    @Autowired
    public RouteService(RouteDao memberDao) {
        this.memberDao = memberDao;
    }
}
