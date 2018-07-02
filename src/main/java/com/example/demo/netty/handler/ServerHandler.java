package com.example.demo.netty.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@Qualifier("serverHandler")
@Sharable
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("client msg:{}", msg);
        String clientIdToLong = ctx.channel().id().asLongText();
        log.info("client long id:{}", clientIdToLong);
        String clientIdToShort = ctx.channel().id().asShortText();
        log.info("client short id:{}", clientIdToShort);
        //writeAndFlush to client
        log.info("writeAndFlush:{}", String.format("Your msg is: %s %n", msg));
        ctx.channel().writeAndFlush(String.format("Your msg is: %s %n", msg));

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("RamoteAddress : {} active!", ctx.channel().remoteAddress());
        super.channelActive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("Channel has exception, {}",cause.getMessage());
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel is disconnected! RamoteAddress : {}", ctx.channel().remoteAddress());
        super.channelInactive(ctx);
    }


}