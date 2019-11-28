package com.jim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient //开启Eureka客户端
@EnableFeignClients  //开启Feign功能  并且要把RestTemplace删除。Feign中已经自动继承了Ribbon负载均衡，
// 因此我们不需要自己定义RestTemplate了
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		//test
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}

	/*@Bean
	@LoadBalanced  //开启负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}*/
}
