package adventure;


/**
* adventure/ItemLocationDescriptor.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// to distinguish between these two possibilities.
public class ItemLocationDescriptor implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static ItemLocationDescriptor[] __array = new ItemLocationDescriptor [__size];

  public static final int _inRoom = 0;
  public static final ItemLocationDescriptor inRoom = new ItemLocationDescriptor(_inRoom);
  public static final int _withPlayer = 1;
  public static final ItemLocationDescriptor withPlayer = new ItemLocationDescriptor(_withPlayer);

  public int value ()
  {
    return __value;
  }

  public static ItemLocationDescriptor from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected ItemLocationDescriptor (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class ItemLocationDescriptor
