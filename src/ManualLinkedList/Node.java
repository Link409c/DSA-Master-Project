package ManualLinkedList;

public class Node{
    //currently single linked list 
    //holds a character and references to next and previous nodes
    private char c;
    private Node next;

    //private Node prev;
    
    //constructors
    public Node(){}
    
    public Node(char aChar, Node aNext){
        c = aChar;
        next = aNext;
        //prev = p;
    }
    
    //getters
    public char getChar(){
        return c;
    }
    
    public Node getNext(){
        return next;
    }
    
    /*public Node getPrev(){
        return prev;
    }*/

    //setters
    public void setChar(char aChar){
        c = aChar;
    }
    
    public void setNext(Node aNext){
        next = aNext;
    }
    
    /*public void setPrev(Node p){
        prev = p;
    }*/
}