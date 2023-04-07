package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseException;
import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
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
}
