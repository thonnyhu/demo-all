package adventure;


/**
* adventure/CBRoomServerPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// game server and the players
public abstract class CBRoomServerPOA extends org.omg.PortableServer.Servant
 implements adventure.CBRoomServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("unregister", new Integer (0));
    _methods.put ("send_message", new Integer (1));
    _methods.put ("broadcast_message", new Integer (2));
    _methods.put ("move_player", new Integer (3));
    _methods.put ("move_item", new Integer (4));
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

  // server and the rooms associated with it from the game
       case 0:  // adventure/CBRoomServer/unregister
       {
         this.unregister ();
         out = $rh.createReply();
         break;
       }


  // can send its response back
       case 1:  // adventure/CBRoomServer/send_message
       {
         try {
           int room_number = in.read_long ();
           Player p = PlayerHelper.read (in);
           String message[] = adventure.string_sequenceHelper.read (in);
           this.send_message (room_number, p, message);
           out = $rh.createReply();
         } catch (room_not_found $ex) {
           out = $rh.createExceptionReply ();
           adventure.room_not_foundHelper.write (out, $ex);
         } catch (adventure.player_not_in_room $ex) {
           out = $rh.createExceptionReply ();
           adventure.player_not_in_roomHelper.write (out, $ex);
         }
         break;
       }


  // can send its response back
       case 2:  // adventure/CBRoomServer/broadcast_message
       {
         try {
           int room_number = in.read_long ();
           String message[] = adventure.string_sequenceHelper.read (in);
           this.broadcast_message (room_number, message);
           out = $rh.createReply();
         } catch (room_not_found $ex) {
           out = $rh.createExceptionReply ();
           adventure.room_not_foundHelper.write (out, $ex);
         }
         break;
       }


  // Move a player
       case 3:  // adventure/CBRoomServer/move_player
       {
         try {
           int room_number = in.read_long ();
           Player p = PlayerHelper.read (in);
           RoomID new_room = RoomIDHelper.read (in);
           this.move_player (room_number, p, new_room);
           out = $rh.createReply();
         } catch (room_not_found $ex) {
           out = $rh.createExceptionReply ();
           adventure.room_not_foundHelper.write (out, $ex);
         } catch (adventure.cant_move_player $ex) {
           out = $rh.createExceptionReply ();
           adventure.cant_move_playerHelper.write (out, $ex);
         }
         break;
       }


  // Move an item
       case 4:  // adventure/CBRoomServer/move_item
       {
         try {
           int room_number = in.read_long ();
           Player p = PlayerHelper.read (in);
           int i = in.read_long ();
           ItemLocation new_location = adventure.ItemLocationHelper.read (in);
           this.move_item (room_number, p, i, new_location);
           out = $rh.createReply();
         } catch (room_not_found $ex) {
           out = $rh.createExceptionReply ();
           adventure.room_not_foundHelper.write (out, $ex);
         } catch (cant_move_item $ex) {
           out = $rh.createExceptionReply ();
           adventure.cant_move_itemHelper.write (out, $ex);
         }
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
    "IDL:adventure/CBRoomServer:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CBRoomServer _this() 
  {
    return CBRoomServerHelper.narrow(
    super._this_object());
  }

  public CBRoomServer _this(org.omg.CORBA.ORB orb) 
  {
    return CBRoomServerHelper.narrow(
    super._this_object(orb));
  }


} // class CBRoomServerPOA
