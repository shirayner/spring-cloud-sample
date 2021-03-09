package com.ray.study.smaple.springcloud.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RibbonConfig
 *
 * @author ray
 * @date 2020/6/17
 */
@Configuration
public class RibbonConfig {

    /**
     *  通过添加 @LoadBalanced 注解 声明该 restTemplate 用于负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 设置Ribbon采取的负载均衡算法
     * @return
     */
    //	@Bean
    //	public IRule ribbonRule(){
    //		// 随机算法
    //		return new RandomRule();
    //	}

}