package logevent;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author: ZiJian Hu
 * @Description:
 * @Date: Created in 3:15 PM 2018/10/5
 * @Modified By:
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
        ByteBuf content = msg.content();
        int idx = content.indexOf(0, content.readableBytes(), LogEvent.SEPARATOR);
        String fileName = content.slice(0, idx).toString();
        String logMsg = content.slice(idx + 1, content.readableBytes()).toString(CharsetUtil.UTF_8);
        LogEvent event = new LogEvent(msg.sender(), System.currentTimeMillis(), fileName, logMsg);
        out.add(event);
    }
}
