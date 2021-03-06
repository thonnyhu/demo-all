package adventure;


/**
* adventure/ItemLocationDescriptorHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/


// to distinguish between these two possibilities.
abstract public class ItemLocationDescriptorHelper
{
  private static String  _id = "IDL:adventure/ItemLocationDescriptor:1.0";

  public static void insert (org.omg.CORBA.Any a, ItemLocationDescriptor that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ItemLocationDescriptor extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (ItemLocationDescriptorHelper.id (), "ItemLocationDescriptor", new String[] { "inRoom", "withPlayer"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ItemLocationDescriptor read (org.omg.CORBA.portable.InputStream istream)
  {
    return ItemLocationDescriptor.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ItemLocationDescriptor value)
  {
    ostream.write_long (value.value ());
  }

}
