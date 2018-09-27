package adventure;


/**
* adventure/ItemLocationHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

abstract public class ItemLocationHelper
{
  private static String  _id = "IDL:adventure/ItemLocation:1.0";

  public static void insert (org.omg.CORBA.Any a, ItemLocation that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ItemLocation extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      org.omg.CORBA.TypeCode _disTypeCode0;
      _disTypeCode0 = adventure.ItemLocationDescriptorHelper.type ();
      org.omg.CORBA.UnionMember[] _members0 = new org.omg.CORBA.UnionMember [2];
      org.omg.CORBA.TypeCode _tcOf_members0;
      org.omg.CORBA.Any _anyOf_members0;

      // Branch for r (case label inRoom)
      _anyOf_members0 = org.omg.CORBA.ORB.init ().create_any ();
      adventure.ItemLocationDescriptorHelper.insert (_anyOf_members0, adventure.ItemLocationDescriptor.inRoom);
      _tcOf_members0 = RoomIDHelper.type ();
      _members0[0] = new org.omg.CORBA.UnionMember (
        "r",
        _anyOf_members0,
        _tcOf_members0,
        null);

      // Branch for p (case label withPlayer)
      _anyOf_members0 = org.omg.CORBA.ORB.init ().create_any ();
      adventure.ItemLocationDescriptorHelper.insert (_anyOf_members0, adventure.ItemLocationDescriptor.withPlayer);
      _tcOf_members0 = PlayerHelper.type ();
      _members0[1] = new org.omg.CORBA.UnionMember (
        "p",
        _anyOf_members0,
        _tcOf_members0,
        null);
      __typeCode = org.omg.CORBA.ORB.init ().create_union_tc (ItemLocationHelper.id (), "ItemLocation", _disTypeCode0, _members0);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ItemLocation read (org.omg.CORBA.portable.InputStream istream)
  {
    ItemLocation value = new ItemLocation ();
    adventure.ItemLocationDescriptor _dis0 = null;
    _dis0 = adventure.ItemLocationDescriptorHelper.read (istream);
    switch (_dis0.value ())
    {
      case adventure.ItemLocationDescriptor._inRoom:
        RoomID _r = null;
        _r = RoomIDHelper.read (istream);
        value.r (_r);
        break;
      case adventure.ItemLocationDescriptor._withPlayer:
        Player _p = null;
        _p = PlayerHelper.read (istream);
        value.p (_p);
        break;
    }
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ItemLocation value)
  {
    adventure.ItemLocationDescriptorHelper.write (ostream, value.discriminator ());
    switch (value.discriminator ().value ())
    {
      case adventure.ItemLocationDescriptor._inRoom:
        RoomIDHelper.write (ostream, value.r ());
        break;
      case adventure.ItemLocationDescriptor._withPlayer:
        PlayerHelper.write (ostream, value.p ());
        break;
    }
  }

}
