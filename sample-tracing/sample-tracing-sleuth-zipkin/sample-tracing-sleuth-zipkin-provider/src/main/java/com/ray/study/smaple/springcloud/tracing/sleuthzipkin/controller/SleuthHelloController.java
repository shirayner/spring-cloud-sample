package com.ray.study.smaple.springcloud.tracing.sleuthzipkin.controller;

import brave.baggage.BaggageField;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SleuthHelloController
 *
 * @author ray
 * @date 2020/6/20
 */
@RestController
@Slf4j
public class SleuthHelloController {

    @GetMapping("/sayHello")
    public String hello(String name){
        log.info("Service Provider recived! param:{}", name);
        return  "hello, "+name;
    }

}
