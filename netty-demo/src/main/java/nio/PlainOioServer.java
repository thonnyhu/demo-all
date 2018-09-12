package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Author: ZiJian Hu
 * @Description:
 * @Date: Created in 1:43 PM 2018/9/12
 * @Modified By:
 */
public class PlainOioServer {

    public static void main(String[] args) {
        final int port = 8888;
        try {
            final ServerSocket serverSocket = new ServerSocket(port);
            for (; ; ) {
                final Socket socket = serverSocket.accept();
                System.out.println("Accept connection from " + socket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OutputStream outputStream1 = socket.getOutputStream();
                            outputStream1.write("Hi ! \r\n ".getBytes(Charset.forName("UTF-8")));
                            outputStream1.flush();
                            outputStream1.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException ignore) {
                                //
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
