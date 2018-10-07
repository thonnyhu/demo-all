package nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: ZiJian Hu
 * @Description:
 * @Date: Created in 1:49 PM 2018/9/12
 * @Modified By:
 */
public class PlainOioClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8888;
        try {
            Socket socket = new Socket(host, port);
            InputStream inputStream = socket.getInputStream();
            System.out.println(inputStream.markSupported());

            while (true){
                int read = inputStream.read();
                if(read!= -1){
                    System.out.println((char)read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
