package adventure;

import org.omg.CORBA.ORB;

import java.util.Properties;

/**
 * Created by Mirana on 16/2/23.
 */
public class MyPlayerOrb {


    org.omg.CORBA.ORB orb = null;
    org.omg.PortableServer.POA poa = null;
    public static void main(String[] args)
    {
        MyPlayerOrb sp = new MyPlayerOrb(args);
    }
    public MyPlayerOrb(String[] args)
    {
        try
        {
            SystemIO.log("Server is starting up..");
            // Adjust logging level
            java.util.logging.Logger logger = java.util.logging.Logger.getLogger("javax.enterprise.resource.corba._DEFAULT_.rpc.transport");
            logger.setLevel(java.util.logging.Level.SEVERE);
            // Initialise ORB and CORBA environment
            Properties properties = System.getProperties( );
            properties.put( "com.sun.CORBA.POA.ORBPersistentServerPort",
                    Integer.toString(1060) );
            ORB orb = ORB.init(args, properties);
            // Obtain a reference to the CORBA Naming Service
            // Obtain a reference to the Root POA
            poa = org.omg.PortableServer.POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));
            // Activate Root POA
            poa.the_POAManager().activate();
            // Instantiate ServerImpl object and register
            // with the Root POA
            MyPlayer player = new MyPlayer();
            poa.activate_object( player );
            ((com.sun.corba.se.impl.orb.ORBImpl)orb).
                    register_initial_reference(
                            "player", poa.servant_to_reference(player) );
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
}
