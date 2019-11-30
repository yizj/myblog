package com.zjl.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zjl.myblog.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .description("博客接口文档")
                        .contact(
                                new Contact("jlzhang",
                                        "https://github.com/yizj/myblog",
                                        "2506988720@qq.com"
                                )
                        )
                        .version("v1.0")
                        .title("API文档")
                        .license("Apache2.0")
                        .licenseUrl("http://www.apche.org/licenses/LICENSE-2.0")
                        .build()
                );
    }
}
