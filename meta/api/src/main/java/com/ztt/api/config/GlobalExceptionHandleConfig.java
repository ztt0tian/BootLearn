package com.ztt.api.config;

import com.ztt.api.constants.ExceptionConstant;
import com.ztt.api.dto.ApiResponseDto;
import com.ztt.api.enums.ResponseEnum;
import com.ztt.api.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandleConfig {

    @ExceptionHandler(BusinessException.class)
    public ApiResponseDto businessExceptionHandle(BusinessException e) {
        log.error(ExceptionConstant.BUSINESS_EXCEPTION_DESC, e.getMessage());
        return ApiResponseDto.error(ResponseEnum.BUSINESS_ERROR);
    }
    @ExceptionHandler(NullPointerException.class)
    public ApiResponseDto nullExceptionHandle(NullPointerException e) {
        log.error(ExceptionConstant.NULL_EXCEPTION_DESC, e);
        return ApiResponseDto.error(ResponseEnum.SERVER_INTERNAL_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ApiResponseDto generalExceptionHandle(Exception e) {
        log.error(ExceptionConstant.GENERAL_EXCEPTION_DESC, e);
        return ApiResponseDto.error(ResponseEnum.SERVER_INTERNAL_ERROR);
    }
}
