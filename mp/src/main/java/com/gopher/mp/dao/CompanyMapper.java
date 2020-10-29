package com.gopher.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gopher.mp.entity.Company;

import java.util.List;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
public interface CompanyMapper extends BaseMapper<Company> {

    /**
     * list
     * @return
     */
    List<Company> findAllCompany();
}
