package com.duksung.dukjins.src.route;

import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.member.MemberRepository;
import com.duksung.dukjins.src.object.ObjectRepository;
import com.duksung.dukjins.src.passPoint.PassPointRepository;
import com.duksung.dukjins.src.route.dto.RouteReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
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

}
