package hello;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class HelloClient
{
    static Hello helloImpl;

    public static void main(String args[])
    {
        try{
            // create and initialize the ORB
            args = new String[]{"-ORBInitialPort","1050","-ORBInitialHost","localhost"};
            ORB orb = org.omg.CORBA.ORB.init(args, null);

            // get the root naming context
//            org.omg.CORBA.Object objRef =
//                    orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.//
//            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
//            String name = "Hello";
            helloImpl = HelloHelper.narrow(orb.string_to_object("corbaloc::localhost:1050/hello"));

            System.out.println("Obtained a handle on server object: " + helloImpl);
            System.out.println(helloImpl.sayHello());
            helloImpl.shutdown();

        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }

}
