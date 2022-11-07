package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;

import static DungeonProject.Model.EquipmentType.*;
import static DungeonProject.Model.ItemType.*;
import static DungeonProject.Model.MonsterType.*;

import java.util.Random;


/**
 * Dungeon class is the environment the Dungeon Crawler Game will be played in. Each instance
 * of the object is considered a floor, with each floor containing a linked list of rooms for
 * the player to traverse.
 */
public class Dungeon {

    /**
     * generateRooms method creates the room objects that comprise the dungeon.
     * it will use the current floor to determine the maximum number of rooms the
     * dungeon can have. the number of rooms will be randomized in order to create
     * a different experience each time the game is played.
     *
     * @return returns a list of room objects.
     */

    public ChristianHolder<Room> generateRooms() {
        //create list to return
        ChristianHolder<Room> theRooms = new ChristianHolder<>();
        //create variable for max rooms
        int maxRooms;
        //get current floor of the dungeon
        int aFloor = getCurrentFloor();
        //if first floor, make limit 10
        if (aFloor == 1) {
            maxRooms = 10;
        }
        //beyond that, increase the rooms size by a maximum of 5 each floor
        else {
            maxRooms = 10 + (aFloor * 5);
        }
        //create random object to use for room number generation
        Random r = new Random();
        //we want minimum rooms to be half of max and max to be upper bound
        //randomize the number with a minimum and maximum
        int rooms = r.nextInt(maxRooms / 2, maxRooms + 1);
        //use the room number to generate that many rooms
        for (int i = 0; i < rooms; i++) {
            //place each room into the dungeon
            Room room = new Room();
            theRooms.add(room);
        }
        return theRooms;
    }

    /**
     * generateItems method creates the item objects that can be found by the player
     * in the dungeon. the method will ensure that at least one of each type of item
     * is created (Usable items, Equipment (Weapon, Armor, Accessory), with the limit
     * being determined by the floor and dungeon size only. Key items will be added in
     * a later version.
     *
     * @return returns a list of items.
     */

    public ChristianHolder<Item> generateItems() {
        //create list to return
        ChristianHolder<Item> anItems = new ChristianHolder<>();
        //get current floor of the dungeon
        int aFloor = getCurrentFloor();
        //get dungeon size
        int dungeonSize = getDungeonRooms().getSize();
        //create variable for max items
        int maxItems;
        //to avoid an overabundance of items, limit the amount
        //quarter of size multiplied by floor number
        maxItems = (dungeonSize / 3) * aFloor;
        //generate random items with at least one of each type, limited by amount
        //usable items are always prioritized
        for (int i = 0; i < maxItems; i++) {
            //code
        }
        return anItems;
    }

    /**
     * generateMonsters method creates the monster objects that will populate the dungeon's
     * Rooms. the method will create a number of monsters dependent on the current floor, the
     * player level, and the number of rooms, with a random amount generated not to exceed the
     * room count of the floor.
     *
     * @return Returns a list of monsters.
     */

    public ChristianHolder<Monster> generateMonsters(Player p) {
        //create list to return
        ChristianHolder<Monster> theMonsters = new ChristianHolder<>();
        //create variable for max monsters
        int maxMonsters;
        //get current floor of the dungeon
        int aFloor = getCurrentFloor();
        //get player level
        int monsterScale = p.getLevel();
        //get dungeon size
        int dungeonSize = getDungeonRooms().getSize();
        //the smaller the room count the more difficult the monsters can be
        if(dungeonSize <= monsterScale/2){
            monsterScale += 2;
        }
        //to avoid an overabundance of monsters, limit the amount
        //we want to give the player a chance (until we don't)
        //half of size multiplied by floor number
        maxMonsters = (dungeonSize / 2) * aFloor;
        //limit monster types by section (scarier monsters deeper in the dungeon)
        //with floor limit of 99, about a third of the way sounds good for all the monster types
        Random r = new Random();
        int theType;
        MonsterType[] types = {Slime, Bat, Skeleton, Zombie, Goblin, Lizardman, Orc,
                Minotaur, Dragon, TreasureLizard};
        Monster m;
        for(int i = 0; i < maxMonsters; i++) {
            //treasure lizards can spawn on any floor but are rare
            //if floor <= 10, slimes, bats, and skeletons can spawn
            if(aFloor <= 10){
                theType = r.nextInt(3);
                m = new Monster(types[theType], getCurrentFloor(), monsterScale);
                theMonsters.add(m);
            }
            //if floor >= 11 and < 20, goblins, lizardmen, and orcs can also spawn
            else if(aFloor > 10 && aFloor <= 20){
                theType = r.nextInt(6);
                m = new Monster(types[theType], getCurrentFloor(), monsterScale);
                theMonsters.add(m);
            }
            //if floor >= 21, minotaurs and dragons can also spawn
            else if(aFloor > 20){
                theType = r.nextInt(10);
                m = new Monster(types[theType], getCurrentFloor(), monsterScale);
                theMonsters.add(m);
            }
        }
        return theMonsters;
    }

    /**
     * the populateDungeon method uses the player object, items list, and monsters list to
     * randomly assign the objects to rooms in the dungeon. The player will always enter a
     * new floor in the middle of the dungeon. The exit will also be placed randomly, and
     * the method accounts for player position so that there will not be a monster at the
     * entry room and that room will also never be the exit.
     * @param items the linked list of items passed in.
     * @param monsters the linked list of monsters passed in.
     */

    public void populateDungeon(Player p, ChristianHolder<Item> items, ChristianHolder<Monster> monsters) {
        //calculate the middle room of the dungeon
        int playerEntry = getDungeonRooms().getSize() / 2;
        //place the player object into the middle of the dungeon
        getDungeonRooms().findPosition(playerEntry).getE().setThePlayer(p);
        //make variable for upper bound of random int generation for exit
        int bound = getDungeonRooms().getSize() + 1;
        //make a random room the exit
        Random r = new Random();
        int exitPos = r.nextInt(0, bound);
        /* the exit should not be at the player's starting position, and should be at least
         * two rooms away in either direction as long as size allows. */
        while(exitPos == playerEntry || exitPos == playerEntry + 1 || exitPos == playerEntry - 1){
            exitPos = r.nextInt(0, bound);
        }
        //set the exit
        getDungeonRooms().findPosition(exitPos).getE().setTheExit(true);
        //variable for room number to set objects in
        int objectPos;
        //variable for room
        Room temp;
        //array holds room numbers to exclude from random generation after they are used
        int[] roomNumbers = new int[monsters.getSize()];
        //for loop places monsters in rooms
        for(int i = 0; i < monsters.getSize(); i++){
            objectPos = r.nextInt(0, bound);
            //put this generated position in the array
            roomNumbers[i] = objectPos;
            /* during each add step check to make sure this room's enemy
             * object has not already been populated */
            for (int roomNumber : roomNumbers) {
                //if it was already, generate a new random object position number
                if (roomNumber == objectPos) {
                    objectPos = r.nextInt(0, bound);
                }
            }
            //generate temp node to check if it is this floor's entrance
            temp = getDungeonRooms().findPosition(objectPos).getE();
            //do not place a monster in the floor's entrance room
            if(temp.getThePlayer() == null){
                //populate the enemy object in this room
                getDungeonRooms().findPosition(objectPos).getE().setEnemy(monsters.removeEnd().getE());
            }
        }
        roomNumbers = new int[items.getSize()];
        for(int i = 0; i < items.getSize(); i++){
            roomNumbers[i] = i;
        }
        //for loop places items in rooms
        //items are fine to put at the start.
        for(int i = 0; i < items.getSize(); i++){
            objectPos = r.nextInt(0, bound);
            //put this generated position in the array
            roomNumbers[i] = objectPos;
            /* during each add step check to make sure this room's reward
             * object has not already been populated */
            for (int roomNumber : roomNumbers) {
                //if it was already, generate a new random object position number
                if (roomNumber == objectPos) {
                    objectPos = r.nextInt(0, bound);
                }
            }
            //populate the reward object in this room
            getDungeonRooms().findPosition(objectPos).getE().setTreasure(items.removeEnd().getE());
        }
    }

    /**
     * progressNextLevel method creates a new dungeon object when the player finds the exit,
     * and populates the new dungeon "level" with the player, enemies, items, etc.
     */
    public void progressNextLevel() {
        //if the player finds the room which is the exit,
        //ask the user if they want to exit or not
        //if not they can continue on this floor
        //return to dungeon menu
        //if yes, exit this floor
        //increment floors cleared
        //print the kill count, items collected and floors cleared
        //if new floor is < 99
        //print continueScript
                    /* create a new dungeon using player level and floor number
                    as the multiplier for rooms, monsters, and items */
        //set the dungeon object variable to the new dungeon
        //return to dungeon menu
        //else if new floor == 99
        //create a floor with one room
        //no monsters, "item" is a tome with cheat codes in it
        //export this as a file so the user can look at it
        //print victory script and end game
    }

    /**
     * The dungeonMenu method will control the player actions when outside
     * of battle. Uses the player input passed to a switch statement
     * to either move left, right, check status, check inventory, or input cheats
     * (secret 5th option). The program uses this method to access the objects and
     * variables of the current Room object.
     */
    public void dungeonMenu(Player p){
        //move left or right
        //check map
        //open inventory
        //check status
        //input cheats
        //or quit
    }

    //getters, setters, and global variables

    private ChristianHolder<Room> dungeonRooms;

    private ChristianHolder<Item> treasures;

    private ChristianHolder<Monster> monsters;

    private int currentFloor;

    public ChristianHolder<Room> getDungeonRooms() {
        return dungeonRooms;
    }

    public void setDungeonRooms(ChristianHolder<Room> dungeonRooms) {
        this.dungeonRooms = dungeonRooms;
    }

    public ChristianHolder<Item> getTreasures() {
        return treasures;
    }

    public void setTreasures(ChristianHolder<Item> treasures) {
        this.treasures = treasures;
    }

    public ChristianHolder<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ChristianHolder<Monster> monsters) {
        this.monsters = monsters;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

}
