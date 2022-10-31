package ManualLinkedList;

/***************************************************************************************************************
 * ChristianHolder.java
 * @author Chris Simpson
 * @version 10/31/2022
 * This program is an exercise made to build our skill set in understanding Data Structures, specifically the
 * List class and its different forms. In particular, this class is made to emulate the Linked List structure.
 **************************************************************************************************************/
public class ChristianHolder<E>
{
   //global variables
   private Node<E> head;

   private Node<E> tail;
   
   //constructors
   public ChristianHolder(){}
   
   public ChristianHolder(Node<E> head){
        this.head = head;
        this.tail = head;
    }
   
   //getter
   public Node<E> getHead(){
       return head;
   }

   //setter
   public void setHead(Node<E> head){
       this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
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
            Node<E> temp = getHead();
            //while temp.getNext() is not the head,
            while((temp.getNext()) != getHead()) {
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
       //if head is null your list has no nodes
       if (getHead() == null) {
           System.out.println("Your container is empty.");
       }
       else {
           //make new node
           Node<E> temp = getHead();
           int listSize = getSize();
           //move through LL one node at a time
           for(int i = 0; i < listSize; i++) {
               //add the data stored in node to string
               System.out.println(temp.getE());
               //move to the next node
               temp = temp.getNext();
           }
       }
   }
    //method to move through the list until you find a specific position
    //accepts a position variable of type int
    //returns the node object at the desired position
    public Node<E> findPosition(int aPosition){
    	//create node to return, starting at head
        Node<E> atPos = getHead();
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
            }
        }
        return atPos;
    }

    //method to find a Node that contains the value passed to the method
    public Node<E> findValue(E e){
        //pass in the object to find
        //make a new node to store current node
        Node<E> n;
        //if head is not null & if head.getE equals e
        if(getHead() != null) {
        	if(getHead().getE() == e) {
        		//return node
                return getHead();
        	}//else while getNext is not head
            else {
                n = getHead();
                while (n.getNext() != getHead()) {
                    //set node to next
                    n = n.getNext();
                    //compare e to node.getE
                    if (e == n.getE()) {
                        //if equal, return node
                        return n;
                    }
                }
            }
        }else{
            System.out.println("A node with this object value does not exist in this container.");
        }
        return null;
    }
    
    //method to add a new node at the end of the list
    public void add(E e){
        Node<E> toAdd = new Node<>(e, null, null);
        //if no head, put node at head
        if(getHead() == null){
            setHead(toAdd);
        }
        else{
            Node<E> curr = getHead();
            //move through the list until we reach the end
            while(curr.getNext() != getHead()){
                curr = curr.getNext();
            }
            //put the node at the end of the list
            //set the node's previous reference to the current node
            toAdd.setPrev(curr);
            //set the node's next reference to the head
            toAdd.setNext(getHead());
            //set the holder tail reference to the added node
            setTail(toAdd);
            //set the current node next reference to the added node
            curr.setNext(toAdd);
        }
    }
    
    //method to put a node in a specific location in the list
    public void insertAtPos(E e, int aPosition){
        //pass in the node to put and the intended position
        //create a new node
        //create 2 temp nodes
        Node<E> toAdd = new Node<>(e, null, null);
        Node<E> temp1;
        Node<E> temp2;
        //store the nodes previous to the intended position in temp 1
        temp1 = findPosition(aPosition - 1);
        //store the node currently in the intended position in temp 2
        temp2 = findPosition(aPosition);
        //set new node prev to temp 1
        toAdd.setPrev(temp1);
        //set new node next to temp 2
        toAdd.setNext(temp2);
        //set the holder tail reference to the added node
        setTail(toAdd);
        //set the current node next reference to the added node
        temp1.setNext(toAdd);

    }

    public void removeFromPos(int aPosition){

    }
    
    //method to remove the last node in the list
    public void removeEnd(){
        Node<E> theOneBefore = findPosition(getSize()-1);
        setTail(theOneBefore);
    }

    public void removeValue(E e){
       //make 2 temporary nodes to store values and current node
        Node<E> temp1, temp2, curr;
        //call findValue method to find a node with value e
        curr = findValue(e);
        temp1 = curr.getPrev();
        temp2 = curr.getNext();
    }


}