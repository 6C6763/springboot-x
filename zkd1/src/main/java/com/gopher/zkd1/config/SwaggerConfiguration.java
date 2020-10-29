package com.gopher.zkd1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author gopher lee
 * @date 2020/10/20
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gopher.zkd1.web"))
                //.paths(PathSelectors.ant("/**/test/post"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return
                new ApiInfoBuilder()
                        .title("SpringBoot 整合 tk-mybatis 在线Api文档")
                        .description("描述文档的信息")
                        .termsOfServiceUrl("https://baidu.com")
                        .version("V1.0")
                        .build();
    }
}
