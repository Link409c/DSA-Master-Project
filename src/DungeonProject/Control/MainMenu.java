package DungeonProject.Control;

import DungeonProject.View.MenuPrinter;

import java.util.Scanner;

public class MainMenu implements MenuInterface {

    /**
     * accessMenu method controls the game outside of dungeon gameplay. the user can start a new game,
     * continue a game, or load from a save file.
     */
    @Override
    public void accessMenu() {
        //print main menu
        MenuPrinter m = new MenuPrinter();
        m.printMainMenu();
        Scanner in = new Scanner(System.in);
        //new game, continue, or load
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> newGame();
            case 2 -> continueGame();
            case 3 -> {
                //File aFile = new File(path);
                //continueFromSave();
            }
        }
    }
}
