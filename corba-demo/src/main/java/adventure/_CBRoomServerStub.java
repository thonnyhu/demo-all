package adventure;


/**
* adventure/_CBRoomServerStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// game server and the players
public class _CBRoomServerStub extends org.omg.CORBA.portable.ObjectImpl implements CBRoomServer
{


  // server and the rooms associated with it from the game
  public void unregister ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unregister", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                unregister (        );
            } finally {
                _releaseReply ($in);
            }
  } // unregister


  // can send its response back
  public void send_message (int room_number, Player p, String[] message) throws room_not_found, adventure.player_not_in_room
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("send_message", true);
                $out.write_long (room_number);
                PlayerHelper.write ($out, p);
                adventure.string_sequenceHelper.write ($out, message);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:adventure/room_not_found:1.0"))
                    throw adventure.room_not_foundHelper.read ($in);
                else if (_id.equals ("IDL:adventure/player_not_in_room:1.0"))
                    throw adventure.player_not_in_roomHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                send_message (room_number, p, message        );
            } finally {
                _releaseReply ($in);
            }
  } // send_message


  // can send its response back
  public void broadcast_message (int room_number, String[] message) throws room_not_found
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("broadcast_message", true);
                $out.write_long (room_number);
                adventure.string_sequenceHelper.write ($out, message);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:adventure/room_not_found:1.0"))
                    throw adventure.room_not_foundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                broadcast_message (room_number, message        );
            } finally {
                _releaseReply ($in);
            }
  } // broadcast_message


  // Move a player
  public void move_player (int room_number, Player p, RoomID new_room) throws room_not_found, cant_move_player
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("move_player", true);
                $out.write_long (room_number);
                PlayerHelper.write ($out, p);
                RoomIDHelper.write ($out, new_room);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:adventure/room_not_found:1.0"))
                    throw adventure.room_not_foundHelper.read ($in);
                else if (_id.equals ("IDL:adventure/cant_move_player:1.0"))
                    throw adventure.cant_move_playerHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                move_player (room_number, p, new_room        );
            } finally {
                _releaseReply ($in);
            }
  } // move_player


  // Move an item
  public void move_item (int room_number, Player p, int i, ItemLocation new_location) throws room_not_found, cant_move_item
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("move_item", true);
                $out.write_long (room_number);
                PlayerHelper.write ($out, p);
                $out.write_long (i);
                adventure.ItemLocationHelper.write ($out, new_location);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:adventure/room_not_found:1.0"))
                    throw adventure.room_not_foundHelper.read ($in);
                else if (_id.equals ("IDL:adventure/cant_move_item:1.0"))
                    throw adventure.cant_move_itemHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                move_item (room_number, p, i, new_location        );
            } finally {
                _releaseReply ($in);
            }
  } // move_item


  // reachable
  public void ping ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ping", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                ping (        );
            } finally {
                _releaseReply ($in);
            }
  } // ping

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:adventure/CBRoomServer:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _CBRoomServerStub
