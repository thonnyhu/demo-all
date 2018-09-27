package adventure;

import org.omg.CORBA.*;

public class RoomClient
{
    static Room room;

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
            // part of the Interoperable naming Service.
//            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            room = RoomHelper.narrow(orb.string_to_object("corbaloc::localhost:59056/tangxRoom"));

            System.out.println("Obtained a handle on server object: " + room);
            room.ping();
//            Player player = PlayerHelper.narrow(orb.string_to_object("corbaloc::localhost:1060/player"));
//            System.out.println(orb.object_to_string(player));
//            room.player_entered(player);
        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }

}
