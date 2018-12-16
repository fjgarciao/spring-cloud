package com.in28minutes.microservices.netfixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetfixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetfixZuulApiGatewayServerApplication.class, args);
	}

}

