package adventure;

public class SystemIO
{

     synchronized static public void log(String message)
     {
          String now = new java.util.Date().toString();
          System.out.println(now + " OK:      " + message);
     }

     synchronized static public void warning(String message)
     {
          String now = new java.util.Date().toString();
          System.err.println(now + " WARNING: " + message);
     }

     synchronized static public void error(String message)
     {
          String now = new java.util.Date().toString();
          System.err.println(now + " ERROR:   " + message);
     }

     public static void fatal_error(String message)
     {
          error(message);
          System.exit(1);
     }

}
