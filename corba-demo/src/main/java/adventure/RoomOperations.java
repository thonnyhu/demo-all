package adventure;


/**
* adventure/RoomOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// relevant information about a room.
public interface RoomOperations  extends adventure.IPingOperations
{

  // entering and leaving the room.
  void player_entered(Player p);
  void player_left(Player p);

  // room or removed from the room.
  void item_added(Item i);
  void item_removed(Item i);

  // in the game server, it is forwarded to the room.
  void send_command(Player p, String command);
} // interface RoomOperations
