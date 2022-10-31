package DungeonProject;

public class Item{

    private ItemType type;

    private String name;

    private String description;

    public Item(){

    }

    public Item(ItemType type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
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

}
