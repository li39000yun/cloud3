package com.lyq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Demo2Application extends SpringBootServletInitializer {


	@Value("${server.port}")
	String port;

	@RequestMapping("/hello")
	public String home(@RequestParam String name) {
		return "hi " + name + ",i am demo2  from port:" + port;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Demo2Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}