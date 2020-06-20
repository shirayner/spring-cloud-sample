package com.ray.study.smaple.springcloud.tracing.sleuthzipkin;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SleuthConsumerApplication
 *
 * @author ray
 * @date 2020/6/20
 */
@SpringBootApplication
@EnableFeignClients
public class SleuthZipkinConsumerApplication {

    @Autowired
    BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinConsumerApplication.class,args);
    }

    @Bean
    public ExecutorService executorService(){
        // 简单起见, 我们注册固定大小的线程池
        ExecutorService executorService =  Executors.newFixedThreadPool(2);
        return new TraceableExecutorService(this.beanFactory, executorService);
    }
}
