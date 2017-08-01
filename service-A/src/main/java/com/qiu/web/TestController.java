package com.qiu.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class TestController {

    @Value("${profile}")
    private String from;
    @Value("${profile.url}")
    private String fromUrl;

    @RequestMapping("/profile")
    public String from() {

        return this.from+"\n\n"+this.fromUrl;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

}