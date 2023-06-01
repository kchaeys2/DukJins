package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.domain.Route;
import com.duksung.dukjins.src.route.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
@Slf4j
public class RouteController {
    private final RouteService routeService;
    //경로생성
    @ResponseBody
    @PostMapping("/new")
    public BaseResponse<BaseResponseStatus> create(@RequestBody RouteReq routeReq){
        log.info(String.valueOf(routeReq.getPassPoints().get(0).getPointX()));
        routeService.save(routeReq);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //즐겨찾기 취소
    @ResponseBody
    @PatchMapping("/{userId}/mark")
    public BaseResponse<BaseResponseStatus> markCancel(@PathVariable("userId")Long memberId){
        routeService.patchMark(memberId);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //이름 변경
    @ResponseBody
    @PatchMapping("/changeName")
    public BaseResponse<BaseResponseStatus> patchName(@RequestBody RouteChangeName name){
        routeService.patchName(name);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //즐겨찾기 목록 조회
    @ResponseBody
    @GetMapping("/{userId}")
    public BaseResponse<List<RouteListRes>> getRoutes(@PathVariable("userId")Long memberId){
        return new BaseResponse<>(routeService.getRoutes(memberId));
    }
    //그냥 즐겨찾기 조회
    @ResponseBody
    @GetMapping("/{routeId}/mark")
    public BaseResponse<RouteRes> getRoute(@PathVariable("routeId") Long id){
        return new BaseResponse<>(routeService.getRouteOne(id));
    }
    //장애물 적은거 조회
    @ResponseBody
    @GetMapping("/{startPoint}/{endPoint}")
    public BaseResponse<RouteRes> getRouteBest(@PathVariable("startPoint") String startPoint,
                                               @PathVariable("endPoint") String endPoint){
        RouteSearch search = new RouteSearch(startPoint, endPoint);
        return new BaseResponse<>(routeService.getRouteBest(search));
    }
}
