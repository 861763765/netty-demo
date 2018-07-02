package com.example.demo.netty.config;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 消息解码，这里需要根据实际情况来修改，默认采用的{@code io.netty.handler.codec.string.StringDecoder的实现}<br>
 * 这里涉及到数据交互，建议还是使用ByteBuf作为泛型依赖，不建议更换。
 */
@Sharable
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {
    public MessageDecoder() {
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(msg.toString(Charset.defaultCharset()));
    }
}
