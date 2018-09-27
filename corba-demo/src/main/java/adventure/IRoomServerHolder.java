package adventure;

/**
* adventure/IRoomServerHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// Interface of the room server offered to the game server
public final class IRoomServerHolder implements org.omg.CORBA.portable.Streamable
{
  public IRoomServer value = null;

  public IRoomServerHolder ()
  {
  }

  public IRoomServerHolder (IRoomServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = IRoomServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    IRoomServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return IRoomServerHelper.type ();
  }

}
