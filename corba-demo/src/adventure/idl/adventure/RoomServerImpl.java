package adventure;


import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomServerImpl extends IRoomServerPOA {

    private ORB orb;

    private String ioc;

    private  CBRoomServer cbRoomServer;

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public String getIoc() {
        return ioc;
    }

    //设置服务器中转站的引用
    public void setCbRoomServer(CBRoomServer cbRoomServer) {
        this.cbRoomServer = cbRoomServer;
    }
    public CBRoomServer getCbRoomServer() {
        return cbRoomServer;
    }

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    public Room find_room(int n) throws room_not_found {
        try{

            Room myRoom = RoomHelper.narrow( orb.string_to_object(ioc));
            if(myRoom==null){
                throw new room_not_found();
            }
            return myRoom;
        }catch (Exception e){
            throw new room_not_found();
        }
    }

    public void ping() {
        System.out.println("pong!");
    }

    class MyRoom extends RoomPOA{
        RoomID roomID ;
        RoomID mainRoom = new RoomID("main",0);

        public MyRoom(){
            roomID = new RoomID("tangx",149073662);
        }
        List<Player> players = new ArrayList<Player>();
        public void player_entered(Player p) {
            try {
                cbRoomServer.move_player(0,p,roomID);
                players.add(p);
                System.out.println("Welcome to tangx's room..\nif you want to go back to main room,please enter /go <room_name>\n the main room_name is main'");
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.cant_move_player cant_move_player) {
                cant_move_player.printStackTrace();
            }

        }

        public void player_left(Player p) {
            try {
                cbRoomServer.move_player(roomID.room_number,p,mainRoom);
                players.remove(p);
                System.out.println(p.user_name() + "has left the room..");
            }catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.cant_move_player cant_move_player) {
                cant_move_player.printStackTrace();
            }
        }

        public void item_added(Item i) {

        }

        public void item_removed(Item i) {

        }

        public void send_command(Player p, String command) {
            if(command.equalsIgnoreCase("/help")){
                System.out.println("This is tangx's room, the command list is:");
                System.out.println("/say <text> -- talk to others in the room");
                System.out.println("/talk <user_name>:<text> -- talk to someone in the same room");
                System.out.println("/go <room_name> -- go into the room with name <room_name>");
            }else if (command.equalsIgnoreCase("/description")){
                System.out.println("Hello,this is tangx's room.\nThe room's id is 149073662");
            }else if (command.startsWith("/go")){
                try {
                    String roomName = command.substring(4);
                    if(roomName.equals("main")){
                        cbRoomServer.move_player(roomID.room_number,p,mainRoom);
                    }else {
                        System.out.println("sorry,you type a wrong room name");
                    }
                } catch (adventure.room_not_found room_not_found) {
                    room_not_found.printStackTrace();
                } catch (adventure.cant_move_player cant_move_player) {
                    cant_move_player.printStackTrace();
                }

            }else if (command.startsWith("/say")){
                try{
                    String content = command.substring(5);
                    cbRoomServer.broadcast_message(roomID.room_number,new String[]{content});
                } catch (adventure.room_not_found room_not_found) {
                    room_not_found.printStackTrace();
                }
            }else if (command.startsWith("/talk")){
                try{
                    String content = command.substring(5);
                    int i = content.indexOf(":");
                    Player toTalk = null;
                    String playerName = command.substring(0,i);
                    for (Player temp:players){
                        if(temp.user_name().equals(playerName)) {
                            toTalk = temp;
                            break;
                        }
                    }
                    if(toTalk == null) throw new player_not_in_room();
                    String text = command.substring(i+1);
                    cbRoomServer.send_message(roomID.room_number,toTalk,new String[]{text});
                } catch (adventure.player_not_in_room player_not_in_room) {
                    player_not_in_room.printStackTrace();
                } catch (adventure.room_not_found room_not_found) {
                    room_not_found.printStackTrace();
                }
            }

        }

        public void ping() {
            System.out.println("pong");
        }


    }

    public static void main(String[] args) {
        try {
            System.out.println("/go west".substring(4));
            /* 创建和初始化 ORB */
            args = new String[]{"-ORBInitialHost", "localhost", "-ORBInitialPort", "60506"};
            ORB orb = ORB.init(args, null);
            RoomServerImpl a = new RoomServerImpl();
            a.setOrb(orb);
            a.setIoc("IOR:000000000000001749444c3a616476656e747572652f526f6f6d3a312e300000000000010000000000000082000102000000000a3132372e302e302e3100ec5a00000031afabcb000000002013d107cb00000001000000000000000100000008526f6f74504f410000000008000000020000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            Room room1 = a.find_room(1);
            room1.ping();
            Player p = PlayerHelper.narrow(orb.string_to_object("corbaloc::localhost:1060/player"));
            room1.send_command(p,"/help");
        } catch (Exception e) {
            System.out.println("错误 : " + e);
            e.printStackTrace(System.out);
        }
    }
}
