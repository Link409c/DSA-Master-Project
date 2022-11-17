package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;
import ManualLinkedList.Node;

/**
 * playerMovement moves the player object through the dungeon rooms.
 * @author Christian Simpson
 * @version 11/10/22
 */
public class PlayerMovement {

    /**
     * movePlayer places player object in new Room in the list of rooms and returns that updated list.
     * @param d the Dungeon object
     * @param direction the direction the player wants to move.
     * @return returns an updated list of rooms to be set as the Game's Dungeon's rooms list variable.
     */
    //TODO Movement is producing null pointer exceptions must fix
    public ChristianHolder<Room> movePlayer(Dungeon d, Player p, char direction){
        ChristianHolder<Room> rooms = d.getDungeonRooms();
        Node<Room> curr = rooms.getHead();
        for (int i = 0; i < rooms.getSize(); i++){
            if(curr.getE().getThePlayer() != null){
                curr = curr.getNext();
            }
        }
        int origin = rooms.findAPosition(curr);
        if(direction == 'l') {
            rooms.findNodeAtPosition(origin).getPrev().getE().setThePlayer(p);
            rooms.findNodeAtPosition(origin).getE().setThePlayer(null);
        }
        else if(direction == 'r'){
            rooms.findNodeAtPosition(origin).getNext().getE().setThePlayer(p);
            rooms.findNodeAtPosition(origin).getE().setThePlayer(null);
        }
        return rooms;
    }

    public PlayerMovement(){

    }

}
