package adventure;

import adventure.IRoomServer;
import adventure.IRoomServerHelper;

public class RoomServerProcess
{

        final String servername = "demo." + System.getProperty("user.name");
        boolean signal_received = false;

        org.omg.CORBA.ORB orb = null;
        org.omg.CosNaming.NamingContextExt nc = null;
        org.omg.PortableServer.POA poa = null;

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
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            props.put("org.omg.CORBA.ORBInitialHost", "localhost");
            orb = org.omg.CORBA.ORB.init(args, props);

            // Obtain a reference to the CORBA Naming Service

            nc = org.omg.CosNaming.NamingContextExtHelper.narrow(
                    orb.resolve_initial_references("NameService"));

            // Obtain a reference to the Root POA

            poa = org.omg.PortableServer.POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));

            // Activate Root POA

            poa.the_POAManager().activate();

            // Instantiate ServerImpl object and register
            // with the Root POA

            org.omg.CORBA.Object server =
                    poa.servant_to_reference(new RoomServerImpl ());

            // Try to bind ServerImpl object with the CORBA
            // Naming Service

            try
            {
                nc.bind(nc.to_name(servername), server);
            }
            catch (org.omg.CosNaming.NamingContextPackage.AlreadyBound ex)
            {
                // If there is already an object bound with the same
                // name, there are two possibilities:
                //
                // 1) A server is already running
                //
                // 2) The Naming Service contains a stale reference

                // Obtain existing reference from Naming Service

                org.omg.CORBA.Object o = nc.resolve(nc.to_name(servername));

                // Narrow to object of type Server

                IRoomServer server_other = IRoomServerHelper.narrow(o);

                // Check if the server is really there

                if (IsAlive.is_alive(server_other))
                {
                    // There is another server running, so we have
                    // to abort now

                    SystemIO.fatal_error("Another server is already running");
                }

                // Stale reference, it's OK to rebind

                nc.rebind(nc.to_name(servername), server);
            }

            // Register shutdown hook

            Runtime.getRuntime().addShutdownHook(new ShutdownThread());

            // We're ready to serve requests

            SystemIO.log("Server is ready..");
            orb.run();
            SystemIO.log("Server shutdown complete");
        }
        catch (org.omg.CORBA.ORBPackage.InvalidName ex)
        {
            // An invalid service name was passed to
            // ORB.resolve_initial_references()

            SystemIO.fatal_error(
                    "Invalid name passed to resolve_initial_references()");
        }
        catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex)
        {
            // An invalid name was passed to the Naming Service
            // for resolution

            SystemIO.fatal_error("Invalid name passed to Naming Service");
        }
        catch (org.omg.CosNaming.NamingContextPackage.NotFound ex)
        {
            // Server is not registered with the Naming Service and
            // thus an exception is thrown by the resolve() method

            SystemIO.fatal_error("Server is not registered with Naming Service");
        }
        catch (org.omg.CosNaming.NamingContextPackage.CannotProceed ex)
        {
            // The Naming Service has encountered a problem and can't
            // resolve the IOR for the requested object

            SystemIO.fatal_error("Naming Service cannot proceed");
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

            signal_received = true;
            SystemIO.warning("Server shutdown started");

            try
            {
                // Unbind from the Naming Service

                nc.unbind(nc.to_name(servername));
            }
            catch(org.omg.CosNaming.NamingContextPackage.CannotProceed ex)
            {
                // Intentionally ignore exception
            }
            catch(org.omg.CosNaming.NamingContextPackage.InvalidName ex)
            {
                // Intentionally ignore exception
            }
            catch(org.omg.CosNaming.NamingContextPackage.NotFound ex)
            {
                // Intentionally ignore exception
            }

            // Initiate ORB shutdown

            orb.shutdown(false);
        }

    }

}

/*{

        try
        {
            SystemIO.log("Server is starting up..");

            //注册本地实例  Naming Service -- 先不注册远程
            ORB orb = ORB.init(args,null);
            POA rootpoa = (POA) orb.resolve_initial_references("RootPOA");
            rootpoa.the_POAManager().activate();
            RoomServerImpl impl = new RoomServerImpl();
            impl.setOrb(orb);
            Object ref = rootpoa.servant_to_reference(impl);
            IRoomServer roomServer = IRoomServerHelper.narrow(ref);
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "RoomServer";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.bind(path,roomServer);
            System.out.println("Start ...");
            orb.run();
            // Init ORB

            // Init POA
            
            // Construct reference for game server
            
            // Connect to game server
            
            SystemIO.log("Server is ready..");
            
            // Serve requests

            SystemIO.log("Server shutdown complete");
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }        

    }*/


