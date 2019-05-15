package classloader.demo1;

/**
 * Created by Mirana on 07/11/2017.
 */
public class LoadInfo {

    private MyClassloader myClassloader;
    private long loadTime;
    private BaseManager baseManager;

    public MyClassloader getMyClassloader() {
        return myClassloader;
    }

    public LoadInfo(MyClassloader myClassloader, long loadTime) {
        this.myClassloader = myClassloader;
        this.loadTime = loadTime;
    }

    public void setMyClassloader(MyClassloader myClassloader) {
        this.myClassloader = myClassloader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}
