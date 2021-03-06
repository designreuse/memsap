package com.we.sdk.memsap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
public class MemsapOrderApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemsapOrderApiApplication.class, args);
    }

}

