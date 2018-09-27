package adventure;


/**
* adventure/ItemLocation.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public final class ItemLocation implements org.omg.CORBA.portable.IDLEntity
{
  private RoomID ___r;
  private Player ___p;
  private adventure.ItemLocationDescriptor __discriminator;
  private boolean __uninitialized = true;

  public ItemLocation ()
  {
  }

  public adventure.ItemLocationDescriptor discriminator ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    return __discriminator;
  }

  public RoomID r ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    verifyr (__discriminator);
    return ___r;
  }

  public void r (RoomID value)
  {
    __discriminator = adventure.ItemLocationDescriptor.inRoom;
    ___r = value;
    __uninitialized = false;
  }

  public void r (adventure.ItemLocationDescriptor discriminator, RoomID value)
  {
    verifyr (discriminator);
    __discriminator = discriminator;
    ___r = value;
    __uninitialized = false;
  }

  private void verifyr (adventure.ItemLocationDescriptor discriminator)
  {
    if (discriminator != adventure.ItemLocationDescriptor.inRoom)
      throw new org.omg.CORBA.BAD_OPERATION ();
  }

  public Player p ()
  {
    if (__uninitialized)
      throw new org.omg.CORBA.BAD_OPERATION ();
    verifyp (__discriminator);
    return ___p;
  }

  public void p (Player value)
  {
    __discriminator = adventure.ItemLocationDescriptor.withPlayer;
    ___p = value;
    __uninitialized = false;
  }

  public void p (adventure.ItemLocationDescriptor discriminator, Player value)
  {
    verifyp (discriminator);
    __discriminator = discriminator;
    ___p = value;
    __uninitialized = false;
  }

  private void verifyp (adventure.ItemLocationDescriptor discriminator)
  {
    if (discriminator != adventure.ItemLocationDescriptor.withPlayer)
      throw new org.omg.CORBA.BAD_OPERATION ();
  }

} // class ItemLocation
