package com.example.demo.netty.handler;

import com.example.demo.netty.config.MessageDecoder;
import com.example.demo.netty.config.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * tcp链路配置
 */
@Component("messageProtocolInitalizer")
public class MessageProtocolInitalizer extends ChannelInitializer<SocketChannel> {

    private final MessageDecoder messageDecoder;

    private final MessageEncoder messageEncoder;

    private final ServerHandler serverHandler;

    @Autowired
    public MessageProtocolInitalizer(MessageDecoder messageDecoder, MessageEncoder messageEncoder, ServerHandler serverHandler) {
        this.messageDecoder = messageDecoder;
        this.messageEncoder = messageEncoder;
        this.serverHandler = serverHandler;
    }

    @Override
    protected void initChannel(SocketChannel ch){
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("decoder", messageDecoder);
        pipeline.addLast("handler", serverHandler);
        pipeline.addLast("encoder", messageEncoder);
    }
}