package com.ray.study.smaple.springcloud.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author ray
 * @date 2020/6/12
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public String hello(){
        return "server.port: " + port;
    }

}
