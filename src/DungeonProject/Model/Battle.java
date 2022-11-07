package DungeonProject.Model;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A Battle object is created whenever the player enters a room containing an enemy.
 */
public class Battle {

    /**
     * battle method is called whenever the player enters a room that contains an enemy.
     * The method will pass in the player and monster objects from the room, and call the
     * battleMenu method to accept player input. The user will battle with the monster
     * until one of their HP hits zero. Then, if the player wins, they will gain experience
     * and (if possible) an item dropped by the enemy.
     * @param p The player object.
     * @param m The monster the player will battle.
     */
    public void battle(Player p, Monster m){
        System.out.println("Battle! You encounter a " + m.getName()  + ".");
        //variables to hold defense stat
        int playerActualDefense = p.getDefensePoints();
        int monsterActualDefense = m.getDefensePoints();
        //while the player and monster are alive, battle
        //action flag to progress state of battle
        boolean action = false;
        while(!p.isDead() && !m.isDead()){
            //if player is faster they go first
            if(p.getSpeed() > m.getSpeed()) {
                while(!action) {
                    action = battleMenu(p, m);
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
            }else{
                m.attack(p);
                if(!p.isDead()){
                    while(!action) {
                        action = battleMenu(p, m);
                    }
                }
                //check defense after the turn ends
            }
            //reset defense if either being defended
            if(p.getDefensePoints() != playerActualDefense){
                p.setDefensePoints(playerActualDefense);
            }

            /* if(m.getDefensePoints() != monsterActualDefense){
             *   m.setDefensePoints(monsterActualDefense);
            }*/
        }
        //check if either being is dead
        if(p.isDead()){
            //end the game if player is dead
            endGame();
            //if monster is dead end the battle
        }else if(m.isDead()){
            //print the results of the battle
            //increase kill counts, experience, items etc. and check level up
            System.out.println("Victory! You defeated " + m.getName() + ".");
            p.setKillCount(p.getKillCount() + 1);
            System.out.println("You gain " + m.getExperience() + " experience.");
            p.setExperience(p.getExperience() + m.getExperience());
            p.checkLevelUp(p.getExperience());
            if(m.hasReward()){
                System.out.println("Got a " + m.getReward().getName() + ".");
                p.getInventory().getItems().add(m.getReward());
                p.setItemsAcquired(p.getItemsAcquired() + 1);
            }
        }
    }

    /**
     * battleMenu method will control the player actions when in battle. Uses player
     * input passed to a switch statement to either attack, defend, use items, or run away.
     * @param p the player object currently in the game.
     * @param m the monster object the player is battling.
     * @Return returns true if the player takes an action (attack, defend, use an item, run).
     * returns false if they return to a previous menu, example: choose an option, and then
     * choose the "return" option afterward.
     */
    public boolean battleMenu(Player p, Monster m){
        //prompt the player for input
        Scanner in = new Scanner(System.in);
        System.out.println("What will you do?");
        System.out.println("1. Attack\n2. Defend\n3. Item\n4. Run");
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
                act = p.getInventory().inventoryMenu(p);
            }
            case 4 -> {
                p.runAway();
                act = true;
            }

        }
        return act;
    }

    //global variables
    private Player thePlayer;

    private Monster theMonster;

    public Battle(Player thePlayer, Monster theMonster){
        this.thePlayer = thePlayer;
        this.theMonster = theMonster;
    }


}

