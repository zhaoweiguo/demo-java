package com.zwg;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;


@SpringCloudApplication
public class ApplicationBootstrap {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SpringApplication.run(ApplicationBootstrap.class, args);
    }
}
