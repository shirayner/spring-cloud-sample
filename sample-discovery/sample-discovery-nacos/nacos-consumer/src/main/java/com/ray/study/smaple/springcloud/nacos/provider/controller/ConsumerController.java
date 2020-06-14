package com.ray.study.smaple.springcloud.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerController
 *
 * @author ray
 * @date 2020/6/13
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/consume")
    public String consume(){
        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        String url = String.format("http://%s:%s/hello", serviceInstance.getHost(), serviceInstance.getPort());
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url, String.class);
    }

}
