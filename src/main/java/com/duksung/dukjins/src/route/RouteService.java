package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseException;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.route.model.post.PostRouteReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.duksung.dukjins.config.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class RouteService {
    private RouteDao routeDao;

    @Autowired
    public RouteService(RouteDao routeDao) {
        this.routeDao = routeDao;
    }

    public BaseResponseStatus createRoute(PostRouteReq postRouteReq)throws BaseException{
        try {
            return routeDao.createRoute(postRouteReq);
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseException(POST_CREATEROUTE_FAIL);
        }
    }
}
