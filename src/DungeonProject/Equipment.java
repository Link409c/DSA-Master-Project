package DungeonProject;

import static DungeonProject.ItemType.EQUIPMENT;

public class Equipment extends Item{

    private final ItemType TYPE = EQUIPMENT;
    private String name;
    private String description;

    public Equipment(){

    }

    public Equipment(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ItemType getTYPE() {
        return TYPE;
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
