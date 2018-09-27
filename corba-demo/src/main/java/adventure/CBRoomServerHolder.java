package adventure;

/**
* adventure/CBRoomServerHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// game server and the players
public final class CBRoomServerHolder implements org.omg.CORBA.portable.Streamable
{
  public CBRoomServer value = null;

  public CBRoomServerHolder ()
  {
  }

  public CBRoomServerHolder (CBRoomServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CBRoomServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CBRoomServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CBRoomServerHelper.type ();
  }

}
