package com.gopher.api.service.dubbo.company.dto;

import com.gopher.common.base.BaseAoObj;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author gopher lee
 * @date 2020/10/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompanyDto extends BaseAoObj {

    private static final long serialVersionUID = -9126091054778749154L;

    private Long id;
    private String companyName;
    private String companyTel;
    private String companyMail;
    private String companyLinkType;
    private String companyHc;
}
