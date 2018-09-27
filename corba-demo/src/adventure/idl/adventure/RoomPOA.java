package adventure;


/**
* adventure/RoomPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// relevant information about a room.
public abstract class RoomPOA extends org.omg.PortableServer.Servant
 implements adventure.RoomOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("player_entered", new Integer (0));
    _methods.put ("player_left", new Integer (1));
    _methods.put ("item_added", new Integer (2));
    _methods.put ("item_removed", new Integer (3));
    _methods.put ("send_command", new Integer (4));
    _methods.put ("ping", new Integer (5));
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

  // entering and leaving the room.
       case 0:  // adventure/Room/player_entered
       {
         Player p = adventure.PlayerHelper.read (in);
         this.player_entered (p);
         out = $rh.createReply();
         break;
       }

       case 1:  // adventure/Room/player_left
       {
         Player p = adventure.PlayerHelper.read (in);
         this.player_left (p);
         out = $rh.createReply();
         break;
       }


  // room or removed from the room.
       case 2:  // adventure/Room/item_added
       {
         Item i = adventure.ItemHelper.read (in);
         this.item_added (i);
         out = $rh.createReply();
         break;
       }

       case 3:  // adventure/Room/item_removed
       {
         Item i = adventure.ItemHelper.read (in);
         this.item_removed (i);
         out = $rh.createReply();
         break;
       }


  // in the game server, it is forwarded to the room.
       case 4:  // adventure/Room/send_command
       {
         Player p = adventure.PlayerHelper.read (in);
         String command = in.read_string ();
         this.send_command (p, command);
         out = $rh.createReply();
         break;
       }


  // reachable
       case 5:  // adventure/IPing/ping
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
    "IDL:adventure/Room:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Room _this() 
  {
    return RoomHelper.narrow(
    super._this_object());
  }

  public Room _this(org.omg.CORBA.ORB orb) 
  {
    return RoomHelper.narrow(
    super._this_object(orb));
  }


} // class RoomPOA
