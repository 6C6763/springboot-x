package com.gopher.zkd1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gopher lee
 * @date 2020/10/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "didi_company")
public class CompanyDo {

    @Id
    protected Long id;
    protected String companyName;
    protected String companyTel;
    protected String companyMail;
    @Column(name = "contacts_type")
    protected String companyLinkType;
    protected String companyHc;
    @Column(name = "gmt_create")
    protected Date gmtCreateDate;
    @Column(name = "gmt_modify")
    private Date gmtModifyDate;
}
