package DungeonProject;

import ManualLinkedList.ChristianHolder;

public interface PlayerInterface {

    //check if the player levels up after battle
    void checkLevelUp(int exp);

    //add experience to the total and increase level.
    void levelUp(int exp);

    //use an item in the inventory.
    void useItem(ChristianHolder<Item> items, String aName, String mode);

}
