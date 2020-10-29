package com.gopher.mp.web;

import com.gopher.mp.dao.CompanyMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List list(){
        return companyMapper.findAllCompany();
    }
}
