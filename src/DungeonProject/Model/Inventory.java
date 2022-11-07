package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The inventory object holds the player's items.
 */
public class Inventory {
    /**
     * inventoryMenu method will control the player's inventory in the game. Player will be
     * prompted for input, and can view the inventory, check item descriptions, use and drop
     * Items, and return to the previous menu.
     * @param p the player object currently in the game.
     */

    public boolean inventoryMenu(Player p) {
        boolean act = false, end = false;
        while (!end) {
            System.out.println("|-------- INVENTORY --------|");
            //print the inventory menu.
            //prompt player for input of what items they want to see, or to return.
            System.out.println("Choose an item type, or return.");
            System.out.println("1. Usable items\n2. Equipment\n3. Key Items\n4. Return");
            Scanner in = new Scanner(System.in);
            //usable items, equipment, or key items.
            int choice;
            try {
                choice = in.nextInt();
            } catch (InputMismatchException notANumber) {
                System.out.println("Input a number, 1 through 4.");
                choice = in.nextInt();
            }
            ChristianHolder<Item> subInventory;
            String itemName;
            //player action according to input
            
            while(!act){
                switch (choice) {
                    case 1 -> {
                        System.out.println("|---------- ITEMS ----------|");
                        subInventory = checkInventory(ItemType.USABLE);
                        System.out.println("1. Use\n2. Check\n3. Drop\n4. Return");
                        choice = in.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.println("Enter the item name to use: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "use");
                                act = true;
                            }
                            case 2 -> {
                                System.out.println("Enter the item name to check: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "description");
                            }
                            case 3 -> {
                                System.out.println("Enter the item name to drop: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "drop");
                            }
                            case 4 -> {
                                end = true;
                            }
                        }

                    }
                    case 2 -> {
                        System.out.println("|-------- EQUIPMENT --------|");
                        subInventory = checkInventory(ItemType.EQUIPMENT);
                        System.out.println("1. Equip\n2. Check\n3. Drop\n4. Return");
                        choice = in.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.println("Enter the item name to equip: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "equip");
                            }
                            case 2 -> {
                                System.out.println("Enter the item name to check: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "description");
                            }
                            case 3 -> {
                                System.out.println("Enter the item name to drop: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "drop");
                            }
                            case 4 -> {
                                end = true;
                            }
                        }

                    }
                    case 3 -> {
                        System.out.println("|-------- KEY ITEMS --------|");
                        subInventory = checkInventory(ItemType.KEY);
                        System.out.println("1. Use\n2. Check\n3. Drop\n4. Return");
                        choice = in.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.println("Enter the item name to use: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "use");
                            }
                            case 2 -> {
                                System.out.println("Enter the item name to check: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "description");
                            }
                            case 3 -> {
                                System.out.println("Enter the item name to drop: ");
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "drop");
                            }
                            case 4 -> {
                                end = true;
                            }
                        }
                    }
                    case 4 -> {
                        end = true;
                    }
                }
            }
        }
        return act;
    }


    /**
     * checkInventory method gets the player inventory, and based on the player input, prints
     * items of the given type out for the player.
     * @param itemType  the type of item to print the inventory of.
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
}