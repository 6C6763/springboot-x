package com.gopher.zkd2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gopher.zkd2.web"))
                //.paths(PathSelectors.ant("/**/test/post"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "SanYue-XiAOJuKeJi 系统文档",
                "三悦科技对接滴滴企业打车系统文档",
                "API V1.0",
                "",
                new Contact("gopher_lee", "http://www.baidu.com", "guangchangde@gmail.com"),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
