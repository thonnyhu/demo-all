package adventure;

/**
* adventure/ItemHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class ItemHolder implements org.omg.CORBA.portable.Streamable
{
  public Item value = null;

  public ItemHolder ()
  {
  }

  public ItemHolder (Item initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ItemHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ItemHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ItemHelper.type ();
  }

}
