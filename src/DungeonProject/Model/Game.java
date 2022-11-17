package DungeonProject.Model;

import DungeonProject.Control.DungeonMenu;
import DungeonProject.Control.MainMenu;
import DungeonProject.View.DungeonMapPrinter;
import DungeonProject.View.ScriptPrinter;
import DungeonProject.View.WindowPrinter;

import java.io.File;
import java.util.Scanner;

public class Game implements GameInterface{

    /**
     * Play is a container method for starting the game.
     */
    //TODO test this
    public void play(){
    	MainMenu mainMenu = new MainMenu();
    	int option = mainMenu.accessMenu();
    	if(option == 1) {
    		newGame();
    	}
    	if(option == 2) {
    		continueGame();
    	}
    	if(option == 3) {
    		//continueFromSave();
    	}
        System.out.println("\nEntering the Dungeon...");
        DungeonMapPrinter p = new DungeonMapPrinter();
        p.mapInfoFormatter(getThePlayer(), getDungeon());
        p.printFloorMap();
        DungeonMenu d = new DungeonMenu();
        boolean action = false;
        while(!getThePlayer().isDead()) {
            while(!action) {
                //give player control
                Dungeon updatedD = d.accessMenu(getDungeon(), getThePlayer());
                if(!updatedD.equals(getDungeon())){
                    setDungeon(updatedD);
                    action = true;
                }
                //action is taken when player moves to a new room
            }
            RoomChecker checkCurrRoom = new RoomChecker();
            //get the room to check which should contain player
            Room curr = getDungeon().getDungeonRooms().findNodeAtPosition(getDungeon().getPlayerPosition()).getE();
            //check the room, which will trigger battle or item acquisition
            curr = checkCurrRoom.checkRoom(curr);
            //update player after winning battle or acquiring item
            setThePlayer(curr.getThePlayer());
            //continue until exit
            //when exit found, progress to next level
            if(curr.isTheExit()) {
                getThePlayer().setFloorsCleared(getThePlayer().getFloorsCleared()+1);
                DungeonLevelProgression dLP = new DungeonLevelProgression();
                setDungeon(dLP.progressNextLevel(getDungeon(), getThePlayer()));
            }
            else{
                //otherwise update the current room after battles / item acquisition
                getDungeon().getDungeonRooms().findNodeAtPosition(getDungeon().getPlayerPosition()).setE(curr);
            }
        }
        endGame(getThePlayer());
    }

    /**
     * newGame method begins a new Game, starting the player at level one. This method will be called
     * when 'New Game' is selected by the user at the main menu. The method prompts the user for their
     * character name, creates a new player object, sets the current floor to 1, and calls the createGame
     * method to construct the dungeon and begin gameplay.
     */
    @Override
    public void newGame(){
        //clear the player and dungeon object if any
        setThePlayer(null);
        //print the intro script
        ScriptPrinter newScript = new ScriptPrinter();
        newScript.printIntroScript();
        System.out.println("\nStarting a new game.");
        //prompt the player for name input
        Scanner in = new Scanner(System.in);
        String yourName;
        System.out.println("\nEnter your hero's name.\n16-Character Limit: ");
        try {
            yourName = in.nextLine();
        }catch(NameFormatException n){
            yourName = in.nextLine();
        }
        //create a new player object using the name
        //set it as the player
        setThePlayer(new Player(yourName));
        DungeonBuilder db = new DungeonBuilder();
        //call createDungeon method
        setDungeon(db.createNewDungeon(getThePlayer()));
    }

    /**
     * continueGame method is called when the player chooses to continue
     * after dying or quitting the game. It allows the player to continue
     * the game starting in a new dungeon, using their previously
     * attained level, stats, items, equipment, etc.
     */
    @Override
    public void continueGame() {
        if(getThePlayer() == null && getDungeon() == null){
            System.out.println("\nThere is no current game in progress.\nStart a new game, or " +
                    "load a save file.");
            MainMenu mainMenu = new MainMenu();
            mainMenu.accessMenu();
        }
        else {
            //clear the dungeon if any
            setDungeon(null);
            //print continue script
            ScriptPrinter continueScript = new ScriptPrinter();
            continueScript.printContinueScript();
            //using the existing player object, continue in a new dungeon
            DungeonBuilder db = new DungeonBuilder();
            //call createDungeon method
            setDungeon(db.createNewDungeon(getThePlayer()));
        }
    }

    /**
     * continueFromSave method uses information from a file passed in to the
     * method in order to construct a Game object, allowing the user to pick
     * up where they left off after a previous game was saved.
     * @param afile the file passed in to the method containing
     *              Game object data.
     */
    @Override
    public void continueFromSave(File afile) {
        //code
    }

    /**
     * endGame method ends the game when the player's HP reaches zero or the user quits. If the
     * player died, the amount of floors the player has cleared, monsters killed, and items picked up
     * are printed. If they quit, the results are not printed. It prompts the user to continue, with
     * the current player object being used to create a new randomized dungeon.
     */
    //TODO finish this method to control end game functions.
    public void endGame(Player p) {
        p.setGamesPlayed(p.getGamesPlayed() + 1);
        WindowPrinter endWindow = new WindowPrinter();
        if(p.isDead()) {
            endWindow.printDeathWindow();
            ScriptPrinter end = new ScriptPrinter();
            end.printEndGameScript(p, getDungeon().getCurrentFloor());
        }
        else{
            endWindow.printQuitWindow();
        }
    }

    private Dungeon dungeon;

    private Player thePlayer;

    public Game(){

    }

    public Game(Dungeon dungeon, Player thePlayer) {
        this.dungeon = dungeon;
        this.thePlayer = thePlayer;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

}
