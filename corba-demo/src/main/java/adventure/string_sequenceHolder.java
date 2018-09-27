package adventure;


/**
* adventure/string_sequenceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// responses and thus reduce the number of calls needed to communicate with the frontend.
public final class string_sequenceHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public string_sequenceHolder ()
  {
  }

  public string_sequenceHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = string_sequenceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    string_sequenceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return string_sequenceHelper.type ();
  }

}
