package adventure;


/**
* adventure/player_not_in_roomHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

abstract public class player_not_in_roomHelper
{
  private static String  _id = "IDL:adventure/player_not_in_room:1.0";

  public static void insert (org.omg.CORBA.Any a, player_not_in_room that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static player_not_in_room extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = PlayerHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "p",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (player_not_in_roomHelper.id (), "player_not_in_room", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static player_not_in_room read (org.omg.CORBA.portable.InputStream istream)
  {
    player_not_in_room value = new player_not_in_room ();
    // read and discard the repository ID
    istream.read_string ();
    value.p = PlayerHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, player_not_in_room value)
  {
    // write the repository ID
    ostream.write_string (id ());
    PlayerHelper.write (ostream, value.p);
  }

}
