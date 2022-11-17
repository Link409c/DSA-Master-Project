package DungeonProject.Model;

import java.io.File;

public interface GameInterface {

    //run the game
    void play();

    //create the objects needed and start a new game
    void newGame();

    //create a new dungeon when the player continues after dying
    void continueGame();

    //continue a game from a save file
    void continueFromSave(File afile);

    //end the game when the player dies or quits
    void endGame(Player p);
}
