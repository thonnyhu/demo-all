package adventure;

/**
* adventure/room_not_foundHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class room_not_foundHolder implements org.omg.CORBA.portable.Streamable
{
  public room_not_found value = null;

  public room_not_foundHolder ()
  {
  }

  public room_not_foundHolder (room_not_found initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = room_not_foundHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    room_not_foundHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return room_not_foundHelper.type ();
  }

}
