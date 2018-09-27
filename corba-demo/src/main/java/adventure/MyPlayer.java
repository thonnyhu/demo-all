package adventure;

/**
 * Created by Mirana on 16/2/23.
 */
public class MyPlayer extends PlayerPOA{



    public String user_name() {
        return "tangx";
    }

    public String real_name() {
        return "xueran tang";
    }

    public RoomID location() {
        return new RoomID("tangx",1);
    }

    public void ping() {

    }
}
