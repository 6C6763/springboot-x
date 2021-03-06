package com.gopher.zkd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 6c6763
 */
@SpringBootApplication
@EnableSwagger2
public class Zkd2Application {

    public static void main(String[] args) {
        SpringApplication.run(Zkd2Application.class, args);
    }

}
