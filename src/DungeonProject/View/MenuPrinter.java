package DungeonProject.View;

public class MenuPrinter implements Printable {
	
	/**
	 * mainMenu shows the player the available options when starting the game.
	 */
   public void mainMenu(){
       System.out.println("{}================================================================{}");
       System.out.println("{}====   C H R I S T I A N ' S  D U N G E O N  C R A W L E R  ===={}");
       System.out.println("{}================================================================{}");
       System.out.println("{}====   (1)  N E W  G A M E         == == ==   o            ooo  {}");
       System.out.println("{} ==    (2)  C O N T I N U E           ===o        ==        o   {}");
       System.out.println("{}   ==  (3)  L O A D       ===             ==      o oo          {}");
       System.out.println("{}================================================================{}");
   }
   
   /**
    * battleMenu shows the player the available options to select while in battle.
    */
   public void battleMenu() {}
   
   /**
	 * inventoryMenu shows the player the available options when opening and using the menu.
	 */
   public void inventoryMenu() {}
   
	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

}
