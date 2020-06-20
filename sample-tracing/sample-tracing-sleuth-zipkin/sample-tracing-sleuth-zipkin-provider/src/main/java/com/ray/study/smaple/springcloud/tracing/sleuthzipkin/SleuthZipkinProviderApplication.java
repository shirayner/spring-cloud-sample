package com.ray.study.smaple.springcloud.tracing.sleuthzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SleuthProviderApplication
 *
 * @author ray
 * @date 2020/6/20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthZipkinProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinProviderApplication.class,args);
    }
}
