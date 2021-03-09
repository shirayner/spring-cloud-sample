package com.ray.study.smaple.springcloud.hystrix.controller;


import com.ray.study.smaple.springcloud.hystrix.client.UserClient;
import com.ray.study.smaple.springcloud.hystrix.controller.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * UserController
 *
 * @author ray
 * @date 2020/6/17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserClient userClient;

    /**
     * get 路径请求参数传递
     *  当 id<=0时抛出异常，被Hystrix降级处理
     */
    @GetMapping("/{id}")
    public String getUser1(@PathVariable("id") Long id){
        return userClient.getUser1(id);
    }

    /**
     * get 请求参数传递
     * @return
     */
    @GetMapping("/get2")
    public String getUser2() {
        return userClient.getUser2("张三", "271267312jhdsjfhdsjf3uwyruwe");
    }

    /**
     *  post 请求参数传递
     * @return
     */
    @PostMapping("/get3")
    public UserDto getUser3() {
        UserDto userDto =  new UserDto();
        userDto.setId(10001L);
        userDto.setName("张三");
        userDto.setAge(22);
        userDto.setCreationDate(new Date());
        return userClient.getUser3(userDto);
    }

}

