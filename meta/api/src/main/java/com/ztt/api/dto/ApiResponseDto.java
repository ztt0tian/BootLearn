package com.ztt.api.dto;

import com.ztt.api.enums.ResponseEnum;
import lombok.Data;

@Data
public class ApiResponseDto {
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private Object data;

    public static ApiResponseDto success() {
        return success(null);
    }
    public static ApiResponseDto success(Object data) {
        ApiResponseDto dto = new ApiResponseDto();
        dto.setCode(ResponseEnum.OK.getResponseCode());
        dto.setMsg(ResponseEnum.OK.getResponseMsg());
        dto.setData(data);
        return dto;
    }

    public static ApiResponseDto error(ResponseEnum responseEnum) {
        return error(responseEnum.getResponseCode(), responseEnum.getResponseMsg());
    }

    public static ApiResponseDto error(String code, String msg) {
        ApiResponseDto dto = new ApiResponseDto();
        dto.setCode(code);
        dto.setMsg(msg);
        return dto;
    }
}
