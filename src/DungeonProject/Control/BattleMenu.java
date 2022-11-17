package DungeonProject.Control;

import DungeonProject.Model.MenuInputException;
import DungeonProject.Model.Monster;
import DungeonProject.Model.Player;
import DungeonProject.Model.Room;
import DungeonProject.View.MenuPrinter;

import java.util.Scanner;

public class BattleMenu{

    /**
     * accessMenu method will control the player actions when in battle. Uses player
     * input passed to a switch statement to either attack, defend, use items, or run away.
     * @param r the room object.
     * @return returns the updated room object.
     */
    
    public Room accessMenu(Room r){
        Player p = r.getThePlayer();
        Monster m = r.getEnemy();
        //print the battle menu
        MenuPrinter b = new MenuPrinter();
        b.printBattleMenu();
        //prompt the player for input
        Scanner in = new Scanner(System.in);
        //variable for input
        int choice;
        try{
            choice = (in.nextInt());
            if(choice <= 0 || choice > 4 ){
                throw new MenuInputException();
            }
        }catch(MenuInputException invalidInput){
            System.out.println("Choose Attack (1), Defend (2), Items (3), or Run (4).");
            choice = (in.nextInt());
        }
        //player action according to input
        boolean act = false;
        while(!act) {
            switch (choice) {
                case 1 -> {
                    m.setCurrHealthPoints(m.getCurrHealthPoints() - p.attack(m));
                    act = true;
                }
                case 2 -> {
                    p.defend();
                    act = true;
                }
                case 3 -> {
                    InventoryMenu inv = new InventoryMenu();
                    Player newP = inv.accessMenu(p);
                    //action is taken if a healing item is used
                    if(newP.getCurrHealthPoints() != p.getCurrHealthPoints()){
                        act = true;
                    }
                    p = newP;
                }
                case 4 -> {
                    act = true;
                    p.runAway();
                }
            }
        }
        r.setThePlayer(p);
        r.setEnemy(m);
        return r;
    }
    
    public BattleMenu() {
    	
    }
}
