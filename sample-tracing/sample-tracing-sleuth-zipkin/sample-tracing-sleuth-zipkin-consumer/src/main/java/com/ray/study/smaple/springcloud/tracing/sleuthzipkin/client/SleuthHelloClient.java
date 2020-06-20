package com.ray.study.smaple.springcloud.tracing.sleuthzipkin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SleuthHelloClient
 *
 * @author ray
 * @date 2020/6/20
 */
@FeignClient(name = "sleuth-zipkin-provider",path = "/")
public interface SleuthHelloClient {

    @RequestMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);

}
