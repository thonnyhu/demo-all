package adventure;


/**
* adventure/IRoomServerOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// Interface of the room server offered to the game server
public interface IRoomServerOperations  extends IPingOperations
{

  // reference to one particular room
  Room find_room(int n) throws room_not_found;
} // interface IRoomServerOperations
