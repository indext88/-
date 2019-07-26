package com.gxa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */

//扫描需要启动springboot的包
@SpringBootApplication(scanBasePackages = "com.gxa.*")
//配置启动的Mapper接口
@MapperScan(value = "com.gxa.dao")

public class SpringbootMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMainApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootMainApplication.class);
	}

}
