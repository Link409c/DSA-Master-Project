package DungeonProject.Model;

/**
 * Battle Result is used after the player wins a battle to update their data.
 */
public class BattleResult {

    public Player doleRewards(Player p, Monster m){
        //print the results of the battle
        //increase kill counts, experience, items etc. and check level up
        System.out.println("Victory! You defeated " + m.getName() + ".");
        p.setKillCount(p.getKillCount() + 1);
        System.out.println("You gain " + m.getExperience() + " experience.");
        p.setExperience(p.getExperience() + m.getExperience());
        p.checkLevelUp(p.getExperience());
        if(m.hasReward()){
            System.out.println("Got a " + m.getReward().getName() + ".");
            p.getInventory().getItems().add(m.getReward());
            p.setItemsAcquired(p.getItemsAcquired() + 1);
        }
        return p;
    }

}
