package DungeonProject;

import ManualLinkedList.ChristianHolder;

import java.io.File;

public interface GameInterface {

    //run the game
    void run();

    //prints the introduction script
    void introScript();

    //prints the script when a player continues after a game over
    void continueScript();

    //prints the end of game script
    void endGameScript();

    //prints the script when you clear the final floor
    void victoryScript();

    //method to be called by newGame, continueGame, or continueSavedGame
    void createGame();

    //create the objects needed and start a new game
    void newGame();

    //create a new dungeon when the player continues after dying
    void continueGame();

    //continue a game from a save file
    void continueFromSave(File afile);

    //generate rooms for a floor of the dungeon based on floor number
    ChristianHolder<Room> generateRooms();

    //generate items for a floor of the dungeon based on floor number
    ChristianHolder<Item> generateItems();

    //generate monsters for a floor of the dungeon based on floor number and player level
    ChristianHolder<Monster> generateMonsters();

    //populate the rooms of the dungeon with the items, monsters, and make one the exit
    void populateDungeon(ChristianHolder<Item> items, ChristianHolder<Monster> monsters);

    //menu that controls the game outside of gameplay
    //can begin new game, continue, select options, or view the manual
    void mainMenu();

    //control the game when not in battle
    /* move between rooms, check current room, check status, check
       inventory -> use items or change equipment, check the map, or quit */
    void dungeonMenu();

    //battle a monster
    void battle(Player p, Monster m);

    //control the game when in battle
    //attack, defend, use item, or run
    void battleMenu(Player p, Monster m);

    //control the inventory
    //player can print inventory by item type, use items, and drop items.
    void inventoryMenu(Player p, ChristianHolder<Item> anInventory);

    //when the player finds the exit, move to the next level
    void progressNextLevel();

    //end the game when the player dies or quits
    void endGame();

}
