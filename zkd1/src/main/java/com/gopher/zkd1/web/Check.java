package com.gopher.zkd1.web;

import com.google.errorprone.annotations.Var;
import com.gopher.api.service.dubbo.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 6c6763
 * @date 2020/10/26
 */
@RequestMapping("check")
@RestController
public class Check {

    @Reference(group = "remote")
    HelloService helloService;


    @GetMapping("/zkd1")
    public String check(@RequestParam(value = "msg") String param) {
        return helloService.say(param);
    }
}
