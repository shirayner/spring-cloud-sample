package com.ray.study.smaple.springcloud.eureka.controller;

import com.ray.study.smaple.springcloud.eureka.controller.dto.UserDto;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author ray
 * @date 2020/6/16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * get 路径请求参数传递
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String getUser1(@PathVariable("id") Long id) throws Exception {
        if(id == null || id <= 0){
            throw new Exception("invalid parameter: id="+ id);
        }

        return "the user's id is: "+id;
    }

    /**
     * get 请求参数传递
     * @param name
     * @return
     */
    @GetMapping("/get2")
    public String getUser2(@RequestParam String name, @RequestHeader String token) {
        return "the user's name is: "+name +" and token is:"+ token;
    }

    /**
     *  post 请求参数传递
     * @param dto
     * @return
     */
    @PostMapping("/get3")
    public UserDto getUser3(@RequestBody UserDto dto) {
        return dto;
    }

}
