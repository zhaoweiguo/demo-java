package com.zwg;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableFeignClients
@SpringCloudApplication
public class ApplicationBootstrap {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SpringApplication.run(ApplicationBootstrap.class, args);
    }
}
