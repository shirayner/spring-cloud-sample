package com.ray.study.smaple.springcloud.ribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * HelloRibbonController
 *
 * @author ray
 * @date 2020/6/17
 */
@RestController
@Slf4j
public class HelloRibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String sayHello(){
        String result = restTemplate.getForObject("http://eureka-client/user/hello",String.class);
        log.info(result);
        return result;
    }

}
