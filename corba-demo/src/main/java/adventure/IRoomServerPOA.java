package adventure;


/**
* adventure/IRoomServerPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// Interface of the room server offered to the game server
public abstract class IRoomServerPOA extends org.omg.PortableServer.Servant
 implements adventure.IRoomServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("find_room", new Integer (0));
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

  // reference to one particular room
       case 0:  // adventure/IRoomServer/find_room
       {
         try {
           int n = in.read_long ();
           Room $result = null;
           $result = this.find_room (n);
           out = $rh.createReply();
           RoomHelper.write (out, $result);
         } catch (adventure.room_not_found $ex) {
           out = $rh.createExceptionReply ();
           adventure.room_not_foundHelper.write (out, $ex);
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
    "IDL:adventure/IRoomServer:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IRoomServer _this() 
  {
    return IRoomServerHelper.narrow(
    super._this_object());
  }

  public IRoomServer _this(org.omg.CORBA.ORB orb) 
  {
    return IRoomServerHelper.narrow(
    super._this_object(orb));
  }


} // class IRoomServerPOA
