package com.gopher.zkd1.entity.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 6c6763
 * @date 2020/10/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "添加企业信息")
public class InsertCompanyAo {

    @ApiModelProperty(value = "企业名称")
    @NotBlank(message = "企业名称必填")
    protected String companyName;
    @ApiModelProperty(value = "企业电话")
    @NotBlank(message = "企业电话必填")
    protected String companyTel;
    @ApiModelProperty(value = "企业邮箱")
    @NotBlank(message = "企业邮箱必填")
    protected String companyMail;
    @ApiModelProperty(value = "企业接入人身份")
    @NotBlank(message = "企业对接人类型必填")
    protected String companyLinkType;
    @ApiModelProperty(value = "企业规模人数")
    @NotNull(message = "企业规模必填")
    @Max(200)
    @Min(10)
    protected Integer companyHc;
}
