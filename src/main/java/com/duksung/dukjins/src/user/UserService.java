package com.duksung.dukjins.src.user;

import com.duksung.dukjins.config.BaseException;
import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.route.RouteDao;
import com.duksung.dukjins.src.user.model.post.PostJoinReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.duksung.dukjins.config.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public BaseResponseStatus createUser(PostJoinReq postJoinReq)throws BaseException{
        try {
            return userDao.createUser(postJoinReq);
        } catch (Exception e){
            e.printStackTrace();
            throw new BaseException(POST_CREATEUSER_FAIL);
        }
    }
}
