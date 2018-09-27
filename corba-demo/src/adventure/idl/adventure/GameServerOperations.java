package adventure;


/**
* adventure/GameServerOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public interface GameServerOperations  extends IPingOperations
{

  // server. This operation makes new rooms available to the game
  CBRoomServer register(String user_name, String secret_hash, IRoomServer room_server) throws registration_failed;
} // interface GameServerOperations
