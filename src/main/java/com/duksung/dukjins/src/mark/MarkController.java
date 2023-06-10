package com.duksung.dukjins.src.mark;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.mark.dto.MarkListRes;
import com.duksung.dukjins.src.mark.dto.MarkNameReq;
import com.duksung.dukjins.src.mark.dto.MarkReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
@RequiredArgsConstructor
public class MarkController {
    private final MarkService markService;

    //즐겨찾기 생성
    @ResponseBody
    @PostMapping("/new")
    public BaseResponse<BaseResponseStatus> create(@RequestBody MarkReq markReq){
        markService.createMark(markReq);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //즐겨찾기 하나 조회
    @ResponseBody
    @GetMapping("/{routeId}")
    public BaseResponse<String> getMarkOne(@PathVariable("routeId") Long id){
        return new BaseResponse<>(markService.getMarkOne(id));
    }
    //즐겨찾기 목록 조회
    @ResponseBody
    @GetMapping("/list/{userId}")
    public BaseResponse<List<MarkListRes>> getMarkAll(@PathVariable("userId") Long id) {
        return new BaseResponse<>(markService.getMarkAll(id));
    }
    //즐겨찾기 이름 변경
    @ResponseBody
    @PatchMapping("/{routeId}")
    public BaseResponse<BaseResponseStatus> changeMarkName(@RequestBody MarkNameReq nameReq){
        markService.patchMarkName(nameReq);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
    //즐겨찾기 삭제
    @ResponseBody
    @PatchMapping("/{routeId}/delete")
    public BaseResponse<BaseResponseStatus> changeMarkDelete(@PathVariable("routeId") Long id){
        markService.deleteMark(id);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
