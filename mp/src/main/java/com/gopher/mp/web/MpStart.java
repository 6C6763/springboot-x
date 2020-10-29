package com.gopher.mp.web;

import com.gopher.mp.dao.CompanyMapper;
import com.gopher.mp.entity.dto.QueryCompanyAo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
@RestController
@RequestMapping("company")
public class MpStart {

    @Resource
    CompanyMapper companyMapper;

    @GetMapping("list")
    public List list() {
        return companyMapper.findAllCompany();
    }

    @PostMapping("query")
    public List postList(@Validated @RequestBody  QueryCompanyAo queryCompanyAo) {
        return companyMapper.findAllCompany();
    }
}
