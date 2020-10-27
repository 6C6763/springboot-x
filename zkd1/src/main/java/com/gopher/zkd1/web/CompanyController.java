package com.gopher.zkd1.web;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.gopher.api.service.dubbo.company.dto.CompanyDto;
import com.gopher.api.service.dubbo.company.dto.QueryCompanyAo;
import com.gopher.common.constant.BaseConstant;
import com.gopher.common.response.ApiResult;
import com.gopher.common.response.ApiResultBuilder;
import com.gopher.common.response.PageResponse;
import com.gopher.common.response.PageUtil;
import com.gopher.zkd1.entity.CompanyDo;
import com.gopher.zkd1.entity.CompanyVo;
import com.gopher.zkd1.entity.ao.InsertCompanyAo;
import com.gopher.zkd1.entity.ao.ModifyCompanyAo;
import com.gopher.zkd1.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author gopher lee
 * @date 2020/10/20
 */
@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @ApiOperation("添加接入企业")
    @PostMapping("save")
    public ApiResult saveCompany(@Valid @RequestBody InsertCompanyAo companyAo) {
        String webPrefix = "DiCompanyController-saveCompany 添加接入企业信息";
        log.info("{}开始，入参:{}", webPrefix, companyAo);
        CompanyDo companyDo = companyService.saveCompany(companyAo);
        log.info("{}结束，入参:{}", webPrefix, companyAo);
        return ApiResultBuilder.successWithData(companyDo);
    }

    @ApiOperation("删除接入企业")
    @DeleteMapping(value = "delete/{id}")
    public ApiResult deleteCompany(@ApiParam(value = "企业编号", required = true) @PathVariable(value = "id") Long id) {
        String webPrefix = "DiCompanyController-deleteCompany 删除接入企业信息";
        log.info("{}开始，入参:{}", webPrefix, id);
        companyService.deleteCompany(id);
        return ApiResultBuilder.successWithOutData();
    }

    @ApiOperation("修改接入企业信息")
    @PostMapping("update")
    public ApiResult<ModifyCompanyAo> updateCompany(@ApiParam(value = "企业信息")@Valid @RequestBody ModifyCompanyAo modifyCompanyAo) {
        String webPrefix = "DiCompanyController-updateCompany 修改接入企业信息";
        log.info("{}开始，入参:{}", webPrefix, modifyCompanyAo);
        companyService.modifyCompany(modifyCompanyAo);
        return ApiResultBuilder.successWithData(modifyCompanyAo);

    }


    @ApiOperation(value = "接入企业列表")
    @GetMapping("/listCompany")
    public PageResponse listCompany(@ApiParam(value = "接入企业名称") @RequestParam(value = "companyName", required = false) String companyName,
                                    @ApiParam(value = "接入企业联系电话") @RequestParam(value = "companyTel", required = false) String companyTel,
                                    @ApiParam(value = "企业接入开始时间") @RequestParam(value = "accessStartTime", required = false) Date accessStartTime,
                                    @ApiParam(value = "企业接入结束时间") @RequestParam(value = "accessEndTime", required = false) Date accessEndTime,
                                    @ApiParam("页码") @RequestParam(value = "pageNo", required = false, defaultValue = BaseConstant.PAGE_NO) Integer pageNo,
                                    @ApiParam("页数据") @RequestParam(value = "pageSize", required = false, defaultValue = BaseConstant.PAGE_SIZE) Integer pageSize) {
        String webPrefix = "DiCompanyController-listCompany 查询接入企业列表";
        log.info("{}开始，入参:[companyName:{},companyTel:{},accessStartTime:{},accessEndTime:{},pageNo:{},pageSize:{}]", webPrefix, companyName
                , companyTel, accessStartTime, accessEndTime, pageNo, pageSize);
        QueryCompanyAo queryCompanyAo = QueryCompanyAo.builder()
                .companyName(companyName)
                .companyTel(companyTel)
                .accessStartTime(accessStartTime)
                .accessEndTime(accessEndTime)
                .build();
        queryCompanyAo.setPageNo(pageNo);
        queryCompanyAo.setPageSize(pageSize);
        PageResponse<CompanyDto> pageResponse = companyService.listCompany(queryCompanyAo);
        List<CompanyDto> list = (List<CompanyDto>) pageResponse.getData();
        List<CompanyVo> companyVoList = Lists.newArrayList();
        HashMap<String, String> map = Maps.newHashMap();
        map.put("createTimeStart","gmtCreateDate");
//      map.put("createTimeEnd","gmtModifyDate");
        list.forEach(companyDto -> {
                    CompanyVo companyVo = new CompanyVo();
                    BeanUtil.copyProperties(companyDto, companyVo, CopyOptions.create().setFieldMapping(map).setIgnoreProperties("createTimeEnd"));
                    companyVoList.add(companyVo);
                }
        );
        PageInfo<CompanyVo> companyVoPageInfo = new PageInfo<>();
        companyVoPageInfo.setPageSize(pageResponse.getPageSize());
        companyVoPageInfo.setPageNum(pageResponse.getPageNo());
        companyVoPageInfo.setTotal(pageResponse.getTotalSize());
        companyVoPageInfo.setPages(pageResponse.getTotalPages());
        companyVoPageInfo.setList(companyVoList);
        log.info("{}结束", webPrefix);
        return PageUtil.getPageResult(companyVoPageInfo);
    }
}
