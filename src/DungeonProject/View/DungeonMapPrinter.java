package DungeonProject.View;

import DungeonProject.Model.Dungeon;

/**
 * The Dungeon Map Printer prints the layout of the current floor of the dungeon for the player.
 * 
 * @author simpso61
 * @version 11/7/22
 */
public class DungeonMapPrinter {

    /**
     * printFloorMap prints a visual representation of the current dungeon object,
     * showing player location, exit(if found), and items(if found).
     * @param dungeon the dungeon to reference.
     */
    public void printFloorMap(Dungeon dungeon){
        System.out.println("{}================================================================{}");
        System.out.println("{}====  D U N G E O N :: G P                F L O O R :: C F  ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}      GP is games played                  CF is current floor   {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}              print the map in here. get it as centered         {}");
        System.out.println("{}             as possible using loops to determine size vs       {}");
        System.out.println("{}                     space inside the square.                   {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}================================================================{}");
    }
}
