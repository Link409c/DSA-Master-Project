package DungeonProject.Testing;

import DungeonProject.Model.*;
import DungeonProject.View.WindowPrinter;

import java.awt.*;
import java.util.Arrays;

public class GameTester {

    public static void main(String[] args) {
        //testing gameplay

        /*Game game = new Game();
        game.play();*/

        //testing string format outputs

        /*String name = "Christian Simpson";
        String name2 = "Christian";
        StringDisplayFormatter s = new StringDisplayFormatter();
        String newName = s.battleWindowNameFormat(name);
        String newName2 = s.battleWindowNameFormat(name2);

        System.out.printf("%S%n", newName);
        System.out.printf("%S", newName2);*/

        //testing equipment constructor and roman numeral assignment

        /*Equipment a = new Equipment("Wooden Sword", 9);
        Equipment b = new Equipment("Sword", 11);
        Equipment c = new Equipment("Greatsword", 25);
        Equipment d = new Equipment("Mail Hauberk", 98);
        Equipment e = new Equipment("Woolen Shirt", 78);
        Equipment f = new Equipment("Vital Pendant", 83);
        System.out.println(a.getName());
        System.out.println(b.getName());
        System.out.println(c.getName());
        System.out.println(d.getName());
        System.out.println(e.getName());
        System.out.println(f.getName());*/

        //test normal battle window

        /*Player c = new Player("Kara");
        Monster m = new Monster(MonsterType.Dragon, 1, c.getLevel());
        WindowPrinter w = new WindowPrinter();
        w.printBattleWindow(c, m);
        //testing a name longer than character limit
        c.setName("Joroff Joroffsen");
        //test critical health indicator
        c.setCurrHealthPoints(20);
        //test reflection case
        Monster r = new Monster(MonsterType.Reflection, c);
        w.printBattleWindow(c, r);
        //test name abbreviation
        c.setName("Christian Simpson");
        //test large values
        c.setMaxHealthPoints(9999);
        c.setCurrHealthPoints(2567);
        //test uneven values
        m.setMaxHealthPoints(567);
        m.setCurrHealthPoints(222);
        w.printBattleWindow(c, m);
        c.setCurrHealthPoints(1000);
        w.printBattleWindow(c, m);*/

        //test status window

        //testing normal values

        /*Player c = new Player("Kara");
        c.setMaxHealthPoints(1000);
        c.setCurrHealthPoints(1000);
        c.setAttackPoints(200);
        c.setDefensePoints(33);
        c.setSpeed(3001);
        WindowPrinter w = new WindowPrinter();
        w.printPlayerStatus(c);

        //testing name and values > 9999

        c.setName("Kara Kummer");
        c.setMaxHealthPoints(12330);
        c.setCurrHealthPoints(121);
        c.setAttackPoints(21);
        c.setDefensePoints(546);
        c.setSpeed(7);
        w.printPlayerStatus(c);

        //testing name and values > 9999

        c.setName("Jollof Jolloffson");
        c.setAttackPoints(20000);
        c.setDefensePoints(33000);
        c.setSpeed(30010);
        w.printPlayerStatus(c);*/

        //testing length comparing code

        /*String name = "Hungry the Sandwich";
        String[] names = name.split(" ");
        String most = names[0];
        for(int i = 1; i < names.length; i++){
            if(most.length() < names[i].length()){
                most = names[i];
            }
        }
        System.out.print(most + " ");
        name = "Slamwich Amongus Pizzahut Everywhere";
        names = name.split(" ");
        most = names[0];
        for(int i = 1; i < names.length; i++){
            if(most.length() < names[i].length()){
                most = names[i];
            }
        }
        System.out.print(most + " ");
        name = "I am within two hundred feet of a barbeque stand and I can feel " +
                "the unadulterated primal urges beginning to well up from within me.";
        names = name.split(" ");
        most = names[0];
        for(int i = 1; i < names.length; i++){
            if(most.length() < names[i].length()){
                most = names[i];
            }
        }
        System.out.print(most + " ");*/

        //test rewards window

        /*Player c = new Player("Jollof Jolloffsen");
        Monster m = new Monster(MonsterType.Goblin, c);
        m.setName("Goblin");
        m.setExperience(999);
        m.setReward(new Item(ItemType.EQUIPMENT, "Mail Hauberk", 37));
        m.setName("Treasure Lizard");
        m.setExperience(2222);
        WindowPrinter w = new WindowPrinter();
        w.printBattleResultWindow(m);
        m.setName("Slime");
        m.setExperience(22);
        m.setReward(new Item(ItemType.EQUIPMENT, "Greatsword", 11));
        w.printBattleResultWindow(m);
        m.setName("Orc");
        m.setExperience(7364);
        m.setReward(new Item(ItemType.EQUIPMENT, "Ring of Defense", 44));
        w.printBattleResultWindow(m);
        m.setName("Lizardman");
        m.setExperience(3);
        m.setReward(new Item(ItemType.USABLE, "Max Potion", 1));
        w.printBattleResultWindow(m);
        m = new Monster(MonsterType.Reflection, c);
        m.setExperience(m.getExperience());
        m.setReward(new Item(ItemType.KEY, "Curious Stone", 1));
        w.printBattleResultWindow(m);*/

        //test item header

        /*ItemType[] types = {ItemType.USABLE, ItemType.EQUIPMENT, ItemType.KEY};
        WindowPrinter w = new WindowPrinter();
        for(int i = 0; i < 3; i++) {
            String theItem = types[i].toString();
            w.printItemsHeader(theItem);*/
        }

    }
