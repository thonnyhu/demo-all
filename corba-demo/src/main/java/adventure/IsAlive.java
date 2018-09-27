package adventure;

/**
 * Created by Mirana on 16/2/1.
 */

public class IsAlive
{

    static public boolean is_alive(IPingOperations o)
    {
        boolean result = true;

        try
        {
            o.ping();
        }
        catch(Throwable t)
        {
            result = false;
        }

        return result;
    }

}
