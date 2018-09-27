package adventure;


/**
* adventure/room_not_found.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class room_not_found extends org.omg.CORBA.UserException
{
  public String reason = null;

  public room_not_found ()
  {
    super(room_not_foundHelper.id());
  } // ctor

  public room_not_found (String _reason)
  {
    super(room_not_foundHelper.id());
    reason = _reason;
  } // ctor


  public room_not_found (String $reason, String _reason)
  {
    super(room_not_foundHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class room_not_found
