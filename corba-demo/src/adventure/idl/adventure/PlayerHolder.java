package adventure;

/**
* adventure/PlayerHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// relevant information of the location and state of a player.
public final class PlayerHolder implements org.omg.CORBA.portable.Streamable
{
  public Player value = null;

  public PlayerHolder ()
  {
  }

  public PlayerHolder (Player initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PlayerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PlayerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PlayerHelper.type ();
  }

}
