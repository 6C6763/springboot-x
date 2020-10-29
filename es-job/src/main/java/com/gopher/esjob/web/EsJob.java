package com.gopher.esjob.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
@RestController
@RequestMapping("job")
public class EsJob {

    @GetMapping("start")
    public String start(){
        return "es job start";
    }
}
