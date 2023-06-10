package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.domain.Point;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.member.MemberRepository;
import com.duksung.dukjins.src.object.ObjectRepository;
import com.duksung.dukjins.src.passPoint.PassPointRepository;
import com.duksung.dukjins.src.route.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class RouteService {
    private final RouteRepository routeRepository;
    private final MemberRepository memberRepository;
    private final ObjectRepository objectRepository;
    private final PassPointRepository passPointRepository;

    @Transactional
    public void save(RouteReq routeReq){
        Member member = memberRepository.findOne(routeReq.getMemberId());

        Route route = Route.createRoute(member,routeReq.getStartPoint(),routeReq.getEndPoint(),routeReq.getGood(),routeReq.getStatus(),
                routeReq.getPassPoints(),routeReq.getObjectPoints());
        //route table 저장
        routeRepository.save(route);
        //object table 저장
        objectRepository.saveAll(route.getObjects());
        //passPoint table 저장
        passPointRepository.saveAll(route.getPassPoints());
    }
    //경로조회 시작점이랑 끝점이용해서 조회
    public RouteRes getRouteBest(RouteSearch search) {
        RouteRes routeRes = routeRepository.findBestOne(search);
        List<Point> passPoints = passPointRepository.findAll(routeRes.getId());
        List<Point> objectPoints = objectRepository.findAll(routeRes.getId());
        for (Point passPoint : passPoints) {
            routeRes.addPassPoint(passPoint);
        }
        for (Point objectPoint : objectPoints) {
            routeRes.addObjectPoint(objectPoint);
        }
        return routeRes;
    }
}
