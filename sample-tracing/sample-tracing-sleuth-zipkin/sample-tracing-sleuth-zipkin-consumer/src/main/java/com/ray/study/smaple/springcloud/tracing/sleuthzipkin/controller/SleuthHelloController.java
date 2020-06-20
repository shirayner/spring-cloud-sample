package com.ray.study.smaple.springcloud.tracing.sleuthzipkin.controller;

import com.ray.study.smaple.springcloud.tracing.sleuthzipkin.client.SleuthHelloClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * SleuthHelloController
 *
 * @author ray
 * @date 2020/6/20
 */
@RestController
@Slf4j
public class SleuthHelloController {

    @Autowired
    SleuthHelloClient sleuthHelloClient;

    @Autowired
    private ExecutorService executorService;

    @GetMapping("/hello")
    public String hello(String name){
        log.info("FeignClient start to send! param:{}", name);
        String result = sleuthHelloClient.sayHello(name);
        log.info("FeignClient received! result:{}", result);
        return result;
    }

    @GetMapping("/helloByNewThread")
    public String helloByNewThread(String name) throws ExecutionException, InterruptedException {
        log.info("FeignClient start to send by new thread, param: {}",name);

        Future future = executorService.submit(() -> {
            log.info("FeignClient start to send, in sub thread, param: {}",name);
            String result = sleuthHelloClient.sayHello(name);
            return result;
        });
        String result = (String) future.get();
        log.info("FeignClient received, return main thread, result: {}",result);
        return result;
    }

}
