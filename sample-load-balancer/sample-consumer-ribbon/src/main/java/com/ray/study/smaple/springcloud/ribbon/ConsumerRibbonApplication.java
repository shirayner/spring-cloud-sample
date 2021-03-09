package com.ray.study.smaple.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * RibbonLoadbalancerApplication
 *
 * @author ray
 * @date 2020/6/17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }

}
