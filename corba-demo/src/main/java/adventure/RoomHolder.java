package adventure;

/**
* adventure/RoomHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// relevant information about a room.
public final class RoomHolder implements org.omg.CORBA.portable.Streamable
{
  public Room value = null;

  public RoomHolder ()
  {
  }

  public RoomHolder (Room initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RoomHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RoomHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RoomHelper.type ();
  }

}
