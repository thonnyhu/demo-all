package hello;

/**
* hello/HelloHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hello.idl
* 2016年2月22日 星期一 下午09时10分51秒 CST
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloHelper.type ();
  }

}
