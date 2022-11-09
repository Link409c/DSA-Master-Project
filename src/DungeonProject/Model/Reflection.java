package DungeonProject.Model;

/**
 * Reflection is a being the player must fight against deep inside the dungeon.
 * Its stats mirror the player's, and it can perform all the same actions the
 * player can in battle.
 */

public class Reflection extends Player{
    public Reflection(String name, int healthPoints, int attackPoints, int defensePoints,
                      int speed, int level, int experience,
                      Equipment[] equipped, Inventory inventory) {
        super(name, healthPoints, attackPoints, defensePoints, speed, level,
                experience, 0, 0, equipped, inventory);
    }
}
