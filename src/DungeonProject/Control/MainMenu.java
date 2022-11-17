package DungeonProject.Control;

import DungeonProject.Model.MenuInputException;
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
        int choice;
        try{
            choice = (in.nextInt());
            if(choice <= 0 || choice > 3 ){
                throw new MenuInputException();
            }
        }catch(MenuInputException invalidInput){
            System.out.println("Choose New Game (1), Continue (2), or Load (3).");
            choice = (in.nextInt());
        }
        return choice;
    }
    public MainMenu() {}
}
