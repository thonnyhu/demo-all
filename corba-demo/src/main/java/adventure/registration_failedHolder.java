package adventure;

/**
* adventure/registration_failedHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class registration_failedHolder implements org.omg.CORBA.portable.Streamable
{
  public registration_failed value = null;

  public registration_failedHolder ()
  {
  }

  public registration_failedHolder (registration_failed initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = registration_failedHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    registration_failedHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return registration_failedHelper.type ();
  }

}
