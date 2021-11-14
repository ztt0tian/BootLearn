package com.ztt.api.controller;

import com.ztt.api.dto.ApiResponseDto;
import com.ztt.api.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
    @GetMapping("/isOk")
    public ApiResponseDto checkIsOk() {
        return ApiResponseDto.success();
    }

    @GetMapping("/businessException")
    public ApiResponseDto checkBusinessException() {
        throw new BusinessException("业务异常");
    }
    @GetMapping("/nullException")
    public ApiResponseDto checkNullException() {
        throw new NullPointerException("空指针异常");
    }
    @GetMapping("/generalException")
    public ApiResponseDto checkGeneralException() {
        throw new RuntimeException("未知异常");
    }
}
