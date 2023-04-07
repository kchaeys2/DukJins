package com.duksung.dukjins.src.mark;

import com.duksung.dukjins.config.BaseException;
import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.mark.model.GetMarkRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
@RequiredArgsConstructor
public class MarkController {
    private final MarkService markService;
    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<List<GetMarkRes>> getMark(@PathVariable("userIdx") int userIdx){
        try {
            return new BaseResponse<>(markService.getMark(userIdx));
        }catch (BaseException e){
            e.printStackTrace();
            return new BaseResponse<>(BaseResponseStatus.GET_USERMARK_FAIL);
        }
    }
}
