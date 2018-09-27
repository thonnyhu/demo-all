package adventure;


/**
* adventure/ItemOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public interface ItemOperations  extends adventure.IPingOperations
{
  int item_id();
  String item_name();
  String description();
  ItemLocation location();
} // interface ItemOperations
