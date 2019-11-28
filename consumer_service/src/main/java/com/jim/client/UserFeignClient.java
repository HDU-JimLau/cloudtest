package com.jim.client;


import com.jim.fallback.UserFeignClientFallback;
import com.jim.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign 伪装为本地调用，以MVC风格来进行远程调用
 */

//服务ID
@FeignClient(value = "user-service",fallback = UserFeignClientFallback.class)
public interface UserFeignClient {


    //参数
    @RequestMapping("/user/{id}")
    User findById(@PathVariable("id") Integer id);
}
