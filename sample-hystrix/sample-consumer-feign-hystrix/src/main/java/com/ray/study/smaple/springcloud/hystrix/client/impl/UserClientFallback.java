package com.ray.study.smaple.springcloud.hystrix.client.impl;

import com.ray.study.smaple.springcloud.hystrix.client.UserClient;
import com.ray.study.smaple.springcloud.hystrix.controller.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * UserClientFallback
 * UserClient 的 Fallback 降级类
 *
 * @author ray
 * @date 2020/6/18
 */
@Component
public class UserClientFallback implements UserClient {
    /**
     * 出错则调用该方法，返回友好错误
     * @param id
     * @return
     */
    @Override
    public String getUser1(Long id) {
        return "The user dose not exist in this system, please confirm user's id:"+id;
    }

    /**
     * 出错则调用该方法，返回友好错误
     * @return
     */
    @Override
    public String getUser2(String name, String token) {
        return "The user dose not exist in this system, please confirm user's name";
    }

    /**
     * 出错则调用该方法，返回友好错误
     * @return
     */
    @Override
    public UserDto getUser3(UserDto dto) {
        return null;
    }
}
