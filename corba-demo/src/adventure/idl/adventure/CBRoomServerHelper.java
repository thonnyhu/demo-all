package adventure;


/**
* adventure/CBRoomServerHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// game server and the players
abstract public class CBRoomServerHelper
{
  private static String  _id = "IDL:adventure/CBRoomServer:1.0";

  public static void insert (org.omg.CORBA.Any a, CBRoomServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CBRoomServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CBRoomServerHelper.id (), "CBRoomServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CBRoomServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CBRoomServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CBRoomServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CBRoomServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CBRoomServer)
      return (CBRoomServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _CBRoomServerStub stub = new _CBRoomServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CBRoomServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CBRoomServer)
      return (CBRoomServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _CBRoomServerStub stub = new _CBRoomServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
