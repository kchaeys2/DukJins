package com.duksung.dukjins.src.user;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.user.model.post.PostJoinReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseBody
    @PostMapping("/join")
    public BaseResponse<BaseResponseStatus> createUser(@RequestBody PostJoinReq postJoinReq){
        try {
            return new BaseResponse<>(userService.createUser(postJoinReq));
        }catch(Exception exception) {
            return new BaseResponse<>(BaseResponseStatus.POST_CREATEUSER_FAIL);
        }
    }

}
