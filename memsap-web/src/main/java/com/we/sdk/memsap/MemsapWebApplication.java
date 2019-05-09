package com.we.sdk.memsap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//开启断路器
//@EnableCircuitBreaker
public class MemsapWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemsapWebApplication.class, args);
    }

}
