package com.gopher.zkd1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import springfox.documentation.oas.annotations.EnableOpenApi;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 6c6763
 */
@SpringBootApplication
@EnableOpenApi
@MapperScan(basePackages = {"com.gopher.zkd1.dao"})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(
        type = FilterType.REGEX, pattern = "com\\.gopher\\.zkd1\\.tk\\.CoreMapper")})
public class Zkd1Application {

    public static void main(String[] args) {
        SpringApplication.run(Zkd1Application.class, args);
    }

}
