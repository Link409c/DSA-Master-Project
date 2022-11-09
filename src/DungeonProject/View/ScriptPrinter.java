package DungeonProject.View;

import java.util.Random;

import DungeonProject.Model.Player;

/**
 * A ScriptPrinter is an object that holds some amount of text to be printed in different
 * parts of the game. Includes the game introduction, messages that print between
 * floors, the end game messages, and the victory message.
 */
public class ScriptPrinter{

    /**
     * introScript method holds the introduction for the game and prints it
     * when the new game method is called.
     */
    public void printIntroScript(){
        System.out.println("Welcome to Christian's Dungeon Crawler.");
        System.out.println("This is a dungeon exploration game, where the player");
        System.out.println("will challenge the monsters within, floor by floor, and");
        System.out.println("see just how deep their skills can take them. Can you");
        System.out.println("reach the darkest depths and live to tell the tale?");
        System.out.println("Adventure Awaits...");
    }

    /**
     * continueScript method holds a variety of scripts to print randomly when
     * a player continues the game after a game over occurs, or when they progress
     * to a new floor of the dungeon.
     */
    public void printContinueScript(){
        //generate a random number
        Random r = new Random();
        int getScript = r.nextInt(1, 6);
        switch(getScript){
            case 1 ->{
                System.out.println("Maybe this time, you'll get lucky.");
            }
            case 2 ->{
                System.out.println("They say if you're encountering enemies, " +
                        "you're headed in the right direction.");
            }
            case 3 ->{
                System.out.println("I hope there's still some floor chicken.");
            }
            case 4 ->{
                System.out.println("If you're having trouble with the skeletons, " +
                        "try asking them what their favorite snack is.");
            }
            case 5 ->{
                System.out.println("Call the Nintendo Power Hotline for live gaming tips at " +
                        "425-885-7529! ($1.49 per minute)");
            }
            case 6 ->{
                System.out.println("Aren't there any cheats for this game?");
            }
        }
    }

    /**
     * loadGameScript prints a short script confirming the selection and welcoming the player
     * back to the game.
     * @param p
     */
    public void printLoadGameScript(Player p){
        System.out.println("Resuming your saved game.");
        System.out.println("Welcome back, " + p.getName() + ".");
    }

    /**
     * endGameScript method holds a script enticing the player to keep playing. it
     * prints the script based on the floor the player has reached at the end of a
     * game when called.
     */

    public void printEndGameScript(int currentFloor) {
        if(currentFloor < 10){
            System.out.println("The depth you've achieved is but the surface of this " +
                    "deep and twisting labyrinth.");
        }
        else if(currentFloor >= 11 && currentFloor < 30){
            System.out.println("You fought well, and delved far. But much lies " +
                    "deeper within the dungeon.");
        }
        else if(currentFloor >= 31 && currentFloor < 50){
            System.out.println("Your skills have brought you far, your strength led you " +
                    "to victory against many enemies, and your sense of adventure uncovered "
                    + "much. However, still more awaits.");
        }
        else if(currentFloor >= 51 && currentFloor < 90){
            System.out.println("There is little more to say of your success! A great adventurer " +
                    "such as you has what it takes to reach what lies at the very core of these "
                    + "catacombs. Soon, it will be within your reach...");
        }
        else if(currentFloor >= 91 && currentFloor <= 98){
            System.out.println("You're nearly there! The nadir of this labyrinth is just below.");
        }
    }

    /**
     * victoryScript method holds a script that is printed when the player clears the
     * final floor of the dungeon.
     */

    public void printVictoryScript() {
        //code
    }
    
    public void print(){
    	
    }
}
