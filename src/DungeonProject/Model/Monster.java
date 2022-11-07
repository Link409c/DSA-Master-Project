package DungeonProject.Model;

public class Monster extends Being {

    /**
     * Mutate changes the stats of the monster based on its monster type.
     */
    public void mutate(int currentFloor, int playerLevel){
        switch(getMonsterType()){
            case Slime -> {
                setName("Slime");
                setLevel(currentFloor);
                setMaxHealthPoints(10 * getLevel());
                setAttackPoints(2 * getLevel());
                setDefensePoints(getLevel());
                setSpeed(getLevel());
                setExperience(currentFloor * 25);
            }
            case Bat -> {
                setName("Bat");
                setLevel(currentFloor);
                setMaxHealthPoints(12 * getLevel());
                setAttackPoints(getLevel());
                setDefensePoints(getLevel());
                setSpeed(2 * getLevel());
                setExperience(currentFloor * 30);
            }
            case Goblin -> {
                setName("Goblin");
                setLevel(2* currentFloor);
                setMaxHealthPoints(20 * getLevel());
                setAttackPoints(4 * getLevel());
                setDefensePoints(2 * getLevel());
                setSpeed(getLevel());
                setExperience(currentFloor * 45);
            }
            case Skeleton -> {
                setName("Skeleton");
                setLevel(currentFloor);
                setMaxHealthPoints(15 * getLevel());
                setAttackPoints(5 * getLevel());
                setDefensePoints(3 * getLevel());
                setSpeed(2 * getLevel());
                setExperience(currentFloor * 55);
            }
            case Zombie -> {
                setName("Zombie");
                setLevel(currentFloor);
                setMaxHealthPoints(15 * getLevel());
                setAttackPoints(5 * getLevel());
                setDefensePoints(getLevel());
                setSpeed(getLevel() - (playerLevel/2));
                setExperience(currentFloor * 35);
            }
            case Orc -> {
                setName("Orc");
                setLevel(currentFloor + 2);
                setMaxHealthPoints(50 * getLevel());
                setAttackPoints(8 * getLevel());
                setDefensePoints(5 * getLevel());
                setSpeed(getLevel());
                setExperience(currentFloor * 100);
            }
            case Minotaur -> {
                setName("Minotaur");
                setLevel(currentFloor + 2);
                setMaxHealthPoints(150 * getLevel());
                setAttackPoints(13 * getLevel());
                setDefensePoints(10 * getLevel());
                setSpeed(3 * getLevel());
                setExperience(currentFloor * 200);
            }
            case Dragon -> {
                setName("Dragon");
                setLevel(currentFloor + 5);
                setMaxHealthPoints(200 * getLevel());
                setAttackPoints(20 * getLevel());
                setDefensePoints(15 * getLevel());
                setSpeed(5 * getLevel());
                setExperience(currentFloor * 400);
            }
            case TreasureLizard -> {
                setName("Treasure Lizard");
                setLevel(currentFloor);
                setMaxHealthPoints(20 * getLevel());
                setAttackPoints(1);
                setDefensePoints(5 * getLevel());
                setSpeed(10 * getLevel());
                setExperience(currentFloor * 100);
            }
        }
    }

    private MonsterType monsterType;

    private int experience;

    private Item reward;

    public Monster(MonsterType monsterType, int currentFloor, int playerLevel){
        this.monsterType = monsterType;
        mutate(currentFloor, playerLevel);
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }

    public boolean hasReward(){
        return getReward() != null;
    }

}
