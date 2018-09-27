package adventure;


/**
* adventure/ItemPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从adventure.idl
* 2016年1月31日 星期日 下午03时34分09秒 CST
*/

public abstract class ItemPOA extends org.omg.PortableServer.Servant
 implements adventure.ItemOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_item_id", new Integer (0));
    _methods.put ("_get_item_name", new Integer (1));
    _methods.put ("_get_description", new Integer (2));
    _methods.put ("_get_location", new Integer (3));
    _methods.put ("ping", new Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // adventure/Item/_get_item_id
       {
         int $result = (int)0;
         $result = this.item_id ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // adventure/Item/_get_item_name
       {
         String $result = null;
         $result = this.item_name ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // adventure/Item/_get_description
       {
         String $result = null;
         $result = this.description ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // adventure/Item/_get_location
       {
         adventure.ItemLocation $result = null;
         $result = this.location ();
         out = $rh.createReply();
         adventure.ItemLocationHelper.write (out, $result);
         break;
       }


  // reachable
       case 4:  // adventure/IPing/ping
       {
         this.ping ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:adventure/Item:1.0", 
    "IDL:adventure/IPing:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Item _this() 
  {
    return ItemHelper.narrow(
    super._this_object());
  }

  public Item _this(org.omg.CORBA.ORB orb) 
  {
    return ItemHelper.narrow(
    super._this_object(orb));
  }


} // class ItemPOA
