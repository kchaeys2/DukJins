package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.domain.Object;
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

        Route route = Route.createRoute(member,routeReq.getRouteName(),routeReq.getStartPoint(),routeReq.getEndPoint(),routeReq.getMark(),routeReq.getGood(),routeReq.getStatus(),
                routeReq.getPassPoints(),routeReq.getObjectPoints());
        //route table 저장
        routeRepository.save(route);
        //object table 저장
        objectRepository.saveAll(route.getObjects());
        //passPoint table 저장
        passPointRepository.saveAll(route.getPassPoints());
    }
//    @Transactional
//    public void cancelMark(Long routeId){
//        Route route = routeRepository.findOne(routeId);
//        route.markCancel();
//    }
//    public List<Route> getMarks(RouteSearch search){
//        return routeRepository.findAllById(search);
//    }
    //즐겨찾기 경로 조회 id로
    public RouteRes getRouteOne(Long id){
        RouteRes routeRes = routeRepository.findOne(id);
        List<Point> passPoints = passPointRepository.findAll(id);
        List<Point> objectPoints = objectRepository.findAll(id);
        for(Point passPoint : passPoints){
            routeRes.addPassPoint(passPoint);
        }
        for (Point objectPoint : objectPoints){
            routeRes.addObjectPoint(objectPoint);
        }
        return routeRes;
    }
    //즐겨찾기 목록 조회
    public List<RouteListRes> getRoutes(Long memberId){
        Member member = memberRepository.findOne(memberId);
        return routeRepository.findAllMark(member);
    }
    //경로조회 시작점이랑 끝점이용해서 조회
    public RouteRes getRouteBest(RouteSearch search){
        RouteRes routeRes = routeRepository.findBestOne(search);
        List<Point> passPoints = passPointRepository.findAll(routeRes.getId());
        List<Point> objectPoints = objectRepository.findAll(routeRes.getId());
        for(Point passPoint : passPoints){
            routeRes.addPassPoint(passPoint);
        }
        for (Point objectPoint : objectPoints){
            routeRes.addObjectPoint(objectPoint);
        }
        return routeRes;
    }
    //즐겨찾기 취소
    @Transactional
    public void patchMark(Long id){
        Route route = routeRepository.changeMark(id);
        route.setMark(0);
    }
    //routeName 변경
    @Transactional
    public void patchName(RouteChangeName name){
        Route route = routeRepository.changeRouteName(name);
        route.setRouteName(name.getRouteName());
    }
}
