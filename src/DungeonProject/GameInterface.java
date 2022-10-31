package DungeonProject;

import ManualLinkedList.ChristianHolder;

public interface GameInterface {

    //run the game
    void run();

    //create the objects needed and start the gameplay
    void startGame();

    //control the game when not in battle
    /* move between rooms, check current room, check status, check
       inventory -> use items or change equipment, check the map, or quit */
    void dungeonMenu();

    //battle a monster
    void battle(Player p, Monster m);

    //control the game when in battle
    //attack, defend, use item, or run
    void battleMenu(Player p, Monster m);

    //when the player finds the exit, move to the next level
    void progressNextLevel();

    //end the game when the player dies or quits
    void endGame();

}
