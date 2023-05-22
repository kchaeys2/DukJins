package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.domain.Member;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.domain.RouteStatus;
import com.duksung.dukjins.src.member.dto.MemberReq;
import com.duksung.dukjins.src.route.dto.RouteReq;
import com.duksung.dukjins.src.route.dto.RouteSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;
    //경로생성
    @ResponseBody
    @PostMapping("/new")
    public BaseResponse<BaseResponseStatus> create(@RequestBody RouteReq routeReq){
        Route route = Route.createRoute(routeReq.getMemberId(), routeReq.getRouteName(), routeReq.getStartPoint(), routeReq.getEndPoint(), routeReq.getStatus(),
                routeReq.getMark(),routeReq.getGood());
        routeService.save(route);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //즐겨찾기 취소
    @ResponseBody
    @PatchMapping("/{userId}/mark")
    public BaseResponse<BaseResponseStatus> markCancel(@PathVariable("userId")Long memberId){
        routeService.cancelMark(memberId);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //즐겨찾기 경로 조회
    @ResponseBody
    @GetMapping("/{userId}/mark")
    public BaseResponse<List<Route>> getMarks(@PathVariable("userId")Long memberId){
        RouteSearch search = new RouteSearch(memberId);
        return new BaseResponse<>(routeService.getMarks(search));
    }
}
