package com.gopher.tk.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 6c6763
 * @date 2020/10/27
 */
@RestController
@RequestMapping("tk")
@Api(value = "tk crud")
public class TkAction {

    @ApiOperation("tk 分页列表")
    @GetMapping("test")
    public String test(@ApiParam(value = "姓名测试") @RequestParam(value = "name") String name) {
        return name;
    }
}
