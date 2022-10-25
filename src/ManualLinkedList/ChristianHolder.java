package ManualLinkedList;

/**********************************************
 * ChristianHolder.java
 * @author Chris Simpson
 * @version 10/24/2022
 * 
 * This program is an exercise made to
 * build our skill set in understanding
 * Data Structures, specifically the 
 * List class and its different 
 * forms. In particular, this class is
 * made to emulate the Linked List structure.
 **********************************************/
public class ChristianHolder
{
   //global variables
   private Node head;
   
   //constructors
   public ChristianHolder(){}
   
   public ChristianHolder(Node aNode){
        head = aNode; 
    }
   
   //getter
   public Node getHead(){
       return head;
   }

   //setter
    public void setHead(Node aNode){
       head = aNode;
    }

    //method to get size of the linked list
    public int getSize() {
    	//size to return
    	int size = 0;
    	//if head is not null,
        if(getHead() != null) {
            //we are at the head node
            //increment size
            size++;
            //make a new node temp
            Node temp = getHead();
            //while temp.getNext() is not null,
            while(temp.getNext() != null) {
                //increment size
                size++;
                //set temp to next
                temp = temp.getNext();
            }
        }
        return size;
    }

    //method to print the values held in each node of the list as a string
   public void printHolder() {
       //current - single linked list
       //create string object to return
       String result = "";
       //if head is null your list has no nodes
       if (getHead() == null) {
           result = "Your container has no nodes.";
       }
       else {
           //make new node
           Node temp = getHead();
           int listSize = getSize();
           //move through LL one node at a time
           for(int i = 0; i < listSize; i++) {
               //add the data stored in node to string
               result += temp.getChar();
               //move to the next node
               temp = temp.getNext();
               //do this until no next node

           }
           //print the result
           System.out.println(result);
       }
   }
    //method to move through the list until you find a specific position
    //accepts a position variable of type int
    //returns the node object at the desired position
    public Node findPosition(int aPosition){
    	//create node to return
        Node atPos = new Node();
        //start at head
        atPos = getHead();
        //call getSize to determine list size
        int listSize = getSize();
        //if size > 0,
        if(listSize > 0) {
            //if position is 0, return head
            if (aPosition == 0) {
                return atPos;
                //if position is less than size, search the list
            }else if (aPosition <= listSize) {
                //for loop iterates through list
                for (int i = 0; i <= aPosition; i++) {
                    atPos = atPos.getNext();
                    if (i == aPosition) {
                        return atPos;
                    }
                }
            } //else throw new Exception("You are attempting to search for a position outside the bounds of your list.");
        }
        return atPos;
    }

    //method to find a Node that contains the value passed to the method
    public Node findValue(char aChar){
        //pass in the char to find
        //make a new node to store current node
        Node n = new Node();
        //if head is not null & if head.getchar equals achar
        if(getHead() != null) {
        	if(getHead().getChar() == aChar) {
        		//return node
                return getHead();
        	}//else while getnext is not null
            else {
                n = getHead();
                while (n.getNext() != null) {
                    //set node to next
                    n = n.getNext();
                    //compare achar to node.getchar
                    if (aChar == n.getChar()) {
                        //if equal, return node
                        return n;
                    }
                }
            }
        }
        return null;
    }
    
    //method to add a new node at the end of the list
    public void add(char aChar){
       Node toAdd = new Node(aChar, null);
        //if no head, put node at head
        if(getHead() == null){
            setHead(toAdd);
        }
        else{
            Node curr = getHead();
            //move through the list until next is null
            //if no node after head, add node here
            while(curr.getNext() != null){
                curr = curr.getNext();
            }
            //put the node at the end of the list
            curr.setNext(toAdd);
        }
    }
    
    //method to put a node in a specific location in the list
    public void put(Node aNode, int aPosition){
        //pass in the node to put and the intended position
        //create a new node
        //create 2 temp nodes
        Node n = new Node();
        Node temp1, temp2 = new Node();
        //store the nodes previous to the intended position in temp 1
        temp1 = findPosition(aPosition - 1);
        //store the node currently in the intended position in temp 2
        temp2 = findPosition(aPosition);
        //set new node prev to temp 1
        //n.setPrev(temp1);
        //set new node next to temp 2
        n.setNext(temp2);
    }
    
    //method to remove a node from a specific position in the list
    public void remove(char aChar){
        //pass in the value to be removed
        //create 2 temp nodes
        Node temp1, temp2 = new Node();
        //get previous node and store it in temp 1

        //get next node and store in temp 2
        //set temp 1 next to temp 2
        //set temp 2 prev to temp 1
    }
}