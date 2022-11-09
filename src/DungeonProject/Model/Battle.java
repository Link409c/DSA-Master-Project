package DungeonProject.Model;

import DungeonProject.Control.BattleMenu;
import DungeonProject.View.MenuPrinter;
import DungeonProject.View.WindowPrinter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A Battle object is created whenever the player enters a room containing an enemy.
 */
public class Battle {

    /**
     * runBattle method is responsible for operations of the battle object. The method will
     * pass in the player and monster objects from the room, and call the battleMenu method to
     * accept player input. The user will battle with the monster until one of their HP hits zero.
     * Then, if the player wins, they will gain experience and (if possible) an item dropped by the enemy.
     *
     * @param p The player object.
     * @param m The monster the player will battle.
     * @return returns true if the player wins; false if not.
     */
    public boolean runBattle(Player p, Monster m) {
        System.out.println("Battle! You encounter a " + m.getName() + ".");
        WindowPrinter w = new WindowPrinter();
        //variables to hold defense stat
        int playerActualDefense = p.getDefensePoints();
        int monsterActualDefense = m.getDefensePoints();
        //while the player and monster are alive, battle
        //action flag to progress state of battle
        boolean action = false, playerWon = false;
        BattleMenu battleMenu = new BattleMenu();
        while (!p.isDead() && !m.isDead()) {
            //print the battle window
            w.printBattleWindow(p, m);
            //if player is faster they go first
            if (p.getSpeed() > m.getSpeed()) {
                while (!action) {
                    action = battleMenu.accessMenu(p, m);
                }
                m.attack(p);

                //implement method in monster class for rudimentary battle AI
                /* if(m.getCurrHealthPoints() <= m.getCurrHealthPoints()/3) {
                    if(p.getCurrHealthPoints() <= p.getCurrHealthPoints()/4 &&
                       m.getCurrHealthPoints() >= p.getCurrHealthPoints()){
                       m.attack(p);
                    }
                }else{
                    m.defend();
                }*/

                //otherwise the monster attacks first
            } else {
                m.attack(p);
                if (!p.isDead()) {
                    while (!action) {
                        action = battleMenu.accessMenu(p, m);
                    }
                }
            }
        }
        //reset defense if either being defended
        if (p.getDefensePoints() != playerActualDefense) {
            p.setDefensePoints(playerActualDefense);
        }

        /* if(m.getDefensePoints() != monsterActualDefense){
                m.setDefensePoints(monsterActualDefense);
           }*/

        //check if either being is dead
        if (p.isDead()) {
            //end the game if player is dead
            playerWon = false;
            //if monster is dead end the battle
        } else if (m.isDead()) {
            playerWon = true;
        }
        //return value used for battle reward call
        return playerWon;
    }

    public Battle(){

    }
}