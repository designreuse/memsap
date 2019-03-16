package com.we.sdk.memsap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
//开启断路器
@EnableCircuitBreaker
public class MemsapWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemsapWebApplication.class, args);
    }

}
