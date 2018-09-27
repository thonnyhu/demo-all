package adventure;


/**
* adventure/GameServerHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

abstract public class GameServerHelper
{
  private static String  _id = "IDL:adventure/GameServer:1.0";

  public static void insert (org.omg.CORBA.Any a, GameServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static GameServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (GameServerHelper.id (), "GameServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static GameServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GameServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, GameServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static GameServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof GameServer)
      return (GameServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _GameServerStub stub = new _GameServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static GameServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof GameServer)
      return (GameServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _GameServerStub stub = new _GameServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
