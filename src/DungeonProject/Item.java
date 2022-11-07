package DungeonProject;

/**
 * An object that the player can pick up and put in their inventory. The enumerated type variable
 * includes usable, equipment, and key items.
 */
public class Item{

    private ItemType type;

    private String name;

    private String description;

    private int attack;

    private int defense;

    private int speed;

    private int maxHealthPoints;

    private int restore;

    public Item(){
    }

    public Item(ItemType type, String name, String description, int attack, int defense, int speed,
                int maxHealthPoints, int restore) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.maxHealthPoints = maxHealthPoints;
        this.restore = restore;

    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getRestore() {
        return restore;
    }

    public void setRestore(int restore) {
        this.restore = restore;
    }
}
