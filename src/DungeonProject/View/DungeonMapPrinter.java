package DungeonProject.View;

import DungeonProject.Model.Dungeon;
import DungeonProject.Model.Player;

/**
 * The Dungeon Map Printer formats and prints the layout of the current floor of the dungeon for the player.
 * @author simpso61
 * @version 11/14/22
 */
public class DungeonMapPrinter {

    public void mapInfoFormatter(Player p, Dungeon d){
        int gp = p.getGamesPlayed();
        int cf = d.getCurrentFloor();
        String gamesP, currF;
        if(gp < 10 ){
            gamesP = "0 " + gp;
        }else{
            gamesP = String.valueOf(gp);
        }
        if(cf < 10){
            currF = "0 " + cf;
        }
        else{
            currF = String.valueOf(cf);
        }
        setCurrentFloor(currF);
        setGamesPlayed(gamesP);
    }

    public void mapLayoutFormatter(Dungeon d){
        //TODO format the map layout for use in the printFloorMap method
        int rooms = d.getDungeonRooms().getSize();
        //track the room number for accuracy, remove this once complete
        System.out.println(rooms);
        for(int i = 0; i < rooms; i++){
            if(i == rooms-1){
                if(i == d.getPlayerPosition()){
                    System.out.print("[*]");
                }
                System.out.print("[ ]");
            }else {
                if(i == d.getPlayerPosition()){
                    System.out.print("[*]=");
                }
                System.out.print("[ ]=");
            }
        }
    }

    /**
     * printFloorMap prints a visual representation of the current dungeon object,
     * showing player location, exit(if found), and items(if found).
     */
    //TODO format the map to print correctly
    //67 char length
    public void printFloorMap(){
        System.out.println("\n{}================================================================{}");
        System.out.println("{}====  D U N G E O N :: " + getGamesPlayed() +"       " +
                "         F L O O R :: " + getCurrentFloor() + "  ===={}");
        System.out.println("{}================================================================{}");
        System.out.println("{}                                                                {}");
        System.out.println("{}              print the map in here. get it as centered         {}");
        System.out.println("{}             as possible using loops to determine size vs       {}");
        System.out.println("{}                     space inside the square.                   {}");
        System.out.println("{}                                                                {}");
        System.out.println("{}================================================================{}");
    }
    private String currentFloor;

    private String gamesPlayed;

    public String getCurrentFloor(){
        return currentFloor;
    }
    public void setCurrentFloor(String currentFloor){
        this.currentFloor = currentFloor;
    }

    public String getGamesPlayed(){
        return gamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed){
        this.gamesPlayed = gamesPlayed;
    }
}
