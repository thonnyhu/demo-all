package finalizer;

/**
 * Created by Mirana on 01/11/2017.
 */
public class Finalizer {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        Object o = new Object();

    }
}
