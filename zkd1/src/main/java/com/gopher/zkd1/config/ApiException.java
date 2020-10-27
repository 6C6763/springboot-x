package com.gopher.zkd1.config;


import com.gopher.common.response.ApiResult;

/**
 * @author 6c6763
 * @date 2020/10/22
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 3819168867266786744L;
    private Integer code;
    private String msg;

    public ApiException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ApiException(ApiResult apiResult) {
        super(apiResult.getMsg());
        this.code = apiResult.getCode();
        this.msg = apiResult.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
