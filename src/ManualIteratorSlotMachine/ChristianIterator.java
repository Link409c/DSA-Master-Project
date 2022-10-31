package ManualIteratorSlotMachine;

import java.util.Iterator;

public class ChristianIterator<E> implements Iterator<E> {

    public boolean hasNext() {
        /*if(getCoins() > 0) {
            return true;
        }else {
            return false;
        }
    */
        return false;
    }

    public E next() {
     /*   //counter for pulls
        int pullCounter = 0;
        //if you have coins (hasnext)
        while(hasNext()){
            //spin the slot machine
            pull();
            pullCounter++;
        }
        System.out.println("You are out of coins! You played " + pullCounter + " times.");
        */
        return null;
    }
    public void remove() {
        //remove a coin if result of pull is loss
        //setCoins(getCoins()-1);
    }


}
