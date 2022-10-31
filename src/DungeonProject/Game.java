package DungeonProject;

import ManualLinkedList.ChristianHolder;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game implements GameInterface{

    //dungeon object is a linked list of Rooms
    private ChristianHolder<Room> dungeon;

    //player object
    private Player thePlayer;

    //linked list of monster objects to populate dungeon rooms
    private ChristianHolder<Monster> dungeonMonsters;

    //linked list of items
    private ChristianHolder<Item> dungeonItems;

    //game over flag
    private boolean gameOver;

    //getters and setters

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ChristianHolder<Room> getDungeon() {
        return dungeon;
    }

    public Game(){

    }

    public Game(ChristianHolder<Room> dungeon, Player thePlayer, ChristianHolder<Monster> dungeonMonsters,
                ChristianHolder<Item> dungeonItems, boolean gameOver) {
        this.dungeon = dungeon;
        this.thePlayer = thePlayer;
        this.dungeonMonsters = dungeonMonsters;
        this.dungeonItems = dungeonItems;
        this.gameOver = gameOver;
    }

    public void setDungeon(ChristianHolder<Room> dungeon) {
        this.dungeon = dungeon;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public ChristianHolder<Monster> getDungeonMonsters() {
        return dungeonMonsters;
    }

    public void setDungeonMonsters(ChristianHolder<Monster> dungeonMonsters) {
        this.dungeonMonsters = dungeonMonsters;
    }

    public ChristianHolder<Item> getDungeonItems() {
        return dungeonItems;
    }

    public void setDungeonItems(ChristianHolder<Item> dungeonItems) {
        this.dungeonItems = dungeonItems;
    }

    /**
     * Run is a container method for calling all the game methods and
     * in essence, "running" the game.
     */
    public void run(){
        startGame();
    }

    /**
     * startGame method will construct the player object, construct the dungeon object,
     * construct the Monsters List, and construct the Item List. It will populate the
     * starting room with the player object, randomly populate the rooms of the dungeon
     * with items and monsters, and assign one room as the exit. Finally, it will call the
     * dungeonMenu method in order to allow the player to start playing.
     */
    public void startGame(){
        System.out.println("Welcome to Christian's Dungeon Crawler.");
        System.out.println("To begin, let's create your character.");
        System.out.println("Enter your name: ");
        //construct the player object with user input
        Scanner in = new Scanner(System.in);
        String yourName = in.nextLine();
        setThePlayer(new Player(yourName));
        System.out.println("Entering the Dungeon...");
    }

    /**
     * The dungeonMenu method will control the player actions when outside
     * of battle. Uses the player input passed to a switch statement
     * to either move left, right, check status, check inventory, or input cheats
     * (secret 5th option). The program uses this method to access the objects and
     * variables of the current Room object.
     */
    public void dungeonMenu(){
        while(!isGameOver()){

        }
    }

    /**
     * battle method is called whenever the player enters a room that contains an enemy.
     * The method will pass in the player and monster objects from the room, and call the
     * battleMenu method to accept player input. The user will battle with the monster
     * until one of their HP hits zero. Then, if the player wins, they will gain experience
     * and (if possible) an item dropped by the enemy.
     * @param p The player object.
     * @param m The monster the player will battle.
     */
    public void battle(Player p, Monster m){
        System.out.println("Battle! You encounter a " + m.getName()  + ".");
        int playerActualDefense = p.getDefensePoints();
        int monsterActualDefense = m.getDefensePoints();
        while(!p.isDead() && !m.isDead()){
            if(p.getSpeed() > m.getSpeed()) {
                battleMenu(p, m);
                m.attack(p);
                //implement method in monster class for rudimentary battle AI
                /*if(m.getCurrHealthPoints() <= m.getCurrHealthPoints()/3) {
                    if(p.getCurrHealthPoints() <= p.getCurrHealthPoints()/4 &&
                        m.getCurrHealthPoints() >= p.getCurrHealthPoints()){
                        m.attack(p);
                    }
                }else{
                    m.defend();
                }*/
            }else{
                m.attack(p);
                if(!p.isDead()){
                    battleMenu(p, m);
                }
            }
            if(p.getDefensePoints() != playerActualDefense){
                p.setDefensePoints(playerActualDefense);
            }
            if(m.getDefensePoints() != monsterActualDefense){
                m.setDefensePoints(monsterActualDefense);
            }
        }
        if(p.isDead()){
            endGame();
        }else if(m.isDead()){
            System.out.println("Victory! You defeated " + m.getName() + ".");
            p.setKillCount(p.getKillCount() + 1);
            System.out.println("You gain " + m.getExperience() + " experience.");
            p.setExperience(p.getExperience() + m.getExperience());
            p.checkLevelUp(p.getExperience());
            if(m.hasReward()){
                System.out.println("Got a " + m.getReward().getName() + ".");
                p.getInventory().add(m.getReward());
                p.setItemsAcquired(p.getItemsAcquired() + 1);
            }
        }
    }

    /**
     * battleMenu method will control the player actions when in battle. Uses player
     * input passed to a switch statement to either attack, defend, use items, or run away.
     * The player can also input cheats using switch case 69.
     */
    public void battleMenu(Player p, Monster m){
        //prompt the player for input
        Scanner in = new Scanner(System.in);
        System.out.println("What will you do?");
        System.out.println("1. Attack\n2. Defend\n3. Item\n4. Run");
        //variable for input
        int choice;
        try{
            choice = (in.nextInt());
        }catch(InputMismatchException notANumber){
            System.out.println("Input a number, 1 through 4.");
            choice = (in.nextInt());
        }
        //player action according to input
        switch(choice){
            case 1 -> {
                p.attack(m);
            }
            case 2 -> {
                p.defend();
            }
            case 3 -> {
                p.checkInventory();
            }
            case 4 -> {
                p.runAway();
            }
            case 69 -> {
                p.cheat();
            }
        }
    }

    /**
     * progressNextLevel method creates a new dungeon object when the player finds the exit,
     * and populates the new dungeon "level" with the player, enemies, items, etc.
     */
    public void progressNextLevel(){
        //if the player finds the room which is the exit,
            //ask the user if they want to exit or not
            //if not they can continue on this floor
                //return to dungeon menu
            //if yes, exit this floor
                //increment floors cleared
                //print the kill count, items collected and floors cleared
                /* create a new dungeon using player level and floor number
                as the multiplier for rooms, monsters, and items */
                //set the dungeon object variable to the new dungeon
                //return to dungeon menu
    }

    /**
     * endGame method ends the game when the player's HP reaches zero or the user quits,
     * printing the amount of floors the player has cleared, monsters killed, and items picked up.
     */
    public void endGame() {
        if(getThePlayer().isDead()){
            System.out.println("You died.");
            System.out.println("Enemies Killed: " + getThePlayer().getKillCount());
            System.out.println("Items collected: " + getThePlayer().getItemsAcquired());
            System.out.println("Floors Cleared: " + getThePlayer().getFloorsCleared());
        }else{
            System.out.println("You Quit.");
        }
        String quit;
        System.out.println("Continue Playing? Y/N: ");
        Scanner in = new Scanner(System.in);
        quit = in.nextLine();
        if(quit.equalsIgnoreCase("Y") || quit.equalsIgnoreCase("Yes")){
            setGameOver(true);
            System.exit(0);
        }else if(quit.equalsIgnoreCase("N") || quit.equalsIgnoreCase("No")){
            setGameOver(false);
        }
    }

}
