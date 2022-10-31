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

    //get the inventory
    //print the inventory
    //prompt if they want to use an item or return
    //call useItem method if needed
    void checkInventory();

    //get the inventory
    //search the inventory for the item
    //if it exists, remove the item and return the object
    Item useItem(ChristianHolder<Item> inventory, String itemName);

    //check to see if a weapon is equipped, and apply its effects if so
    boolean hasWeapon(Equipment[] e, int i);

    //check to see if armor is equipped, and apply its effects if so
    boolean hasArmor(Equipment[] e, int i);

    //check to see if an accessory is equipped, and apply its effects if so
    boolean hasAccessory(Equipment[] e, int i);

}
