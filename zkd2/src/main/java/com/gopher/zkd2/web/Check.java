package com.gopher.zkd2.web;

import com.gopher.api.service.dubbo.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 6c6763
 * @date 2020/10/26
 */
@RestController
@RequestMapping("check")
public class Check {


    @Reference(group = "local")
    HelloService helloService;

    @GetMapping("/zkd2")
    public String check(@RequestParam(value = "msg") String param) {
        return helloService.say(param);
    }
}
