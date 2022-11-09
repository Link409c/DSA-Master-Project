package DungeonProject.View;

import DungeonProject.Model.Item;
import ManualLinkedList.ChristianHolder;

/**
 * Inventory Printer displays the player inventory and the player equipment.
 */
public class InventoryPrinter {
	
	/**
     * printItems prints all the items in a given inventory.
     * @param anInventory the inventory to be printed.
     */
    public void printItems(ChristianHolder<Item> anInventory) {
    	Item item = (Item) anInventory.getHead().getE();
    	for(int i = 0; i < anInventory.getSize(); i++) {
    		System.out.println(item.getName());
    	}
    }
    
    public InventoryPrinter() {
    	
    }
}
