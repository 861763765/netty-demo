package com.example.demo.netty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NettyController {

    @GetMapping("/netty/test")
    public String nettyController() {
        log.info("收到http请求");
        return "ok";
    }
}
