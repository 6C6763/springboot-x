package com.gopher.common.response;


/**
 * @author lgc
 * todo:(gopher,2020/10/20,[2020/10/21])
 */
public enum ApiErrEnum {
    CLIENT_ERROR(400,"请稍后重试"),
    INTERNAL_ERR(501,"系统繁忙"),
    SUCCESS(200, "success"),
    DB_OPERATOR_FAIL(600,"数据修改失败"),
    PARAM_ERROR(7001,"请换个姿势再试试")
    ;
    private int code;
    private String msg;

    ApiErrEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
