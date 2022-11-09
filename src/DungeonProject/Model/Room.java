package DungeonProject.Model;

import ManualLinkedList.Node;

public class Room extends Node<Room> {
	
	private Player thePlayer;
	
    private Monster enemy;

    private Item treasure;

    private boolean theExit;

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Monster getEnemy() {
        return enemy;
    }

    public void setEnemy(Monster enemy) {
        this.enemy = enemy;
    }

    public Item getTreasure() {
        return treasure;
    }

    public void setTreasure(Item treasure) {
        this.treasure = treasure;
    }

    public boolean isTheExit() {
        return theExit;
    }

    public void setTheExit(boolean theExit) {
        this.theExit = theExit;
    }

    public Room(){}

    public Room(E e, Node<Room> next, Node<Room> prev, Player thePlayer, Monster enemy,
                Item treasure, boolean theExit) {
        super(e, next, prev);
        this.thePlayer = thePlayer;
        this.enemy = enemy;
        this.treasure = treasure;
        this.theExit = theExit;
    }
}
