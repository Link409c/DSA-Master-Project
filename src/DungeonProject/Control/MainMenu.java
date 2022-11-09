package DungeonProject.Control;

import DungeonProject.View.MenuPrinter;

import java.util.Scanner;

public class MainMenu{

    /**
     * accessMenu method controls the game outside of dungeon gameplay. the user can start a new game,
     * continue a game, or load from a save file.
     */
   
    public int accessMenu() {
        //print main menu
        MenuPrinter m = new MenuPrinter();
        m.printMainMenu();
        Scanner in = new Scanner(System.in);
        //new game, continue, or load
        //TODO needs trycatch for input
        int choice = in.nextInt();
        return choice;
    }
    public MainMenu() {}
}
