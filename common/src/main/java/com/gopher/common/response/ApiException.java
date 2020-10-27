package com.gopher.common.response;


/**
 * @author lgc
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 4097645005827006529L;
    private Integer errCode;
    private String errMsg;

    public ApiException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ApiException(ApiResult<?> responseResult) {
        super(responseResult.getMsg());
        this.errCode = responseResult.getCode();
        this.errMsg = responseResult.getMsg();
    }

    public ApiException(ApiErrEnum apiErrEnum) {
        super(apiErrEnum.getMsg());
        this.errMsg = apiErrEnum.getMsg();
        this.errCode = apiErrEnum.getCode();
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
