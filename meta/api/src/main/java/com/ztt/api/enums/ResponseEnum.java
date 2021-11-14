package com.ztt.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum {
    OK("200", "成功"),
    PARAM_ERROR("Ox10001", "请求参数格式错误"),
    NOT_FOUND("Ox10002", "路径不存在"),
    SERVER_INTERNAL_ERROR("Ox10003", "服务器内部错误"),
    SERVER_BUSY_ERROR("Ox10004", "服务器繁忙"),
    TOKEN_ERROR("Ox10005", "token错误"),
    SIGNATURE_ERROR("Ox10006", "签名错误"),
    BUSINESS_ERROR("Ox10007", "业务异常"),
    ;
    private String responseCode;
    private String responseMsg;
}