package DungeonProject.Control;

import DungeonProject.Model.MenuInputException;
import DungeonProject.View.MenuPrinter;

import java.util.Scanner;

public class EndGameMenu {

    public void accessMenu(){
        MenuPrinter endMenu = new MenuPrinter();
        endMenu.printEndGameMenu();
        Scanner in = new Scanner(System.in);
        int choice;
        try{
            choice = (in.nextInt());
            if(choice <= 0 || choice > 2 ){
                throw new MenuInputException();
            }
        }catch(MenuInputException invalidInput){
            System.out.println("Choose Continue (1) or Quit (2).");
            choice = (in.nextInt());
        }
        switch(choice){
            case 1 -> {
                MainMenu mainM = new MainMenu();
                mainM.accessMenu();
            }

            case 2 -> System.exit(0);
        }
    }

    public EndGameMenu(){

    }
}
