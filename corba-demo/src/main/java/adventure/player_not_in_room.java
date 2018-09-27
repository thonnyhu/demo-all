package adventure;


/**
* adventure/player_not_in_room.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class player_not_in_room extends org.omg.CORBA.UserException
{
  public Player p = null;

  public player_not_in_room ()
  {
    super(player_not_in_roomHelper.id());
  } // ctor

  public player_not_in_room (Player _p)
  {
    super(player_not_in_roomHelper.id());
    p = _p;
  } // ctor


  public player_not_in_room (String $reason, Player _p)
  {
    super(player_not_in_roomHelper.id() + "  " + $reason);
    p = _p;
  } // ctor

} // class player_not_in_room
