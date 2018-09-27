package adventure;

/**
* adventure/ItemLocationHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class ItemLocationHolder implements org.omg.CORBA.portable.Streamable
{
  public ItemLocation value = null;

  public ItemLocationHolder ()
  {
  }

  public ItemLocationHolder (ItemLocation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ItemLocationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ItemLocationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ItemLocationHelper.type ();
  }

}
