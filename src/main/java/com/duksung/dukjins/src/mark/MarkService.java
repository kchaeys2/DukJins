package com.duksung.dukjins.src.mark;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkService {
    private MarkDao markDao;

    @Autowired
    public MarkService(MarkDao markDao) {
        this.markDao = markDao;
    }
}
