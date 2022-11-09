package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;

public class DungeonBuilder {
	/**
     * createDungeon method will construct the dungeon object, construct the Monsters List,
     * and construct the Item List. It will populate the starting room with the player
     * object, randomly populate the rooms of the dungeon with items and monsters, and
     * assign one room as the exit.
     */
	
    public Dungeon createDungeon(Player p){
        //create the dungeon
        Dungeon newDungeon = new Dungeon();
        //create dungeon rooms
        System.out.println("Constructing the Dungeon...");
        ChristianHolder<Room> rooms = newDungeon.generateRooms();
        newDungeon.setDungeonRooms(rooms);
        //randomly generate monsters to add to the dungeon
        System.out.println("Spawning a horde of terrible monsters...");
        newDungeon.generateMonsters(p);
        //randomly generate items to add to the dungeon
        System.out.println("...which guard untold treasure!");
        System.out.println("Creating items...");
        newDungeon.generateItems();
        //populate the dungeon with the created objects and player
        /* populate dungeon method has a pair of nested for loops to account for
         * errors in random number generation, so I thought it would be funny to put
         * a loading message here as it might take longer than expected for the
         * method to finish working. haha */
        System.out.println(".   .   .     . . .  ...Loading...  . . .     .   .   .");
        newDungeon.populateDungeon(p, newDungeon.getTreasures(), newDungeon.getMonsters());
        return newDungeon;
    }
    
    public DungeonBuilder() {
    	
    }
}
