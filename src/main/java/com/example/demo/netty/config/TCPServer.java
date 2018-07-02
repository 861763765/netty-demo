package com.example.demo.netty.config;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;

/**
 * TCP服务类
 */
@Component
@Slf4j
public class TCPServer {
    private final ServerBootstrap b;

    private final InetSocketAddress tcpPort;

    private ChannelFuture serverChannelFuture;

    @Autowired
    public TCPServer(@Qualifier("serverBootstrap") ServerBootstrap b, @Qualifier("tcpSocketAddress") InetSocketAddress tcpPort) {
        this.b = b;
        this.tcpPort = tcpPort;
    }

    @PostConstruct
    public void start() throws Exception {
        log.info("Starting server at {}", tcpPort);
        serverChannelFuture = b.bind(tcpPort).sync();
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannelFuture.channel().closeFuture().sync();
    }
}