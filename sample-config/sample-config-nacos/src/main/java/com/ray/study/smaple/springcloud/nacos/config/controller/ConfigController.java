package com.ray.study.smaple.springcloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigController
 *   通过 Spring Cloud 原生注解 `@RefreshScope` 实现配置自动更新
 * @author ray
 * @date 2020/6/14
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    /**
     * http://localhost:18083/config/get
     */
    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

}
