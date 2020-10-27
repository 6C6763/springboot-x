
package com.gopher.zkd2.web;

import com.gopher.common.response.ApiErrEnum;
import com.gopher.common.response.ApiException;
import com.gopher.common.response.ApiResult;
import com.gopher.common.response.ApiResultBuilder;
import com.gopher.common.util.GsonUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.UnexpectedTypeException;
import java.util.Objects;

/**
 * @author 6c6763
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.sanyue.order.web"})
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (!(o instanceof ApiResult)) {
            ApiResult responseResult = new ApiResult(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), o);
            if (o instanceof String) {
                return GsonUtil.GsonToString(responseResult);
            }
            return responseResult;
        }
        return o;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult validationBodyException(MethodArgumentNotValidException exception) {
        String defaultMessage = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        return ApiResultBuilder.customerError(HttpStatus.BAD_REQUEST.value(), defaultMessage);
    }


    @ResponseBody
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ApiResult BusinessExceptionHandler(UnexpectedTypeException ex) {
        return ApiResultBuilder.customerApiResult(ApiErrEnum.PARAM_ERROR.getCode(), ex.getCause().getMessage());
    }

    /**
     * 拦截捕捉业务异常
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ApiResult BusinessExceptionHandler(ApiException ex) {
        return ApiResultBuilder.customerError(ex.getErrCode(), ex.getErrMsg());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResult errorHandler(Exception ex) {
        ex.printStackTrace();
        return ApiResultBuilder.customerApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

}