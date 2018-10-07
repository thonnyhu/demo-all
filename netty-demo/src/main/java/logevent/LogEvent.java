package logevent;

import java.net.InetSocketAddress;

/**
 * @Author: ZiJian Hu
 * @Description:
 * @Date: Created in 2:46 PM 2018/10/5
 * @Modified By:
 */
public class LogEvent {

    public static final byte SEPARATOR = ':';
    private final InetSocketAddress source;
    private final String logFile;
    private final String msg;
    private final long received;

    public LogEvent(String logfile, String msg) {
        this(null, -1, logfile, msg);
    }

    public LogEvent(InetSocketAddress source, long received, String logFile, String msg) {
        this.source = source;
        this.received = received;
        this.logFile = logFile;
        this.msg = msg;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogFile() {
        return logFile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }
}
