package FinalProject.SortingAlgorithms;

/**
 * Selection Sort is a sorting algorithm that sequentially places the least valued data in a list into
 * the first position of that list. Each time the algorithm passes through a list, the starting point
 * is incremented and the unsorted part grows smaller until only one element remains to be sorted. The time
 * complexity of the Selection Sort algorithm is O(n^2), where n is the number of elements in the array,
 * raised to the power of 2 because we are using one nested loop in order to sort each part of the array in sequence.
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public class SelectionSort<E extends Comparable<E>> implements ChristianSorter<E> {

    public void sortArray(E[] theArray){
        if(theArray != null) {
            //get the length of the array
            int arrLength = theArray.length;
            //if there are at least 2 elements,
            if (arrLength > 1) {
                //using for loop, iterate through the array
                for (int i = 0; i < arrLength; i++) {
                    //set lowest value to array[starting index]
                    E lowest = theArray[i];
                    int indexOfLowest = i;
                    for (int j = i + 1; j < arrLength; j++) {
                        //traverse the array checking each element
                        E toCompare = theArray[j];
                        //if the current element is less than lowest value,
                        if (toCompare.compareTo(lowest) < 0) {
                            //set current element as new lowest
                            lowest = toCompare;
                            //needed to add the index, as without it
                            //another pass of the array after each loop would
                            //need to be implemented
                            indexOfLowest = j;
                        }
                    }
                    /* Debugging Nightmare:
                     * I was trying to do the swapping of values with just the
                     * elements stored in the index and not using the actual locations
                     * in the array and it was making my entire array one value
                     */
                    //swap values of indices if any values met the criteria
                    //store value to swap's index in temp
                    E temp = theArray[indexOfLowest];
                    //store value of lowest element index in starting index
                    theArray[indexOfLowest] = theArray[i];
                    //lowest value is placed at the current loop's starting index
                    theArray[i] = temp;
                }
            }
        }
        setList(theArray);
    }

    public void printList(){
        if(getList() != null){
            for(E e : getList()){
                System.out.print(e.toString() + " ");
            }
        }
        else{
            System.out.println("List is empty.");
        }
    }

    private E[] list;

    public E[] getList() {
        return list;
    }

    public void setList(E[] list) {
        this.list = list;
    }

    public SelectionSort(E[] list){
        this.list = list;
    }
}
