package com.example.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @since       2023.09.06
 * @author      jerry
 * @description exception code
 **********************************************************************************************************************/
@Getter
@AllArgsConstructor
public enum ExceptionCode {

    // E0000xx 공통
    // E0001xx 유저
    E000100(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
