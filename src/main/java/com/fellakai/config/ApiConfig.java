package com.fellakai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //这个注解好像没有用。注释与否都没啥影响
@EnableWebMvc
@EnableSwagger2
public class ApiConfig {
	@Bean
	public Docket customDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.any()).
//下面是过滤到 ApiOperation注解的方法。 也可以用到包过滤，在下面注释掉了。
				apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).
//				apis(RequestHandlerSelectors.basePackage("com.fellakai")).
				build().apiInfo(apiInfo()); //括号中的调用下面的 apiInfo 方法
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("一级标题").description("二级标题").version("版本号v1.0")
				.build();
	}
}
