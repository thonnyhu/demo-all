package adventure;

/**
 * Created by Mirana on 16/3/17.
 */
public class MyItem extends ItemPOA{
    ItemLocation location ;
    int id;
    String name;

    public MyItem(int id,String name,ItemLocation location){
        this.id = id;
        this.name = name;
        this.location = location;
    }
    public int item_id() {
        return id;
    }

    public String item_name() {
        return name;
    }

    public String description() {
        return "this item created by tangx";
    }

    public ItemLocation location() {
        return location;
    }

    public void ping() {

    }
}
