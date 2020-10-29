package com.gopher.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
@TableName(value = "didi_company")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Company {
    @TableId(type = IdType.INPUT)
    private  Long id;
    @TableField("company_name")
    private String companyName;
    @TableField("company_tel")
    private String companyTel;
    @TableField("company_mail")
    private String companyMail;
    @TableField("company_link_type")
    private String companyLinkType;
    @TableField("company_hc")
    private String companyHc;
}
