package com.gopher.zkd1.service;


import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.response.PageResponse;
import com.gopher.zkd1.entity.CompanyDo;
import com.gopher.zkd1.entity.ao.InsertCompanyAo;
import com.gopher.zkd1.entity.ao.ModifyCompanyAo;

/**
 * @author gopher lee
 * @date 2020/10/20
 */
public interface CompanyService {

    /**
     * 添加接入企业信息
     * @param insertCompanyAo ao
     * @return companyDo
     */
    CompanyDo saveCompany(InsertCompanyAo insertCompanyAo);

    /**
     * 接入企业列表
     * @param queryCompanyAo ao
     * @return page<list>
     */
    PageResponse<CompanyDto> listCompany(QueryCompanyAo queryCompanyAo);

    /**
     * 删除接入企业
     * @param id pk
     */
    void deleteCompany(Long id);

    /**
     * 修改接入企业信息
     * @param modifyCompanyAo ao
     */
    void modifyCompany(ModifyCompanyAo modifyCompanyAo);
}
