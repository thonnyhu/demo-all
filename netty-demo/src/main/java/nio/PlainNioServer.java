package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: ZiJian Hu
 * @Description:
 * @Date: Created in 1:58 PM 2018/9/12
 * @Modified By:
 */
public class PlainNioServer {

    public static void main(String[] args) {

        try {
            int port = 8988;
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            ServerSocket socket = serverChannel.socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            socket.bind(inetSocketAddress);
            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
            for (; ; ) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();

                    if (next.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                        SocketChannel accept = channel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE,msg.duplicate());
                        System.out.println("Accept connection from " + accept);
                    }

                    if(next.isWritable()){
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer attachment = (ByteBuffer) next.attachment();
                        while (attachment.hasRemaining()){
                            if(channel.write(attachment)==0){
                                break;
                            }
                        }
                        channel.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
