package com.gopher.api.service.dubbo.company;


import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.response.PageResponse;

/**
 * @author 6c6763
 * @date 2020/10/23
 */
public interface DboCompanyService {

    /**
     * 获取企业列表
     * @param queryCompanyAo ao
     * @return pageInfo<Company>
     */
    PageResponse<CompanyDto> listCompany(QueryCompanyAo queryCompanyAo);
}
