package DungeonProject;

import static DungeonProject.ItemType.EQUIPMENT;

public class Weapon extends Equipment{

    private final ItemType TYPE = EQUIPMENT;
    private String name;
    private String description;

    public Weapon(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
