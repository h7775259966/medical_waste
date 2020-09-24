package com.module;

import com.common.Utils.JwtUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.module.dao")
@ComponentScan(basePackages= "com.module.config")
@ComponentScan(basePackages= "com.module")
//public class SpringbootMybatisApplication extends SpringBootServletInitializer {
//注解掉的部分用于打包部署在服务器tomcat时使用
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//		return builder.sources(SpringbootMybatisApplication.class);
//	}

	//jwt加密
	@Bean
	public JwtUtils jwtUtils() {
		return new JwtUtils();
	}


	//解决no session
//	@Bean
//	public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
//		return new OpenEntityManagerInViewFilter();
//	}
}



