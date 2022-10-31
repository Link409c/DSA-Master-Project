package DungeonProject;

public interface BeingInterface{

    //attack the target b
    void attack(Being b);

    //defend, increasing defense and regain some hp
    void defend();

    //check whether the being is dead
    boolean isDead();

}
