package DungeonProject;

import ManualLinkedList.ChristianHolder;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Random;
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

    //getters and setters

    public Game(){

    }

    public Game(ChristianHolder<Room> dungeon, Player thePlayer, ChristianHolder<Monster> dungeonMonsters,
                ChristianHolder<Item> dungeonItems) {
        this.dungeon = dungeon;
        this.thePlayer = thePlayer;
        this.dungeonMonsters = dungeonMonsters;
        this.dungeonItems = dungeonItems;
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

    public ChristianHolder<Room> getDungeon() {
        return dungeon;
    }


    /**
     * Run is a container method for calling all the game methods and
     * in essence, "running" the game.
     */
    public void run(){
        //create the objects needed to play the game
        //newGame method creates player, monsters, items, and dungeon, starting a new game
        newGame();
        /* continueFromSave method uses the information saved in a file
         * to allow the player to progress from a save. */
        //continueFromSave();

    }

    /**
     * introScript method holds the introduction for the game and prints it
     * when the new game method is called.
     */
    public void introScript(){
        System.out.println("Welcome to Christian's Dungeon Crawler.");
        System.out.println("This is a dungeon exploration game, where the player");
        System.out.println("will challenge the monsters within, floor by floor, and");
        System.out.println("see just how deep their skills can take them. Can you");
        System.out.println("reach the darkest depths and live to tell the tale?");
        System.out.println("Adventure Awaits...");
    }

    /**
     * @param aFloor
     */
    @Override
    public void endGameScript(int aFloor) {

    }

    /**
     *
     */
    @Override
    public void victoryScript() {

    }


    /**
     * generateRooms method creates the room objects that comprise the dungeon.
     * it will use the current floor to determine the maximum number of rooms the
     * dungeon can have. the number of rooms will be randomized in order to create
     * a different experience each time the game is played.
     * @param aFloor the current floor of the dungeon.
     * @return returns a list of room objects.
     */
    @Override
    public ChristianHolder<Room> generateRooms(int aFloor) {
        //create list to return
        ChristianHolder<Room> theRooms = new ChristianHolder<>();
        //create variable for max rooms
        int maxRooms;
        //if first floor, make limit 10
        if(aFloor == 1){
            maxRooms = 10;
        }
        //beyond that, increase the rooms size by a maximum of 5 each floor
        else{
            maxRooms = 10 + (aFloor * 5);
        }
        //create random object to use for room number generation
        Random r = new Random();
        //we want minimum rooms to be half of max and max to be upper bound
        //randomize the number with a minimum and maximum
        int rooms = r.nextInt(maxRooms/2, maxRooms + 1);
        //use the room number to generate that many rooms
        for(int i = 0; i < rooms; i++) {
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
     * @param aFloor the current floor of the dungeon.
     * @param dungeonSize the number of rooms in the current floor.
     * @return returns a list of items.
     */
    @Override
    public ChristianHolder<Item> generateItems(int aFloor, int dungeonSize) {
        //create list to return
        ChristianHolder<Item> anItems = new ChristianHolder<>();
        //create variable for max items
        int maxItems;
        //to avoid an overabundance of items, limit the amount
        //quarter of size multiplied by floor number
        maxItems = (dungeonSize / 3) * aFloor;
        //generate random items with at least one of each type, limited by amount
        //usable items are always prioritized
        for(int i = 0; i < maxItems; i++){
            //code
        }
        return anItems;
    }

    /**
     * generateMonsters method creates the monster objects that will populate the dungeon's
     * Rooms. the method will create a number of monsters dependent on the current floor, the
     * player level, and the number of rooms, with a random amount generated not to exceed the
     * room count of the floor.
     * @param aFloor the current floor of the dungeon.
     * @param aLevel the current level of the player.
     * @param dungeonSize the number of rooms in the current floor.
     * @return Returns a list of monsters.
     */
    @Override
    public ChristianHolder<Monster> generateMonsters(int aFloor, int aLevel, int dungeonSize) {
        //create list to return
        ChristianHolder<Monster> theMonsters = new ChristianHolder<>();
        //create variable for max monsters
        int maxMonsters;
        //to avoid an overabundance of monsters, limit the amount
        //we want to give the player a chance
        //half of size multiplied by floor number
        maxMonsters = (dungeonSize / 2) * aFloor;
        //limit monster types by section (scarier monsters deeper in the dungeon)
        //with floor limit of 99, about a third of the way sounds good for all the monster types
        //treasure lizards can spawn on any floor but are rare
        //if floor < 10, slimes, bats, and skeletons can spawn
        //if floor >= 11 and < 20, goblins, lizardmen, and orcs can also spawn
        //if floor >= 21, minotaurs and dragons can also spawn
        //the smaller the room count the more difficult the monsters can be
        return theMonsters;
    }


    @Override
    public ChristianHolder<Room> populateDungeon(ChristianHolder<Item> items, ChristianHolder<Monster> monsters,
                                                 int dungeonSize) {
        //create the dungeon to return
        ChristianHolder<Room> populatedDungeon = new ChristianHolder<>();
        //place the player object into the middle of the dungeon
        //get the middle room of the list using for loop
        //make a random room the exit
        /* the exit should not be at the player's starting position,
         * and should be at least two rooms away in either direction */
        //while both lists head nodes are not null,
            //for loop places monsters in rooms
            //do not place a monster in the player's starting room
            //for loop places items in rooms
            //items are fine to put at the start.
        return populatedDungeon;
    }

    /**
     *
     */
    @Override
    public void mainMenu() {

    }

    /**
     * newGame method will construct the player object, construct the dungeon object,
     * construct the Monsters List, and construct the Item List. It will populate the
     * starting room with the player object, randomly populate the rooms of the dungeon
     * with items and monsters, and assign one room as the exit. Finally, it will call the
     * dungeonMenu method in order to allow the player to start playing.
     */
    public void newGame(){
        //introduction
        introScript();
        System.out.println("To begin, let's create your character.");
        System.out.println("Enter your name: ");
        //construct the player object with user input
        Scanner in = new Scanner(System.in);
        String yourName = in.nextLine();
        Player player = new Player(yourName);
        setThePlayer(player);
        //set current floor to 1 for new game
        int currentFloor = 1;
        //create the dungeon
        System.out.println("Constructing the Dungeon...");
        ChristianHolder<Room> theDungeon = generateRooms(currentFloor);
        //randomly generate monsters to add to the dungeon
        System.out.println("Spawning a horde of terrible monsters...");
        ChristianHolder<Monster> theMonsters = generateMonsters(currentFloor,
                getThePlayer().getLevel(), theDungeon.getSize());
        setDungeonMonsters(theMonsters);
        //randomly generate items to add to the dungeon
        System.out.println("...which guard untold treasure!");
        System.out.println("Creating items...");
        ChristianHolder<Item> theItems = generateItems(currentFloor, theDungeon.getSize());
        //populate the dungeon with the created objects and player
        populateDungeon(theItems, theMonsters, theDungeon.getSize());
        System.out.println("Entering the Dungeon...");
        //call dungeon menu method to begin the game
        dungeonMenu();
    }

    /**
     * @param thePlayer
     */
    @Override
    public void continueGame(Player thePlayer) {

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

    }

    /**
     * The dungeonMenu method will control the player actions when outside
     * of battle. Uses the player input passed to a switch statement
     * to either move left, right, check status, check inventory, or input cheats
     * (secret 5th option). The program uses this method to access the objects and
     * variables of the current Room object.
     */
    public void dungeonMenu(){
            //move left or right
            //check map
            //open inventory
            //check status
            //input cheats
            //or quit
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
        //variables to hold defense stat
        int playerActualDefense = p.getDefensePoints();
        int monsterActualDefense = m.getDefensePoints();
        //while the player and monster are alive, battle
        while(!p.isDead() && !m.isDead()){
            //if player is faster they go first
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

                //otherwise the monster attacks first
            }else{
                m.attack(p);
                if(!p.isDead()){
                    battleMenu(p, m);
                }
            //check defense after the turn ends
            }
            //reset defense if either being defended
            if(p.getDefensePoints() != playerActualDefense){
                p.setDefensePoints(playerActualDefense);
            }
            if(m.getDefensePoints() != monsterActualDefense){
                m.setDefensePoints(monsterActualDefense);
            }
        }
        //check if either being is dead
        if(p.isDead()){
            //end the game if player is dead
            endGame();
            //if monster is dead end the battle
        }else if(m.isDead()){
            //print the results of the battle
            //increase kill counts, experience, items etc. and check level up
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
     * @param p the player object currently in the game.
     * @param m the monster object the player is battling.
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
                inventoryMenu(p, p.getInventory());
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
     * inventoryMenu method will control the player's inventory in the game. Player will be
     * prompted for input, and can view the inventory, check item descriptions, use and drop
     * Items, and return to the previous menu.
     * @param p the player object currently in the game.
     * @param anInventory the inventory of the player.
     */
    public void inventoryMenu(Player p, ChristianHolder<Item> anInventory){
        System.out.println("|-------- INVENTORY --------|");
        //print the inventory menu.
        //prompt player for input of what items they want to see, or to return.
        System.out.println("Choose an item type, or return.");
        System.out.println("1. Usable items");
        System.out.println("2. Equipment");
        System.out.println("3. Key Items");
        System.out.println("4. Return");
        Scanner in = new Scanner(System.in);
        //usable items, equipment, or key items.
        int choice;
        try{
            choice = in.nextInt();
        }catch(InputMismatchException notANumber){
            System.out.println("Input a number, 1 through 4.");
            choice = in.nextInt();
        }
        ChristianHolder<Item> subInventory;
        //player action according to input
        switch(choice){
            case 1 -> {
                System.out.println("|---------- ITEMS ----------|");
                subInventory = p.checkInventory(anInventory, ItemType.USABLE);
                System.out.println("1. Use");
                System.out.println("2. Check");
                System.out.println("3. Drop");
                System.out.println("4. Return");
                String item;
                choice = in.nextInt();
                switch(choice){
                    case 1 -> {
                        System.out.println("Enter the item name to use: ");
                        item = in.nextLine();
                        Item toUse = p.useItem(subInventory, item);
                    }
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {}
                }

            }
            case 2 -> {
                System.out.println("|-------- EQUIPMENT --------|");
                subInventory = p.checkInventory(anInventory, ItemType.EQUIPMENT);
                System.out.println("1. Equip");
                System.out.println("2. Check");
                System.out.println("3. Drop");
                System.out.println("4. Return");
                choice = in.nextInt();
                switch(choice){
                    case 1 -> {}
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {}
                }

            }
            case 3 -> {
                System.out.println("|-------- KEY ITEMS --------|");
                subInventory = p.checkInventory(anInventory, ItemType.KEY);
                System.out.println("1. Use");
                System.out.println("2. Check");
                System.out.println("3. Drop");
                System.out.println("4. Return");
                choice = in.nextInt();
                switch(choice){
                    case 1 -> {}
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {}
                }
            }
            case 69 -> {
                p.cheat();
            }
            case 4 -> {

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
     * endGame method ends the game when the player's HP reaches zero or the user quits. If the
     * player died, the amount of floors the player has cleared, monsters killed, and items picked up
     * are printed. If they quit, the results are not printed. It prompts the user to continue, with
     * the current player object being used to create a new randomized dungeon.
     */
    public void endGame() {
        //change output based on how the method was called
        //player death prints results
        if(getThePlayer().isDead()){
            System.out.println("You died.");
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
            continueGame(getThePlayer());
        //if no, quit the game
        }else if(quit.equalsIgnoreCase("N") || quit.equalsIgnoreCase("No")){

            System.exit(0);
        }
    }
}
