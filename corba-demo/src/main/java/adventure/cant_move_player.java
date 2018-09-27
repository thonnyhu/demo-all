package adventure;


/**
* adventure/cant_move_player.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class cant_move_player extends org.omg.CORBA.UserException
{
  public String reason = null;

  public cant_move_player ()
  {
    super(cant_move_playerHelper.id());
  } // ctor

  public cant_move_player (String _reason)
  {
    super(cant_move_playerHelper.id());
    reason = _reason;
  } // ctor


  public cant_move_player (String $reason, String _reason)
  {
    super(cant_move_playerHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class cant_move_player
