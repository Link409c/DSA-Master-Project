package DungeonProject.Model;

import ManualLinkedList.ChristianHolder;

/**
 * Room Checker checks the current room the player is in for enemies and items. If an enemy exists in the room,
 * a battle occurs.
 *
 * @version 11/14/22
 */
public class RoomChecker {

    public Room checkRoom(Room r){
        //if room has enemy,
        if(r.getEnemy() != null) {
            //make a new battle object
            Battle b = new Battle();
            //pass in the enemy and player
            b.runBattle(r);
            //if the player wins
            if(!r.getThePlayer().isDead()) {
                //update player object with battle result
                BattleResult br = new BattleResult();
                r.setThePlayer(br.battleRewards(r.getThePlayer(), r.getEnemy()));
            }else {
                return r;
            }
        }
        //if room has treasure
        if(r.getTreasure() != null) {
            //add it to the player inventory
            r.getThePlayer().getInventory().getItems().add(r.getTreasure());
            r.setTreasure(null);
        }
        return r;
    }



    public RoomChecker(){

    }
}
