package com.gopher.zkd1.dao;


import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.zkd1.entity.CompanyDo;
import com.gopher.zkd1.tk.CoreMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gopher lee
 * @date 2020/10/21
 */
public interface CompanyMapper extends CoreMapper<CompanyDo> {

    /**
     * 接入企业分页列表
     *
     * @param queryCompanyAo ao
     * @return pageList
     */
    List<CompanyDo> listCompany(@Param("param") QueryCompanyAo queryCompanyAo);

}
