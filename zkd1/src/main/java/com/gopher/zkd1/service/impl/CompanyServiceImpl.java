package com.gopher.zkd1.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.constant.BaseConstant;
import com.gopher.common.response.ApiErrEnum;
import com.gopher.common.response.ApiException;
import com.gopher.common.response.PageResponse;
import com.gopher.common.response.PageUtil;
import com.gopher.zkd1.dao.CompanyMapper;
import com.gopher.zkd1.entity.CompanyDo;
import com.gopher.zkd1.entity.ao.InsertCompanyAo;
import com.gopher.zkd1.entity.ao.ModifyCompanyAo;
import com.gopher.zkd1.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * @author gopher lee
 * @date 2020/10/21
 */
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    CompanyMapper companyMapper;


    @Override
    public PageResponse<CompanyDto> listCompany(QueryCompanyAo queryCompanyAo) {
        log.info("【CompanyServiceImpl-listCompany】开始，入参:{}", queryCompanyAo);
        if (null == queryCompanyAo) {
            queryCompanyAo.setPageNo(1);
            queryCompanyAo.setPageSize(10);
        }
        PageHelper.startPage(queryCompanyAo.getPageNo(), queryCompanyAo.getPageSize());
        List<CompanyDo> companyDoList = companyMapper.listCompany(queryCompanyAo);

        HashMap<String, String> map = Maps.newHashMap();
        map.put("gmtCreateDate", "createTimeStart");
        map.put("gmtModifyDate", "createTimeEnd");
        List<CompanyDto> list = new ArrayList<>();

        for (CompanyDo companyDo : companyDoList) {
            CompanyDto companyDto = new CompanyDto();
            BeanUtil.copyProperties(companyDo, companyDto, CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase().setIgnoreProperties("gmtModifyDate").setFieldMapping(map));
            list.add(companyDto);
        }
        PageInfo<CompanyDto> pageInfo = new PageInfo<>(list);
        return PageUtil.getPageResult(pageInfo);
    }

    @Override
    public void deleteCompany(Long id) {
        log.info("【CompanyServiceImpl-deleteCompany】开始，入参:{}", id);
        int i = companyMapper.deleteByPrimaryKey(id);
        if (i == BaseConstant.ONE) {
            log.info("修改成功");
        } else {
            log.error("修改数据{}失败", id);
            throw new ApiException(ApiErrEnum.DB_OPERATOR_FAIL.getCode(), ApiErrEnum.DB_OPERATOR_FAIL.getMsg());
        }
    }

    @Override
    public void modifyCompany(ModifyCompanyAo modifyCompanyAo) {
        log.info("【CompanyServiceImpl-modifyCompany】开始，入参:{}", modifyCompanyAo);
        CompanyDo companyDo = new CompanyDo();
        BeanUtil.copyProperties(modifyCompanyAo, companyDo);
        companyDo.setGmtModifyDate(DateUtil.date());
        int i = companyMapper.updateByPrimaryKeySelective(companyDo);
        if (BaseConstant.ONE == i) {
            log.info("modifyCompany-修改成功，参数:{}", modifyCompanyAo);
        } else {
            log.error("modifyCompany-修改失败，参数:{}", modifyCompanyAo);
            throw new ApiException(ApiErrEnum.DB_OPERATOR_FAIL.getCode(), ApiErrEnum.DB_OPERATOR_FAIL.getMsg());
        }
    }

    @Override
    public CompanyDo saveCompany(InsertCompanyAo insertCompanyAo) {
        log.info("【CompanyServiceImpl-saveCompany】添加接入企业信息{}，入参:{}", insertCompanyAo);
        Date now = Date.from(LocalDate.now().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        CompanyDo companyDo = new CompanyDo();
        BeanUtil.copyProperties(insertCompanyAo, companyDo, CopyOptions.create().ignoreCase().ignoreNullValue().ignoreError());
        companyDo.setId(1L);
        companyDo.setGmtCreateDate(now);
        companyDo.setGmtModifyDate(now);
        int i = companyMapper.insertSelective(companyDo);
        log.info("{}数据插入{}", companyDo, i == BaseConstant.ONE ? "成功" : "失败");
        return companyDo;
    }

}
