package DungeonProject.View;

/**
 * Menu Printer class is an object that prints menus for the user.
 */
public class MenuPrinter{

    /**
     * mainMenu shows the player the available options when starting the game.
     */
    public void printMainMenu(){
        System.out.println("\n{}================================================================{}");
        System.out.println("{}====   C H R I S T I A N ' S  D U N G E O N  C R A W L E R  ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}====   (1)  N E W  G A M E         == == ==   o            ooo  {}");
        System.out.println("{} ==    (2)  C O N T I N U E   *   *   ===o        ==        o   {}");
        System.out.println("{}   ==  (3)  L O A D       ===    *        ==      o oo          {}");
        System.out.println("{}================================================================{}\n");
    }

    /**
     * battleMenu shows the player the available options to select while in battle.
     */
    public void printBattleMenu() {
        System.out.println("\n{}================================================================{}");
        System.out.println("{}====                      B A T T L E                       ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}====   (1)  A T T A C K    @     == o=     I T E M S  (3)   ooo {}");
        System.out.println("{} ==oo  	(2)  D E F E N D    ===o     R U N       (4)      o  {}");
        System.out.println("{}   == o   0   ===      @       ==      o oo   * * =             {}");
        System.out.println("{}================================================================{}\n");
    }

    /**
     * inventoryMenu shows the player the available options when opening and accessing the inventory.
     */
    public void printInventoryMenu() {
        System.out.println("\n{}================================================================{}");
        System.out.println("{}====                   I N V E N T O R Y                    ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}====   (1)  I T E M S    @     == o=     K E Y   @*=  (3)   ooo {}");
        System.out.println("{} ==oo  	(2)  E Q U I P    ===o     R E T U R N   (4)      o   {}");
        System.out.println("{}   == o   0   ===      @       ==      o oo   * * =             {}");
        System.out.println("{}================================================================{}\n");
    }

    /**
     * keyItemsMenu shows the player available options when accessing key items.
     */
    public void printKeyItemsMenu(){
        System.out.println("\n{}================================================================{}");
        System.out.println("{}====                    K E Y  I T E M S                    ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}====   (1)  L I S T      @     == o=       * & *            ooo {}");
        System.out.println("{} ==oo  	(2)  C H E C K    ===o     R E T U R N   (4)      o   {}");
        System.out.println("{}   == o   0   ===      @       ==      o oo   * * =             {}");
        System.out.println("{}================================================================{}\n");
    }

    /**
     * equipmentMenu shows the player available options when accessing equipment.
     */
    public void printEquipmentMenu(){
        System.out.println("\n{}================================================================{}");
        System.out.println("{}====                   E Q U I P M E N T                    ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}====   (1)  E Q U I P      == o=           D R O P    (3)   ooo {}");
        System.out.println("{} ==oo  	(2)  C H E C K    ===o      R E T U R N   (4)     o   {}");
        System.out.println("{}   == o   0   ===      @       ==      o oo   * * =             {}");
        System.out.println("{}================================================================{}\n");
    }

    /**
     * usableMenu shows the player available options when accessing usable items.
     */
    public void printUsableMenu(){
    	System.out.println("\n{}================================================================{}");
        System.out.println("{}====                      I T E M S                         ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}====   (1)    U S E        == o=           D R O P    (3)   ooo {}");
        System.out.println("{} ==oo  	(2)  C H E C K    ===o     R E T U R N   (4)      o   {}");
        System.out.println("{}   == o   0   ===      @       ==      o oo   * * =             {}");
        System.out.println("{}================================================================{}\n");
    }

}