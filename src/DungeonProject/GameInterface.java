package DungeonProject;

import ManualLinkedList.ChristianHolder;

import java.io.File;

public interface GameInterface {

    //run the game
    void play();

    //method to be called by newGame, continueGame, or continueSavedGame
    void createDungeon();

    //create the objects needed and start a new game
    void newGame();

    //create a new dungeon when the player continues after dying
    void continueGame();

    //continue a game from a save file
    void continueFromSave(File afile);

    //menu that controls the game outside of gameplay
    //can begin new game, continue, select options, or view the manual
    void mainMenu();

    //end the game when the player dies or quits
    void endGame();
}
