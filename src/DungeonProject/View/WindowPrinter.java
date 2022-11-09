package DungeonProject.View;

import DungeonProject.Model.Being;
import DungeonProject.Model.Player;
import DungeonProject.Model.HealthBarCalculator;
import DungeonProject.Model.Reflection;

/**
 * Window Printer displays pseudo game windows to try and give the player a deeper
 * sense of immersion instead of simply looking at lines of text in the terminal window.
 * @author simpso61
 * @version 11/7/22
 */
public class WindowPrinter{

	/**
	 * printBattleWindow prints a display emulating a battle window to make the battle more
	 * immersive for the user. "Health Bars" are 24 characters segmented based on being max
	 * health points minus current health.
	 */
	public void printBattleWindow(Being p, Being m) {
		HealthBarCalculator calc = new HealthBarCalculator();
		double playerDisplayHP = calc.calculateHPBar(p);
		double enemyDisplayHP = calc.calculateHPBar(m);
		char barSegment = 'I';
		//print out the number of characters equal to being's current health / 24
		//if monster is Reflection, print % instead of I
		if(m instanceof Reflection){
			barSegment = '%';
		}
		/* if the being's current HP is less than or equal to twenty percent of max,
		 * print ! instead of I */
		double hpPercent = (double) p.getCurrHealthPoints() / p.getMaxHealthPoints();
		if(hpPercent <= 20.0){
			barSegment = '!';
		}
		//fill the remaining area with spaces until the frame is reached
		System.out.println("\n{}================================================================{}");
		System.out.println("{}=== P L A Y E R  H P  :CUR / MAX:  IIIIIIIIIIIIIIIIIIIIIIII  ==={}");
		System.out.println("{}================================================================{}");
		System.out.println("{}================================================================{}");
		System.out.println("{}===  E N E M Y  H P   :CUR / MAX:  IIIIIIIIIIIIIIIIIIIIIIII  ==={}");
		System.out.println("{}================================================================{}\n");
	}
    
	 /**
     * printPlayerStatus prints the player's status information when selected in the menu.
     */
    public void printPlayerStatus(Player player) {
		//TODO Replace placeholder values with getters for stats
		System.out.println("\n{}============================={}");
		System.out.println("{}==       S T A T U S       =={}");
		System.out.println("{}============================={}");
		System.out.println("{}=== H P :: C U R / M A X  ==={}");
		System.out.println("{}===  A T K  ::  C U R R   ==={}");
		System.out.println("{}===  D E F  ::  C U R R   ==={}");
		System.out.println("{}===  S P D  ::  C U R R   ==={}");
		System.out.println("{}============================={}");
		System.out.println("{}===    E Q U I P P E D    ==={}");
		System.out.println("{}============================={}");
		System.out.println("{}===  W E A P O N N A M E  ==={}");
		System.out.println("{}===   A R M O R N A M E   ==={}");
		System.out.println("{}=== A C C E S S O R Y N M ==={}");
		System.out.println("{}============================={}\n");

	}

}
