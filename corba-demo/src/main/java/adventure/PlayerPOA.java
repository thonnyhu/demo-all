package adventure;


/**
* adventure/PlayerPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// relevant information of the location and state of a player.
public abstract class PlayerPOA extends org.omg.PortableServer.Servant
 implements adventure.PlayerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_user_name", new Integer (0));
    _methods.put ("_get_real_name", new Integer (1));
    _methods.put ("_get_location", new Integer (2));
    _methods.put ("ping", new Integer (3));
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
       case 0:  // adventure/Player/_get_user_name
       {
         String $result = null;
         $result = this.user_name ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // adventure/Player/_get_real_name
       {
         String $result = null;
         $result = this.real_name ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // adventure/Player/_get_location
       {
         RoomID $result = null;
         $result = this.location ();
         out = $rh.createReply();
         adventure.RoomIDHelper.write (out, $result);
         break;
       }


  // reachable
       case 3:  // adventure/IPing/ping
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
    "IDL:adventure/Player:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Player _this() 
  {
    return PlayerHelper.narrow(
    super._this_object());
  }

  public Player _this(org.omg.CORBA.ORB orb) 
  {
    return PlayerHelper.narrow(
    super._this_object(orb));
  }


} // class PlayerPOA
