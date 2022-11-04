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

    //the current floor the player is on
    private int currentFloor;

    //getters and setters

    public Game(){

    }

    public Game(ChristianHolder<Room> dungeon, Player thePlayer, ChristianHolder<Monster> dungeonMonsters,
                ChristianHolder<Item> dungeonItems, int currentFloor) {
        this.dungeon = dungeon;
        this.thePlayer = thePlayer;
        this.dungeonMonsters = dungeonMonsters;
        this.dungeonItems = dungeonItems;
        this.currentFloor = currentFloor;
    }
    public ChristianHolder<Room> getDungeon() {
        return dungeon;
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

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
    }


    /**
     * Run is a container method for starting the game. It calls the main menu method
     * in order for the user to begin playing.
     */
    public void run(){
        mainMenu();
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
     * continueScript method holds a variety of scripts to print randomly when
     * a player continues the game after a game over occurs, or when they progress
     * to a new floor of the dungeon.
     */
    public void continueScript(){
        //generate a random number
        Random r = new Random();
        int getScript = r.nextInt(1, 6);
        switch(getScript){
            case 1 ->{
                System.out.println("Maybe this time, you'll get lucky.");
            }
            case 2 ->{
                System.out.println("They say if you're encountering enemies, " +
                        "you're headed in the right direction.");
            }
            case 3 ->{
                System.out.println("I hope there's still some floor chicken.");
            }
            case 4 ->{
                System.out.println("If you're having trouble with the skeletons, " +
                        "try asking them what their favorite snack is.");
            }
            case 5 ->{
                System.out.println("Call the Nintendo Power Hotline for live gaming tips at " +
                        "425-885-7529! ($1.49 per minute)");
            }
            case 6 ->{
                System.out.println("Aren't there any cheats for this game?");
            }
        }
    }

    /**
     * endGameScript method holds a script enticing the player to keep playing. it
     * prints the script based on the floor the player has reached at the end of a
     * game when called.
     */
    @Override
    public void endGameScript() {
        int aFloor = getCurrentFloor();
        if(aFloor < 10){
            System.out.println("The depth you've achieved is but the surface of this " +
                    "deep and twisting labyrinth.");
        }
        else if(aFloor >= 11 && aFloor < 30){
            System.out.println("You fought well, and delved far. But much lies " +
                            "deeper within the dungeon.");
        }
        else if(aFloor >= 31 && aFloor < 50){
            System.out.println("Your skills have brought you far, your strength led you " +
                    "to victory against many enemies, and your sense of adventure uncovered "
                     + "much. However, still more awaits.");
        }
        else if(aFloor >= 51 && aFloor < 90){
            System.out.println("There is little more to say of your success! A great adventurer " +
                    "such as you has what it takes to reach what lies at the very core of these "
                     + "catacombs. Soon, it will be within your reach...");
        }
        else if(aFloor >= 91 && aFloor <= 98){
            System.out.println("You're nearly there! The nadir of this labyrinth is just below.");
        }
    }

    /**
     * victoryScript method holds a script that is printed when the player clears the
     * final floor of the dungeon.
     */
    @Override
    public void victoryScript() {
        //code
    }


    /**
     * generateRooms method creates the room objects that comprise the dungeon.
     * it will use the current floor to determine the maximum number of rooms the
     * dungeon can have. the number of rooms will be randomized in order to create
     * a different experience each time the game is played.
     * @return returns a list of room objects.
     */
    @Override
    public ChristianHolder<Room> generateRooms() {
        //create list to return
        ChristianHolder<Room> theRooms = new ChristianHolder<>();
        //create variable for max rooms
        int maxRooms;
        //get current floor of the dungeon
        int aFloor = getCurrentFloor();
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
     * @return returns a list of items.
     */
    @Override
    public ChristianHolder<Item> generateItems() {
        //create list to return
        ChristianHolder<Item> anItems = new ChristianHolder<>();
        //get current floor of the dungeon
        int aFloor = getCurrentFloor();
        //get dungeon size
        int dungeonSize = getDungeon().getSize();
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
     * @return Returns a list of monsters.
     */
    @Override
    public ChristianHolder<Monster> generateMonsters() {
        //create list to return
        ChristianHolder<Monster> theMonsters = new ChristianHolder<>();
        //create variable for max monsters
        int maxMonsters;
        //get current floor of the dungeon
        int aFloor = getCurrentFloor();
        //get player level
        int playerLevel = getThePlayer().getLevel();
        //get dungeon size
        int dungeonSize = getDungeon().getSize();
        //to avoid an overabundance of monsters, limit the amount
        //we want to give the player a chance (until we don't)
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

    /**
     * the populateDungeon method uses the player object, items list, and monsters list to
     * randomly assign the objects to rooms in the dungeon. The player will always enter a
     * new floor in the middle of the dungeon. The exit will also be placed randomly, and
     * the method accounts for player position so that there will not be a monster at the
     * entry room and that room will also never be the exit.
     * @param items the linked list of items passed in.
     * @param monsters the linked list of monsters passed in.
     */
    @Override
    public void populateDungeon(ChristianHolder<Item> items, ChristianHolder<Monster> monsters) {
        //calculate the middle room of the dungeon
        int playerEntry = getDungeon().getSize() / 2;
        //place the player object into the middle of the dungeon
        getDungeon().findPosition(playerEntry).getE().setThePlayer(getThePlayer());
        //make variable for upper bound of random int generation for exit
        int bound = getDungeon().getSize() + 1;
        //make a random room the exit
        Random r = new Random();
        int exitPos = r.nextInt(0, bound);
        /* the exit should not be at the player's starting position, and should be at least
         * two rooms away in either direction as long as size allows. */
        while(exitPos == playerEntry || exitPos == playerEntry + 1 || exitPos == playerEntry - 1){
            exitPos = r.nextInt(0, bound);
        }
        //set the exit
        getDungeon().findPosition(exitPos).getE().setTheExit(true);
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
            temp = getDungeon().findPosition(objectPos).getE();
            //do not place a monster in the floor's entrance room
            if(temp.getThePlayer() == null){
                //populate the enemy object in this room
                getDungeon().findPosition(objectPos).getE().setEnemy(monsters.removeEnd().getE());
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
            getDungeon().findPosition(objectPos).getE().setTreasure(items.removeEnd().getE());
        }
    }

    /**
     * mainMenu method controls the game outside of gameplay. the user can start a new game,
     * continue from a save file, or change several options.
     */
    @Override
    public void mainMenu() {
        //code
    }

    /**
     * createGame method will construct the dungeon object, construct the Monsters List,
     * and construct the Item List. It will populate the starting room with the player
     * object, randomly populate the rooms of the dungeon with items and monsters, and
     * assign one room as the exit. Finally, it will call the dungeonMenu method in order
     * to allow the player to start playing.
     */
    public void createGame(){
        //create the dungeon
        System.out.println("Constructing the Dungeon...");
        ChristianHolder<Room> theDungeon = generateRooms();
        setDungeon(theDungeon);
        //randomly generate monsters to add to the dungeon
        System.out.println("Spawning a horde of terrible monsters...");
        ChristianHolder<Monster> theMonsters = generateMonsters();
        //set the global monster list
        setDungeonMonsters(theMonsters);
        //randomly generate items to add to the dungeon
        System.out.println("...which guard untold treasure!");
        System.out.println("Creating items...");
        ChristianHolder<Item> theItems = generateItems();
        //set the global item list
        setDungeonItems(theItems);
        //populate the dungeon with the created objects and player
        /* the populate dungeon method has a pair of nested for loops to account for
         * errors in random number generation, so I thought it would be funny to put
         * a loading message here as it might take longer than expected for the
         * method to finish working. haha */
        System.out.println(".   .   .     . . .  ...Loading...  . . .     .   .   .");
        populateDungeon(theItems, theMonsters);
        System.out.println("Entering the Dungeon...");
        //call dungeon menu method to begin the game
        dungeonMenu();
    }

    /**
     * newGame method begins a new Game, starting the player at level one. This method will be called
     * when 'New Game' is selected by the user at the main menu. The method prompts the user for their
     * character name, creates a new player object, sets the current floor to 1, and calls the createGame
     * method to construct the dungeon and begin gameplay.
     */
    public void newGame(){
        //print the intro script
        introScript();
        System.out.println("Starting a new game.");
        //prompt the player for name input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your hero's name: ");
        String yourName = in.nextLine();
        //create a new player object using the name
        //set it as the player
        setThePlayer(new Player(yourName));
        //set currentFloor to 1
        setCurrentFloor(1);
        //call createGame method
        createGame();
    }

    /**
     * continueGame method is called when the player chooses to continue
     * after dying or quitting the game. It allows the player to continue
     * the game starting in a new dungeon, using their previously
     * attained level, stats, items, equipment, etc.
     */
    @Override
    public void continueGame() {
        //print the continue script
        continueScript();
        //using the existing player object, continue in a new dungeon
        createGame();
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

            System.exit(0);
        }
    }
}
