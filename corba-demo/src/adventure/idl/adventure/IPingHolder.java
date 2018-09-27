package adventure;

/**
* adventure/IPingHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// interface IPing
public final class IPingHolder implements org.omg.CORBA.portable.Streamable
{
  public IPing value = null;

  public IPingHolder ()
  {
  }

  public IPingHolder (IPing initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = IPingHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    IPingHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return IPingHelper.type ();
  }

}
