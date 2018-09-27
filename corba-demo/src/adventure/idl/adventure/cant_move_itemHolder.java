package adventure;

/**
* adventure/cant_move_itemHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class cant_move_itemHolder implements org.omg.CORBA.portable.Streamable
{
  public cant_move_item value = null;

  public cant_move_itemHolder ()
  {
  }

  public cant_move_itemHolder (cant_move_item initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = cant_move_itemHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    cant_move_itemHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return cant_move_itemHelper.type ();
  }

}
