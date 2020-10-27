package com.gopher.zkd1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author gopher lee
 * @date 2020/10/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class BaseDo {
    protected Date gmtCreateDate;
    protected Date gmtModifyDate;
}
