package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseException;
import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.route.model.post.PostObjectReq;
import com.duksung.dukjins.src.route.model.post.PostRouteReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.duksung.dukjins.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
class RouteController {
    private final RouteService routeService;
    //경로 저장
    @ResponseBody
    @PostMapping("/create")
    public BaseResponse<BaseResponseStatus> createRoute(@RequestBody PostRouteReq postRouteReq){
        try{
            return new BaseResponse<>(routeService.createRoute(postRouteReq));
        }catch (BaseException e){
            e.printStackTrace();
            return new BaseResponse<>(POST_CREATEROUTE_FAIL);
        }
    }

    //장애물 저장
    @ResponseBody
    @PostMapping("/object")
    public BaseResponse<BaseResponseStatus> createObj(@RequestBody PostObjectReq postObjectReq){
        try {
            return new BaseResponse<>(routeService.createObj(postObjectReq));
        }catch (BaseException e){
            e.printStackTrace();
            return new BaseResponse<>(POST_CREATEOBJ_FAIL);
        }
    }
}
