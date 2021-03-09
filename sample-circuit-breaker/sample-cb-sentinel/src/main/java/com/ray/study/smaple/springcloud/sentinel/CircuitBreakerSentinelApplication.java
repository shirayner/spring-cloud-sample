package com.ray.study.smaple.springcloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ConsumerFeignHystrixApplication
 *
 * @author ray
 * @date 2020/6/18
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CircuitBreakerSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerSentinelApplication.class, args);
    }
}
