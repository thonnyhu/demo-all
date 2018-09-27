package adventure;


/**
* adventure/registration_failed.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class registration_failed extends org.omg.CORBA.UserException
{
  public String reason = null;

  public registration_failed ()
  {
    super(registration_failedHelper.id());
  } // ctor

  public registration_failed (String _reason)
  {
    super(registration_failedHelper.id());
    reason = _reason;
  } // ctor


  public registration_failed (String $reason, String _reason)
  {
    super(registration_failedHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class registration_failed
