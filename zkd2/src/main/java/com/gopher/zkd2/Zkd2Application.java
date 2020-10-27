package com.gopher.zkd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 6c6763
 */
@SpringBootApplication
@EnableOpenApi
public class Zkd2Application {

    public static void main(String[] args) {
        SpringApplication.run(Zkd2Application.class, args);
    }

}
