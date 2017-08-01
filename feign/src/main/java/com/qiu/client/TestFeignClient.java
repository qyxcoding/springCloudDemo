package com.qiu.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qiu.log.FenignLogConfiguration;

@FeignClient(name = "SERVICE-B",configuration = FenignLogConfiguration.class)
public interface TestFeignClient {
	
  @RequestMapping("/add")
  public String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b);
}