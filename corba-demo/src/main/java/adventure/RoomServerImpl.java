package adventure;


import org.omg.CORBA.ORB;

public class RoomServerImpl extends IRoomServerPOA {

    private ORB orb;

    private Room myRoom;

    public void setMyRoom(Room myRoom) {
        this.myRoom = myRoom;
    }


    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    public Room find_room(int n) throws room_not_found {
        return myRoom;
    }

    public void ping() {
        System.out.println("pong!");
    }


}
