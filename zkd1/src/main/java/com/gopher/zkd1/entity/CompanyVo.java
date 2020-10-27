package com.gopher.zkd1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author gopher lee
 * @date 2020/10/20
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompanyVo extends CompanyDo implements Serializable {

    private static final long serialVersionUID = -775598348495796036L;
}
