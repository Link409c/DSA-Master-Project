package DungeonProject;

import ManualLinkedList.ChristianHolder;

public interface PlayerInterface {

    //check if the player levels up after battle
    void checkLevelUp(int exp);

    //add experience to the total and increase level.
    void levelUp(int exp);

    //run away from a battle.
    void runAway();

    //the player can enter a cheat.
    void cheat();

    //get the items of the passed item type
    //print the inventory
    //return the new inventory to be used in other methods
    ChristianHolder<Item> checkInventory(ChristianHolder<Item> inventory, ItemType itemType);

    //get the inventory
    //search the inventory for the item
    //if it exists, call the use method of that item
    Item useItem(ChristianHolder<Item> inventory, String anItem);

    //prints the details of an item.
    void checkItem(ChristianHolder<Item> inventory, String anItem);

    //removes an item object from the player inventory.
    public void dropItem(ChristianHolder<Item> inventory, String anItem);

    //check to see if a weapon is equipped, and apply its effects if so
    boolean hasWeapon(Equipment[] e, int i);

    //check to see if armor is equipped, and apply its effects if so
    boolean hasArmor(Equipment[] e, int i);

    //check to see if an accessory is equipped, and apply its effects if so
    boolean hasAccessory(Equipment[] e, int i);

}
