package adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RoomImpl extends RoomPOA{
    RoomID roomID ;
    RoomID mainRoom = new RoomID("main",0);

    CBRoomServer cbRoomServer ;
    List<Player> players = new ArrayList<Player>();
    List<Item> items = new ArrayList<Item>();
    Map<Player,List<Answer>> answers = new HashMap<Player, List<Answer>>();

    public RoomID getRoomID(){
        return this.roomID;
    }

    public void setCbRoomServer(CBRoomServer cbRoomServer) {
        this.cbRoomServer = cbRoomServer;
    }
    public RoomImpl(){
        roomID = new RoomID("tangx",89757);
    }
    public void player_entered(Player p) {
        players.add(p);
    }

    public void player_left(Player p) {
        players.remove(p);
    }

    public void item_added(Item i) {
        items.add(i);
    }

    public void item_removed(Item i) {
        items.remove(i);
    }

    public void send_command(Player p, String command) {
        System.out.println("cmd = " + command);
        if(command.equalsIgnoreCase("help")){
            try {
                cbRoomServer.send_message(mainRoom.room_number,p,new String[]{"This is tangx's room, the command list is:",
                        "/say <text> -- talk to others in the room",
                        "/talk <user_name>:<text> -- talk to someone in the same room",
                        "/go <room_name> -- go into the room with name <room_name>",
                        "/take <item_id> -- get a item from my room",
                        "/release <item_id> -- put a item into my room"});
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.player_not_in_room player_not_in_room) {
                player_not_in_room.printStackTrace();
            }
        }else if (command.equalsIgnoreCase("description")){
            try {
                cbRoomServer.send_message(mainRoom.room_number,p,new String[]{"Hello,this is tangx's room.\nThe room's id is 149073662"});
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.player_not_in_room player_not_in_room) {
                player_not_in_room.printStackTrace();
            }
        }else if (command.startsWith("go")){
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
        }else if (command.startsWith("say")){
            try{
                String content = command.substring(5);
                cbRoomServer.broadcast_message(roomID.room_number,new String[]{content});
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            }
        }else if (command.startsWith("take")){
            int id = Integer.parseInt(command.substring(6));
            ItemLocation l = new ItemLocation();
            l.p(p);
            try {
                cbRoomServer.move_item(roomID.room_number,p,id,l);
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.cant_move_item cant_move_item) {
                cant_move_item.printStackTrace();
            }
        }else if (command.startsWith("release")){
            int id = Integer.parseInt(command.substring(9));
            ItemLocation l = new ItemLocation();
            l.r(roomID);
            try {
                cbRoomServer.move_item(roomID.room_number,p,id,l);
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.cant_move_item cant_move_item) {
                cant_move_item.printStackTrace();
            }
        }else if (command.startsWith("questionnaire")){
            for (Player temp :players
                 ) {
                try {
                    cbRoomServer.send_message(roomID.room_number,temp,new String[] {Questionnaire.declare});
                } catch (adventure.room_not_found room_not_found) {
                    room_not_found.printStackTrace();
                } catch (adventure.player_not_in_room player_not_in_room) {
                    player_not_in_room.printStackTrace();
                }
            }
        }else if(command.startsWith("accept")){
            try {
                cbRoomServer.send_message(roomID.room_number,p,new String[] {Questionnaire.firstQuestion});
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.player_not_in_room player_not_in_room) {
                player_not_in_room.printStackTrace();
            }
        }else if(command.startsWith("answer1")){
            String content = command.substring(9);
            Answer answer = new Answer();
            answer.setQuestion(Questionnaire.firstQuestion);
            answer.setAnswer(content);
            List<Answer> answerList = this.answers.get(p);
            if(answerList == null){
                answerList = new ArrayList<Answer>();
            }
            answerList.add(answer);
            this.answers.put(p,answerList);
            try {
                cbRoomServer.send_message(roomID.room_number,p,new String[] {Questionnaire.secondQuestion});
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.player_not_in_room player_not_in_room) {
                player_not_in_room.printStackTrace();
            }
        }else if(command.startsWith("answer2")){
            String content = command.substring(9);
            Answer answer = new Answer();
            answer.setQuestion(Questionnaire.secondQuestion);
            answer.setAnswer(content);
            List<Answer> answerList = this.answers.get(p);
            answerList.add(answer);
            answers.put(p,answerList);
            try {
                cbRoomServer.send_message(roomID.room_number,p,new String[] {Questionnaire.end});
            } catch (adventure.room_not_found room_not_found) {
                room_not_found.printStackTrace();
            } catch (adventure.player_not_in_room player_not_in_room) {
                player_not_in_room.printStackTrace();
            }
        }

    }

    public void ping() {
        System.out.println("pong");
    }

class Questionnaire{
   public static final String declare = "Hello,This is tangx's room.\nYou are invited to participate in a questionnaire\nPlease type /accept to continue,Or /reject to break;";
    public static final String firstQuestion ="Do you like banana? --- Please type /answer1 <Yes/No>";
    public static final String secondQuestion ="Do you like this course? --- Please type /answer2 <Yes/No>";
    public static final String end = "Thanks.It's end";
}
}
