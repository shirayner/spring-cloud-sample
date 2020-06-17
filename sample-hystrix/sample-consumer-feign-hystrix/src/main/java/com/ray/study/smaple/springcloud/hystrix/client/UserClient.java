package com.ray.study.smaple.springcloud.hystrix.client;

import com.ray.study.smaple.springcloud.hystrix.client.impl.UserClientFallback;
import com.ray.study.smaple.springcloud.hystrix.controller.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * UserClient
 *
 * 通过 @FeignClient 注解的 fallback 属性指定降级类
 *
 * @author ray
 * @date 2020/6/17
 */
@FeignClient(name = "eureka-client",path = "/user", fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("/{id}")
    String getUser1(@PathVariable("id") Long id);

    @GetMapping("/get2")
    String getUser2(@RequestParam("name") String name, @RequestHeader("token") String token);

    @PostMapping("/get3")
    UserDto getUser3(@RequestBody UserDto dto);
}
