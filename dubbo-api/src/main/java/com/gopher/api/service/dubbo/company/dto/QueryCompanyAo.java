package com.gopher.api.service.dubbo.company.dto;


import com.gopher.common.base.BaseAoObj;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gopher lee
 * @date 2020/10/20
 */
@ApiModel(value = "查询接入企业用户请求")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryCompanyAo extends BaseAoObj implements Serializable {

    private static final long serialVersionUID = -1859850721007430950L;
    @ApiModelProperty("企业名字")
    private String companyName;
    @ApiModelProperty("企业电话")
    private String companyTel;
    @ApiModelProperty("企业接入开始信息")
    private Date accessStartTime;
    @ApiModelProperty("企业接入截止时间")
    private Date accessEndTime;
}
