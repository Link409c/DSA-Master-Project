package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The inventory object holds the player's items.
 */
public class Inventory {

    /**
     * checkInventory method gets the player inventory, and based on the player input, prints
     * items of the given type out for the player.
     * @param itemType the type of item to print the inventory of.
     * @return Returns the inventory of the selected items.
     */

    public ChristianHolder<Item> checkInventory(ItemType itemType) {
        //make a new item list
        ChristianHolder<Item> newInventory = new ChristianHolder<>();
        int inventorySize = getItems().getSize();
        for (int i = 0; i < inventorySize; i++) {
            Item temp = getItems().findPosition(i).getE();
            //populate it with item objects of the given type
            if (temp.getType() == itemType) {
                newInventory.add(temp);
            }
        }
        //print the items of the selected type
        newInventory.printHolder();
        //return the section of the inventory to be used by other methods
        return newInventory;
    }

    private ChristianHolder<Item> inventory;

    public ChristianHolder<Item> getItems() {
        return inventory;
    }

    public Inventory(ChristianHolder<Item> inventory) {
        this.inventory = inventory;
    }
}