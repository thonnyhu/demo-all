package logevent;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

/**
 * @Author: ZiJian Hu
 * @Description:
 * @Date: Created in 3:02 PM 2018/10/5
 * @Modified By:
 */
public class LogEventBroadcaster {

    private final EventLoopGroup group;
    private final Bootstrap bootstrap;
    private final File file;

    public LogEventBroadcaster(InetSocketAddress address, File file) {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
//                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new LogEventEncoder(address));
        this.file = file;
    }

    public void run() throws Exception {
        Channel ch = bootstrap.bind(0).sync().channel();
        long pointer = 0;
        for (; ; ) {
            long len = file.length();
            if (len < pointer) {
                pointer = len;
            } else {
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                raf.seek(pointer);
                String line;
                while ((line = raf.readLine()) != null) {
                    ch.writeAndFlush(new LogEvent(null,-1,file.getAbsolutePath(),line));
                }
                pointer = raf.getFilePointer();
                raf.close();
            }
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.interrupted();
                break;
            }
        }

    }

    public void stop(){
        group.shutdownGracefully();
    }

    public static void main(String[] args) {
        LogEventBroadcaster broadcaster = new LogEventBroadcaster(new InetSocketAddress("127.0.0.1", 8889),new File("/Users/mirana/Downloads/aa.txt"));
        try{
            broadcaster.run();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            broadcaster.stop();
        }
    }
}
