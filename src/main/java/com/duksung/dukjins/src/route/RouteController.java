package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
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
    //장애물 적은거 조회
    @ResponseBody
    @GetMapping("/{startPoint}/{endPoint}")
    public BaseResponse<RouteRes> getRouteBest(@PathVariable("startPoint") String startPoint,
                                               @PathVariable("endPoint") String endPoint){
        RouteSearch search = new RouteSearch(startPoint, endPoint);
        return new BaseResponse<>(routeService.getRouteBest(search));
    }
}
