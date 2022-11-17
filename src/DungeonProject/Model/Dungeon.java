package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;

/**
 * Dungeon class is the environment the Dungeon Crawler Game will be played in. Each instance
 * of the object is considered a floor, with each floor containing a linked list of rooms for
 * the player to traverse.
 */
public class Dungeon {

    //getters, setters, and global variables

    private ChristianHolder<Room> dungeonRooms;

    private int currentFloor;

    private int playerPosition;

    //used for new game
    public Dungeon(){
        setCurrentFloor(1);
    }

    //used for new floors
    public Dungeon(Dungeon d){
        setCurrentFloor(d.getCurrentFloor());
        setDungeonRooms(null);
        setPlayerPosition(0);
    }

    public ChristianHolder<Room> getDungeonRooms() {
        return dungeonRooms;
    }

    public void setDungeonRooms(ChristianHolder<Room> dungeonRooms) {
        this.dungeonRooms = dungeonRooms;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
}
