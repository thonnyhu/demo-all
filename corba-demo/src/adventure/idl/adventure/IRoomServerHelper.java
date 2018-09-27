package adventure;


/**
* adventure/IRoomServerHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// Interface of the room server offered to the game server
abstract public class IRoomServerHelper
{
  private static String  _id = "IDL:adventure/IRoomServer:1.0";

  public static void insert (org.omg.CORBA.Any a, IRoomServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static IRoomServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (IRoomServerHelper.id (), "IRoomServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static IRoomServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IRoomServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, IRoomServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static IRoomServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof IRoomServer)
      return (IRoomServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _IRoomServerStub stub = new _IRoomServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static IRoomServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof IRoomServer)
      return (IRoomServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _IRoomServerStub stub = new _IRoomServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
