package adventure;


/**
* adventure/PlayerOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// relevant information of the location and state of a player.
public interface PlayerOperations  extends IPingOperations
{
  String user_name();
  String real_name();
  RoomID location();
} // interface PlayerOperations
