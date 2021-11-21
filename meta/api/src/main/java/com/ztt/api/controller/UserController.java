package com.ztt.api.controller;

import com.ztt.api.dto.ApiResponseDto;
import com.ztt.api.dto.user.UserAddDto;
import com.ztt.api.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ztt.api.enums.ResponseEnum.BUSINESS_ERROR;

@RestController
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/userRegister")
    public ApiResponseDto registerUser(@RequestBody @Validated UserAddDto addDto) {
        if (sysUserService.registerUser(addDto) > 0) {
            return ApiResponseDto.success();
        }
        return ApiResponseDto.error(BUSINESS_ERROR);
    }
}
