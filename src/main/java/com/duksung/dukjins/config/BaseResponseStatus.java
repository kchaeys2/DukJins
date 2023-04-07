package com.duksung.dukjins.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    POST_CREATEUSER_FAIL(false,1001,"회원가입 실패"),
    POST_CREATEROUTE_FAIL(false,1002,"경로저장 실패"),
    POST_CREATEOBJ_FAIL(false,1003,"장애물 저장 실패"),

    GET_USERMARK_FAIL(false,1004,"즐겨찾기 조회 실패"),;

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
