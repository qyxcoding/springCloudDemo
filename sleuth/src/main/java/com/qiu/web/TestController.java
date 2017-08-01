package com.qiu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/**
 * 测试类
 * Created by sun on 2017-1-14.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    
    Logger logger = Logger.getLogger(TestController.class);
    
    @RequestMapping("/")
    @ResponseBody
    String test(HttpServletRequest req){
        logger.info("测试日志");
        return "Hello World!";
    }

}