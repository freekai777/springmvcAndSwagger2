package com.fellakai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户模块")
@RestController
@RequestMapping(value = "/test")
public class TestController {

	/**
	 * @ApiOperation 这个注解是指该方法是用来做什么的,一定要加上httpMethod,否则会出现一堆
	 * @param userVo
	 * @return
	 */
	//@GetMapping(value = "/findUser")
	@ApiOperation(value = "查看用户" ,httpMethod="GET")
 	@RequestMapping(value = "findUser" )
	public String findUser(){
		System.out.println(123);
		return "333";
	}
}
