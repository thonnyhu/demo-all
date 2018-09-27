import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Mirana on 16/1/18.
 */
public final class WebServer {

    public static void main(String[] args) throws Exception {
        // Set the port number
        int port = 6789;
        ServerSocket server = new ServerSocket(port);

        while (true){
            Socket accept = server.accept();
            HttpRequest request = new HttpRequest(accept);
            Thread thread = new Thread(request);
            thread.start();
        }

    }

}

final class HttpRequest implements Runnable{

    final static String CRLF = "\r\n";
    private Socket socket;

    public HttpRequest(Socket socket) throws Exception{
        this.socket = socket;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        try {
            processRequest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void processRequest() throws Exception{
        InputStream inputStream = socket.getInputStream();
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String requestLine = null;
        requestLine = bufferedReader.readLine();
        String [] tokens=requestLine.split("\\s+",3);
        System.out.println(requestLine);
        soutHeadLine(bufferedReader);
        String fileName = tokens[1];
        fileName ="."+fileName;
        FileInputStream fis = null;
        boolean fileExists = true;
        try{
            fis = new FileInputStream(fileName);
        }catch (FileNotFoundException e){
            fileExists = false;
        }

        String statusLine = null;
        String contentTypeLine = null;
        String entityBody = null;
        if(fileExists){
            statusLine = "HTTP/1.1 200"+ CRLF;
            contentTypeLine = "Content-Type:"+contentType(fileName)+CRLF;
            outputStream.writeBytes(statusLine);
            outputStream.writeBytes(contentTypeLine);
            outputStream.writeBytes(CRLF);
            sendBytes(fis,outputStream);
            fis.close();
        }else{
            if(fileName.substring(2).startsWith("redirect")){
                statusLine = "HTTP/1.1 302" + CRLF;
                int redirect = fileName.lastIndexOf("redirect");
                fileName = fileName.substring(redirect + 9);
                String location = "Location: http://" + fileName + CRLF;
                outputStream.writeBytes(statusLine);
                outputStream.writeBytes(location);
            }else if(fileName.substring(2).startsWith("download")){
                statusLine = "HTTP/1.1 200" + CRLF;
                int download = fileName.lastIndexOf("download");
                fileName = fileName.substring(download + 9);
                File file = new File(fileName);
                if(file.exists()){
                    contentTypeLine = "Content-Type:application/x-msdownload"+CRLF;
                    String contentLength = "Content-Length:"+file.length()+CRLF;
                    String contentEncoding = "Content-Encoding:UTF-8"+CRLF;
                    String contentDisposition = "Content-Disposition:attachment;filename="+fileName+CRLF;
                    outputStream.writeBytes(statusLine+contentTypeLine+contentLength+contentEncoding+contentDisposition+CRLF);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    sendBytes(fileInputStream,outputStream);
                }else {
                    statusLine = "HTTP/1.1 404"+CRLF+"Content-Type:text/html"+CRLF+CRLF+"<HTML>"+
                            "<HEAD><TITLE>File Not Found</TITLE></HEAD>"+
                            "<BODY>File Not Found</BODY></HTML>";
                    outputStream.writeBytes(statusLine);
                }
            }else{
                statusLine = "HTTP/1.1 404"+CRLF+"Content-Type:text/html"+CRLF+CRLF+"<HTML>"+
                        "<HEAD><TITLE>Not Found</TITLE></HEAD>"+
                        "<BODY>Not Found</BODY></HTML>";
                outputStream.writeBytes(statusLine);
            }
        }

        outputStream.close();
        inputStream.close();
        socket.close();
    }

    private static String contentType(String fileName){
        if(fileName.endsWith(".htm") || fileName.endsWith(".html")){
            return "text/html";
        }
        if(fileName.endsWith(".xml")){
            return "application/xml,text/xml,application/x-xml";
        }
        if(fileName.endsWith(".png")){
            return "image/png,image/jpeg";
        }
        if(fileName.endsWith("jpg")){
            return "image/jpg,image/jpeg,image/pjpeg";
        }
        if(fileName.endsWith("gif")){
            return "image/gif";
        }

        return "application/octet-stream";
    }

    private static void sendBytes(FileInputStream fis, OutputStream os) throws IOException {
        byte[] buffer = new byte[1024];
        int bytes = 0;
        while ((bytes = fis.read(buffer))!=-1){
            os.write(buffer,0,bytes);
        }
    }

    private static void soutHeadLine(BufferedReader br) throws IOException {
        String headerLine = null;
        while ((headerLine = br.readLine()).length()!=0){
            System.out.println(headerLine);
        }
    }

}

