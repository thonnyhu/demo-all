package adventure;

import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.io.*;
import java.util.Random;

public class RoomServerProcess
{

    public static final String ROOM_NAME = "tangxRoom";
    final String servername = "demo." + System.getProperty("user.name");
    boolean signal_received = false;

    org.omg.CORBA.ORB orb = null;

    org.omg.PortableServer.POA poa = null;

    CBRoomServer tangx2 = null;

    RoomImpl myRoom = null;

    File f = new File("myRoom.txt");

    public static void main(String[] args)
    {
        RoomServerProcess sp = new RoomServerProcess(args);
    }

    public RoomServerProcess(String[] args)
    {

        try
        {
            SystemIO.log("Server is starting up..");

            // Adjust logging level

            java.util.logging.Logger logger = java.util.logging.Logger.getLogger("javax.enterprise.resource.corba._DEFAULT_.rpc.transport");
            logger.setLevel(java.util.logging.Level.SEVERE);

            // Initialise ORB and CORBA environment

            java.util.Properties props = new java.util.Properties();
//            args = new String[]{"-Dcom.sun.CORBA.ORBServerHost","localhost"};
            orb = org.omg.CORBA.ORB.init(args, props);

            // Obtain a reference to the CORBA Naming Service

            // Obtain a reference to the Root POA

            poa = org.omg.PortableServer.POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));

            // Activate Root POA

            poa.the_POAManager().activate();

            // Instantiate ServerImpl object and register
            // with the Root POA
            RoomServerImpl roomServer = new RoomServerImpl();
            IRoomServer Server = IRoomServerHelper.narrow(
                    poa.servant_to_reference(roomServer));


            roomServer.setOrb(orb);
            // Try to bind ServerImpl object with the CORBA
            // Naming Service


            GameServer object = GameServerHelper.narrow(orb.string_to_object("corbaloc::aries.aston.ac.uk:11225/game_server"));
            tangx2 = object.register("tangx2", "67fb6a0062701e5e46e844ad0a5ea78828f5109ee36abb90982b79a0ab48ec59", Server);
            if(tangx2!=null){
                SystemIO.log("register success...");
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            myRoom = (RoomImpl) ois.readObject();
            ois.close();
            if(myRoom == null)
                myRoom = new RoomImpl();
            myRoom.setCbRoomServer(tangx2);
            Object roomObject = poa.servant_to_reference(myRoom);
            Room myRoomRef = RoomHelper.narrow(roomObject);
            roomServer.setMyRoom(myRoomRef);

            Runtime.getRuntime().addShutdownHook(new ShutdownThread());

            // We're ready to serve requests

            SystemIO.log("Server is ready..");
            orb.run();
            SystemIO.log("Server shutdown complete");
        }

        catch (org.omg.PortableServer.POAManagerPackage.AdapterInactive ex)
        {
            // The POA is inactive and can't be used

            SystemIO.fatal_error("POA inactive");
        }
        catch (org.omg.PortableServer.POAPackage.ServantNotActive ex)
        {
            // The POA servant is not active and can't be used

            SystemIO.fatal_error("POA servant not active");
        }
        catch (org.omg.PortableServer.POAPackage.WrongPolicy ex)
        {
            // The POA can't activate a servant because of its
            // policies

            SystemIO.fatal_error("Wrong policy on POA to activate servant");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    class ShutdownThread extends Thread
    {

        public void run()
        {

            if (signal_received)
            {
                return;
            }
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(myRoom);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            signal_received = true;
            SystemIO.warning("Server shutdown started");

            tangx2.unregister();

            // Initiate ORB shutdown

            orb.shutdown(false);
        }

    }

}




