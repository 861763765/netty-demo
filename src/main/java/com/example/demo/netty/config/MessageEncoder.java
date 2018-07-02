//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.netty.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 消息编码，这里需要根据实际情况来修改，默认采用的{@code io.netty.handler.codec.string.StringEncoder的实现}<br>
 * 这里泛型可以使用自定义的实体类
 */
@Sharable
public class MessageEncoder extends MessageToMessageEncoder<ByteBuf> {

    public MessageEncoder() {
    }

    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if (msg.readableBytes() > 0) {
            out.add(msg);
        }
    }
}
