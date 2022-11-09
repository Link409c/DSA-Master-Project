package DungeonProject.Control;

import DungeonProject.Model.Monster;
import DungeonProject.Model.Player;

public interface MenuInterface {

    void accessMenu();

    void accessMenu(Player p);

    boolean accessMenu(Player p, Monster m);

}
