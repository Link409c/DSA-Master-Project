package DungeonProject.Model;

import DungeonProject.Control.DungeonMenu;
import DungeonProject.View.MenuPrinter;
import DungeonProject.View.ScriptPrinter;
import ManualLinkedList.ChristianHolder;
import java.io.File;
import java.util.Scanner;

public class Game implements GameInterface{

    /**
     * Run is a container method for starting the game.
     */
    public void play(){
        System.out.println("Entering the Dungeon...");
        //call dungeon menu method to begin the game
        DungeonMenu d = new DungeonMenu();
        d.accessMenu();
    }

    /**
     * createDungeon method will construct the dungeon object, construct the Monsters List,
     * and construct the Item List. It will populate the starting room with the player
     * object, randomly populate the rooms of the dungeon with items and monsters, and
     * assign one room as the exit.
     */
    public void createDungeon(){
        //create the dungeon
        Dungeon newDungeon = new Dungeon();
        //create dungeon rooms
        System.out.println("Constructing the Dungeon...");
        ChristianHolder<Room> rooms = newDungeon.generateRooms();
        newDungeon.setDungeonRooms(rooms);
        //randomly generate monsters to add to the dungeon
        System.out.println("Spawning a horde of terrible monsters...");
        newDungeon.generateMonsters(getThePlayer());
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
        newDungeon.populateDungeon(getThePlayer(), getDungeon().getTreasures(), getDungeon().getMonsters());
    }

    /**
     * newGame method begins a new Game, starting the player at level one. This method will be called
     * when 'New Game' is selected by the user at the main menu. The method prompts the user for their
     * character name, creates a new player object, sets the current floor to 1, and calls the createGame
     * method to construct the dungeon and begin gameplay.
     */
    public void newGame(){
        //print the intro script
        ScriptPrinter newScript = new ScriptPrinter();
        newScript.printIntroScript();
        System.out.println("Starting a new game.");
        //prompt the player for name input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your hero's name: ");
        String yourName = in.nextLine();
        //create a new player object using the name
        //set it as the player
        setThePlayer(new Player(yourName));
        //call createDungeon method
        createDungeon();
    }

    /**
     * continueGame method is called when the player chooses to continue
     * after dying or quitting the game. It allows the player to continue
     * the game starting in a new dungeon, using their previously
     * attained level, stats, items, equipment, etc.
     */
    @Override
    public void continueGame() {
        if(getThePlayer() == null){
            System.out.println("There is no current game in progress.\nStart a new game, or " +
                    "load a save file.");
            mainMenu();
        }
        else {
            //print continue script
            ScriptPrinter continueScript = new ScriptPrinter();
            continueScript.printContinueScript();
            //using the existing player object, continue in a new dungeon
            createDungeon();
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
    public void endGame() {
        //change output based on how the method was called
        //player death prints results
        if(getThePlayer().isDead()){
            getThePlayer().setGamesPlayed(getThePlayer().getGamesPlayed() + 1);
            System.out.println("You died.");
            System.out.println("You've braved the dungeon " + getThePlayer().getGamesPlayed() + " times.");
            System.out.println("Enemies Killed: " + getThePlayer().getKillCount());
            System.out.println("Items collected: " + getThePlayer().getItemsAcquired());
            System.out.println("Floors Cleared: " + getThePlayer().getFloorsCleared());
        //quitting via the menu does not print results
        }else{
            System.out.println("You Quit.");
        }
        //prompt user to continue
        String quit;
        System.out.println("Continue Playing? Y/N: ");
        Scanner in = new Scanner(System.in);
        quit = in.nextLine();
        //if yes, call continue game method
        if(quit.equalsIgnoreCase("Y") || quit.equalsIgnoreCase("Yes")){
            continueGame();
        //if no, quit the game
        }else if(quit.equalsIgnoreCase("N") || quit.equalsIgnoreCase("No")){
            //print end game script
            ScriptPrinter end = new ScriptPrinter();
            end.printEndGameScript(getDungeon().getCurrentFloor());
            System.exit(0);
        }
    }

    //dungeon object
    private Dungeon dungeon;

    //player object
    private Player thePlayer;

    //getters and setters

    public Game(){

    }

    public Game(Dungeon dungeon, Player thePlayer, ChristianHolder<Monster> dungeonMonsters,
                ChristianHolder<Item> dungeonItems, int currentFloor) {
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
