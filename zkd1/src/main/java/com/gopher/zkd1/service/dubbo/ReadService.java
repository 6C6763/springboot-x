package com.gopher.zkd1.service.dubbo;


import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.response.PageResponse;

/**
 * @author 6c6763
 * @date 2020/10/22
 */
public interface ReadService  {

    /**
     * 查询企业列表
     * @param queryCompanyAo ao
     * @return pageInfo
     */
    PageResponse<CompanyDto> listCompany(QueryCompanyAo queryCompanyAo);

}
