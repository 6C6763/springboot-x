package com.gopher.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 6c6763
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.gopher.tk.dao"})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(
        type = FilterType.REGEX, pattern = "com\\.gopher\\.tk\\.exclude\\.CoreMapper")})
public class SpringbootTkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTkApplication.class, args);
    }

}
