package com.duksung.dukjins.src.mark;

import com.duksung.dukjins.config.BaseException;
import com.duksung.dukjins.src.mark.model.GetMarkRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkService {
    private MarkDao markDao;

    @Autowired
    public MarkService(MarkDao markDao) {
        this.markDao = markDao;
    }

    //즐겨찾기 목록 조회
    public List<GetMarkRes> getMark(int userIdx)throws BaseException {
        return markDao.getMark(userIdx);
    }
}
