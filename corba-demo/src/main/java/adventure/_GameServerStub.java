package adventure;


/**
* adventure/_GameServerStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public class _GameServerStub extends org.omg.CORBA.portable.ObjectImpl implements GameServer
{


  // server. This operation makes new rooms available to the game
  public CBRoomServer register (String user_name, String secret_hash, IRoomServer room_server) throws adventure.registration_failed
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("register", true);
                $out.write_string (user_name);
                $out.write_string (secret_hash);
                adventure.IRoomServerHelper.write ($out, room_server);
                $in = _invoke ($out);
                CBRoomServer $result = adventure.CBRoomServerHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:adventure/registration_failed:1.0"))
                    throw adventure.registration_failedHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return register (user_name, secret_hash, room_server        );
            } finally {
                _releaseReply ($in);
            }
  } // register


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
    "IDL:adventure/GameServer:1.0", 
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
} // class _GameServerStub
