package com.gopher.zkd2.web;

import com.gopher.api.service.dubbo.company.DboCompanyService;
import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.common.response.PageResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 6c6763
 * @date 2020/10/23
 */
@RestController
@RequestMapping("mock")
public class MockController {

    @Reference(mock = "com.gopher.zkd2.service.dubbo.mock.CompanyMockService")
    DboCompanyService dboCompanyService;

    @GetMapping("check")
    public String mock(){
        PageResponse<CompanyDto> companyDtoPageInfo = dboCompanyService.listCompany(null);
        return companyDtoPageInfo.toString();
    }
}
