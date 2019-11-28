package com.jim.controller;


import com.jim.client.UserFeignClient;
import com.jim.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserService {

    /*@Autowired
    RestTemplate restTemplate;*/

    //Eureka 客户端 ，可以获取到服务实例信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;
    @RequestMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){

  /*

        // 一。原始方式，直接访问
        // return restTemplate.getForObject("http://localhost/user/"+id,User.class);


        // 二。使用Eureka注册服务来访问
        //1.根据服务名称获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //2.因为只有一个UserService，因此我们直接get（0）获取
        ServiceInstance serviceInstance = instances.get(0);
        //3.获取IP和端口信息
        String baseurl = "http://" + serviceInstance.getHost() +":" + serviceInstance.getPort() + "/user/";
        //4. 开始查询
        return restTemplate.getForObject(baseurl+id,User.class);


        //  三。使用ribbon进行负载均衡
        // 地址直接写服务名称即可
        String baseUrl = "http://user-service/user/";
        return restTemplate.getForObject(baseUrl+id,User.class);

        */

    //    Feign 伪装本地调用


        return userFeignClient.findById(id);

    }
}
