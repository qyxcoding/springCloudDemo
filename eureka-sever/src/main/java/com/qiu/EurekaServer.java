package com.qiu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServer.class).web(true).run(args);
	}

}
