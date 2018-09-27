package adventure;


/**
* adventure/GameServerPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public abstract class GameServerPOA extends org.omg.PortableServer.Servant
 implements adventure.GameServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("register", new Integer (0));
    _methods.put ("ping", new Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  // server. This operation makes new rooms available to the game
       case 0:  // adventure/GameServer/register
       {
         try {
           String user_name = in.read_string ();
           String secret_hash = in.read_string ();
           IRoomServer room_server = adventure.IRoomServerHelper.read (in);
           CBRoomServer $result = null;
           $result = this.register (user_name, secret_hash, room_server);
           out = $rh.createReply();
           adventure.CBRoomServerHelper.write (out, $result);
         } catch (adventure.registration_failed $ex) {
           out = $rh.createExceptionReply ();
           adventure.registration_failedHelper.write (out, $ex);
         }
         break;
       }


  // reachable
       case 1:  // adventure/IPing/ping
       {
         this.ping ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:adventure/GameServer:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GameServer _this() 
  {
    return GameServerHelper.narrow(
    super._this_object());
  }

  public GameServer _this(org.omg.CORBA.ORB orb) 
  {
    return GameServerHelper.narrow(
    super._this_object(orb));
  }


} // class GameServerPOA
