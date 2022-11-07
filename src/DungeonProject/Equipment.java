package DungeonProject;

public class Equipment extends Item{

    private EquipmentType equipmentType;

    public Equipment(EquipmentType equipmentType, String name, String description, int attack,
                     int defense, int speed, int maxHealthPoints, int restore) {
        super(ItemType.EQUIPMENT, name, description, attack, defense, speed, maxHealthPoints, restore);
        this.equipmentType = equipmentType;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
}
