package adventure;

/**
* adventure/player_not_in_roomHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class player_not_in_roomHolder implements org.omg.CORBA.portable.Streamable
{
  public player_not_in_room value = null;

  public player_not_in_roomHolder ()
  {
  }

  public player_not_in_roomHolder (player_not_in_room initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = player_not_in_roomHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    player_not_in_roomHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return player_not_in_roomHelper.type ();
  }

}
