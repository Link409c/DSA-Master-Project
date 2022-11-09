package DungeonProject.Model;

/**
 * Health Bar Calculator does the necessary math to determine
 * the amount of characters to print in the simulation of a
 * dynamic HP display in the battle window.
 */
public class HealthBarCalculator {

    public double calculateHPBar(Being b){
        //get the being's max hp divided by 24
        double full = b.getMaxHealthPoints() / 24.0 ;
        //get the being's current hp divided by 24
        double current = b.getCurrHealthPoints() / 24.0;
        //subtract max from current
        return full - current;
    }

    public HealthBarCalculator(){

    }
}
