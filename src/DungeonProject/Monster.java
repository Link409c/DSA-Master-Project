package DungeonProject;

public class Monster extends Being {

    private MonsterType monsterType;

    private int experience;

    private Item reward;

    public Monster() {
    }

    public Monster(String name, int maxHealthPoints, int attackPoints, int defensePoints,
                   int speed, int level, MonsterType monsterType, int experience, Item reward) {
        super(name, maxHealthPoints, attackPoints, defensePoints, speed, level);
        this.monsterType = monsterType;
        this.experience = experience;
        this.reward = reward;
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

    /*
    public void Mutate(Monster m){
        switch(m.getMonsterType()){
            case Slime -> {}
            case Bat -> {}
            case Goblin -> {}
            case Skeleton -> {}
            case Zombie -> {}
            case Orc -> {}
            case Minotaur -> {}
            case Dragon -> {}
            case TreasureLizard -> {}
        }
    }
     */
}
