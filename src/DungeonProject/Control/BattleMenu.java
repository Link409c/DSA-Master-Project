package DungeonProject.Control;

import DungeonProject.Model.Monster;
import DungeonProject.Model.Player;
import DungeonProject.View.MenuPrinter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleMenu implements MenuInterface{

    /**
     * accessMenu method will control the player actions when in battle. Uses player
     * input passed to a switch statement to either attack, defend, use items, or run away.
     * @param p the player object currently in the game.
     * @param m the monster object the player is battling.
     * @return returns true if the player takes an action (attack, defend, use an item, run).
     * returns false if they return to a previous menu, example: choose an option, and then
     * choose the "return" option afterward.
     */
    @Override
    public boolean accessMenu(Player p, Monster m){
        //print the battle menu
        MenuPrinter b = new MenuPrinter();
        b.printBattleMenu();
        //prompt the player for input
        Scanner in = new Scanner(System.in);
        //variable for input
        int choice;
        try{
            choice = (in.nextInt());
        }catch(InputMismatchException notANumber){
            System.out.println("Input a number, 1 through 4.");
            choice = (in.nextInt());
        }
        boolean act = false;
        //player action according to input
        switch(choice){
            case 1 -> {
                p.attack(m);
                act = true;
            }
            case 2 -> {
                p.defend();
                act = true;
            }
            case 3 -> {
                InventoryMenu inv = new InventoryMenu();
                act = inv.accessMenu(p);
            }
            case 4 -> {
                p.runAway();
                act = true;
            }
        }
        return act;
    }
}
