package com.gopher.zkd1.service.dubbo.Impl;

import com.gopher.api.service.dubbo.company.DboCompanyService;
import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.response.PageResponse;
import com.gopher.zkd1.service.CompanyService;
import com.gopher.zkd1.service.dubbo.ReadService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 6c6763
 * @date 2020/10/22
 */
@Service(loadbalance = "leastactive")
public class ReadServiceImpl implements ReadService, DboCompanyService {

    @Autowired
    CompanyService companyService;

    @Override
    public PageResponse<CompanyDto> listCompany(QueryCompanyAo queryCompanyAo) {
        return companyService.listCompany(queryCompanyAo);
    }

}
