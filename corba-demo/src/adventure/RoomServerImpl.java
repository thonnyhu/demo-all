package adventure;

import adventure.IRoomServerPOA;
import adventure.Room;
import adventure.room_not_found;
import org.omg.CORBA.ORB;

/**
 * Created by Mirana on 16/1/31.
 */
public class RoomServerImpl extends IRoomServerPOA{

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    public Room find_room(int n) throws room_not_found {
        throw new room_not_found();
    }

    public void ping() {
        System.out.println("pong!");
    }
}
