package com.demo.configuration;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;



@Configuration
@EnableHystrix
public class FooConfiguration {
    	@Bean
	//@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
