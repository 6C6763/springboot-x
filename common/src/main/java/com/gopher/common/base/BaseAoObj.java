package com.gopher.common.base;

import lombok.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author gopher lee
 * @date 2020/10/21
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BaseAoObj implements Serializable {

    private static final long serialVersionUID = -2312618340219479914L;
    protected Integer pageNo;
    protected Integer pageSize;
    protected Date createTimeStart;
    protected Date createTimeEnd;


}
