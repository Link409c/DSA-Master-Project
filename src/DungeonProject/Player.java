package DungeonProject;

import ManualLinkedList.ChristianHolder;

public class Player extends Being implements PlayerInterface {

    private int experience;

    private int levelUpThreshold;

    private int killCount;

    private int floorsCleared;

    private int itemsAcquired;

    private Equipment[] equipped;

    private ChristianHolder<Item> inventory;

    private final int EQUIPMENTSLOTS = 3;

    //default constructor creates a level 1 default hero
    public Player(String name){

        setName(name);
        setLevel(1);
        setMaxHealthPoints(getLevel()*100);
        setCurrHealthPoints(getMaxHealthPoints());
        setAttackPoints(getLevel()*10);
        setDefensePoints(getLevel()*2);
        setSpeed(getLevel()*5);
        setExperience(0);
        setLevelUpThreshold(getLevel()*100);

        setKillCount(0);
        setFloorsCleared(0);
        setItemsAcquired(0);

        Equipment[] heroEquipment = new Equipment[EQUIPMENTSLOTS];
        Weapon woodenSword = new Weapon("Wooden Sword", "The most basic of Weapons.");
        heroEquipment[0] = woodenSword;
        setEquipped(heroEquipment);
    }

    public Player(String name, int healthPoints, int attackPoints, int defensePoints,
                  int speed, int level, int experience, int levelUpThreshold, int killCount, Equipment[] equipped,
                  ChristianHolder<Item> inventory) {

        super(name, healthPoints, attackPoints, defensePoints, speed, level);
        this.experience = experience;
        this.levelUpThreshold = levelUpThreshold;
        this.equipped = equipped;
        this.killCount = killCount;
        this.inventory = inventory;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience(){
        return experience;
    }

    public int getLevelUpThreshold() {
        return levelUpThreshold;
    }

    public void setLevelUpThreshold(int levelUpThreshold) {
        this.levelUpThreshold = levelUpThreshold;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getFloorsCleared() {
        return floorsCleared;
    }

    public void setFloorsCleared(int floorsCleared) {
        this.floorsCleared = floorsCleared;
    }

    public int getItemsAcquired() {
        return itemsAcquired;
    }

    public void setItemsAcquired(int itemsAcquired) {
        this.itemsAcquired = itemsAcquired;
    }

    public Equipment[] getEquipped() {
        return equipped;
    }

    public void setEquipped(Equipment[] equipped) {
        this.equipped = equipped;
    }

    public ChristianHolder<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ChristianHolder<Item> inventory) {
        this.inventory = inventory;
    }

    /**
     * checkLevelUp Method should run at the end of every enemy encounter.
     * Once the encounter ends, it checks the player experience against
     * the threshold, and if it meets or exceeds it, the player gains
     * a level.
     * @param experience The experience amount to be checked.
     */
    @Override
    public void checkLevelUp(int experience) {
        if (getLevel() < 99) {
            while (experience >= getLevelUpThreshold()) {
                levelUp(experience);
            }
        }
    }

    /**
     * levelUp method is called when experience threshold is reached by the
     * player. it increases the player stats based on their level and restores
     * the Player's HP to full.
     * @param experience the experience gained at the end of a battle.
     */
    @Override
    public void levelUp(int experience) {
        System.out.println("Level up! (" + getLevel() + " --> " + getLevel()+1 + ")");
        setExperience(experience - getLevelUpThreshold());
        setLevel(getLevel() + 1);
        setMaxHealthPoints(getLevel()*100);
        setCurrHealthPoints(getMaxHealthPoints());
        setAttackPoints(getLevel()*10);
        setDefensePoints(getLevel()*2);
        setSpeed(getLevel()*5);
        setLevelUpThreshold(getLevel()*100);
    }

    /**
     * runAway method is called when the user chooses option 4 in the battle menu.
     * it lets the Player escape from battle
     */
    public void runAway(){
        //
    }

    /**
     *
     */
    @Override
    public void cheat() {
        //cheat codes here
    }

    /**
     * checkInventory method gets the player inventory, and based on the player input, prints
     * those items out for the player.
     * @param inventory the player inventory.
     * @param itemType the type of item to print the inventory of.
     * @return Returns the inventory of the selected items.
     */
    @Override
    public ChristianHolder<Item> checkInventory(ChristianHolder<Item> inventory, ItemType itemType) {
        //make a new item list
        ChristianHolder<Item> newInventory = new ChristianHolder<>();
        int inventorySize = inventory.getSize();
        for(int i = 0; i < inventorySize; i++){
            Item temp = inventory.findPosition(i).getE();
            //populate it with item objects of the given type
            if(temp.getType() == itemType){
                newInventory.add(temp);
            }
        }
        //print the items of the selected type
        newInventory.printHolder();
        //return the section of the inventory to be used by other methods
        return newInventory;
    }

    /**
     * useItem is called when the user enters the input for the use item case in the inventory menu.
     * The method will search the inventory for an item, and when that item is found, the method returns that item.
     * the item's use method will be called. otherwise, the method returns null.
     * @param inventory the player inventory LL Object.
     * @param anItem the item to look for.
     * @return Returns an Item object.
     */
    @Override
    public Item useItem(ChristianHolder<Item> inventory, String anItem) {
        inventory.
        return inventory.findValue(anItem).getE();
    }

    @Override
    public void checkItem(ChristianHolder<Item> inventory, String anItem){
        Item toFind = inventory.findValue(anItem).getE();
        System.out.println(toFind.getDescription());
    }

    @Override
    public void dropItem(ChristianHolder<Item> inventory, String anItem){}


    /**
     * @param e
     * @param i
     * @return
     */
    @Override
    public boolean hasWeapon(Equipment[] e, int i) {
        return false;
    }

    /**
     * @param e
     * @param i
     * @return
     */
    @Override
    public boolean hasArmor(Equipment[] e, int i) {
        return false;
    }

    /**
     * @param e
     * @param i
     * @return
     */
    @Override
    public boolean hasAccessory(Equipment[] e, int i) {
        return false;
    }
}