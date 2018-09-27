package adventure;


/**
* adventure/RoomID.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class RoomID implements org.omg.CORBA.portable.IDLEntity
{
  public String user_name = null;
  public int room_number = (int)0;

  public RoomID ()
  {
  } // ctor

  public RoomID (String _user_name, int _room_number)
  {
    user_name = _user_name;
    room_number = _room_number;
  } // ctor

} // class RoomID
