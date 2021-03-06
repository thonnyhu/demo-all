package adventure;

/**
* adventure/RoomIDHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class RoomIDHolder implements org.omg.CORBA.portable.Streamable
{
  public RoomID value = null;

  public RoomIDHolder ()
  {
  }

  public RoomIDHolder (RoomID initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RoomIDHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RoomIDHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RoomIDHelper.type ();
  }

}
