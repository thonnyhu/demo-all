package adventure;


/**
* adventure/CBRoomServerOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// game server and the players
public interface CBRoomServerOperations  extends IPingOperations
{

  // server and the rooms associated with it from the game
  void unregister();

  // can send its response back
  void send_message(int room_number, Player p, String[] message) throws room_not_found, player_not_in_room;

  // can send its response back
  void broadcast_message(int room_number, String[] message) throws room_not_found;

  // Move a player
  void move_player(int room_number, Player p, RoomID new_room) throws room_not_found, cant_move_player;

  // Move an item
  void move_item(int room_number, Player p, int i, ItemLocation new_location) throws room_not_found, cant_move_item;
} // interface CBRoomServerOperations
