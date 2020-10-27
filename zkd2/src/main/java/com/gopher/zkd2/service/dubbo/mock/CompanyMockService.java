package com.gopher.zkd2.service.dubbo.mock;

import com.gopher.api.service.dubbo.company.DboCompanyService;
import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.response.PageResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 6c6763
 * @date 2020/10/23
 */
@Slf4j
public class CompanyMockService implements DboCompanyService {
    @Override
    public PageResponse<CompanyDto> listCompany(QueryCompanyAo queryCompanyAo) {
        log.warn("！！！---DboCompanyService Down---！！！");
        return new PageResponse<>();
    }
}
