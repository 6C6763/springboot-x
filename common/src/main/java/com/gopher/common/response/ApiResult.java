package com.gopher.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 统一接口返回
 * @author lgc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApiResult<T>{
    private Integer code;
    private String msg;
    private T data;
}
