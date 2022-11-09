package DungeonProject.Control;

import DungeonProject.Model.Inventory;
import DungeonProject.Model.Item;
import DungeonProject.Model.ItemType;
import DungeonProject.Model.Player;
import DungeonProject.View.MenuPrinter;
import ManualLinkedList.ChristianHolder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryMenu {

    /**
     * inventoryMenu method will control the player's inventory in the game. Player will be
     * prompted for input, and can view the inventory, check item descriptions, use and drop
     * Items, and return to the previous menu.
     * @param p the player object currently in the game.
     */
    public boolean accessMenu(Player p) {
        MenuPrinter m = new MenuPrinter();
        boolean act = false, end = false;
        while (!end) {
            m.printInventoryMenu();
            Scanner in = new Scanner(System.in);
            int choice;
            try {
                choice = in.nextInt();
            } catch (InputMismatchException notANumber) {
                System.out.println("Input a number, 1 through 4.");
                choice = in.nextInt();
            }
            Inventory currInventory = p.getInventory();
            ChristianHolder<Item> subInventory;
            String itemName;
            //player action according to input
            while(!act){
                switch (choice) {
                    case 1 -> {
                        subInventory = currInventory.subdivideInventory(ItemType.USABLE);
                        choice = in.nextInt();
                        switch (choice) {
                            case 1 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "use");
                                act = true;
                            }
                            case 2 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "description");
                            }
                            case 3 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "drop");
                            }
                            case 4 -> {
                                end = true;
                            }
                        }

                    }
                    case 2 -> {
                        subInventory = currInventory.subdivideInventory(ItemType.EQUIPMENT);
                        choice = in.nextInt();
                        switch (choice) {
                            case 1 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "equip");
                            }
                            case 2 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "description");
                            }
                            case 3 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "drop");
                            }
                            case 4 -> {
                                end = true;
                            }
                        }

                    }
                    case 3 -> {
                        subInventory = currInventory.subdivideInventory(ItemType.KEY);
                        choice = in.nextInt();
                        switch (choice) {
                            case 1 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "use");
                            }
                            case 2 -> {
                                itemName = in.nextLine();
                                p.useItem(subInventory, itemName, "description");
                            }
                            case 3 -> {
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

}
