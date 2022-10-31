package DungeonProject;

public class Potion extends Item{

    private final ItemType TYPE = ItemType.USABLE;

    private int healValue;

    public Potion(int healValue) {
        this.healValue = healValue;
    }

    public Potion(ItemType type, String name, String description, int healValue) {
        super(type, name, description);
        this.healValue = healValue;
    }

    public ItemType getTYPE() {
        return TYPE;
    }

    public int getHealValue() {
        return healValue;
    }

    public void setHealValue(int healValue) {
        this.healValue = healValue;
    }

    public void use(Player p){
        if(p.getCurrHealthPoints() != p.getMaxHealthPoints()) {
            p.setCurrHealthPoints(p.getCurrHealthPoints() + getHealValue());
            p.getInventory().removeValue(this);
        }
        else{
            System.out.println("HP is at Max.");
        }
    }
}
