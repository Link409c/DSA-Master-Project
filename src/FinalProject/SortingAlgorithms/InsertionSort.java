package FinalProject.SortingAlgorithms;

/**
 * The Insertion Sort algorithm traverses through a list of objects, comparing each object to the objects before
 * it in the list. For each traversal through the list, the starting index is incremented by 1. This effectively
 * separates the list into two halves: the sorted half starting from the first index until the starting index of
 * the next traversal, and the unsorted half, which is all of the elements after the starting point until the end
 * of the list. Again, because this algorithm uses nested loops, its worst-case Big O Time Complexity is O(n^2).
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public class InsertionSort<E extends Comparable<E>> implements ChristianSorter<E> {

    @Override
    public void sortArray(E[] array) {
        //if the array is not null,
        if (array != null) {
            //get the array length
            int length = array.length;
            //if the array has at least 2 elements,
            if (length > 1) {
                //pass through the array starting at index 1,
                //assuming the first element is in the correct position
                for (int i = 1; i < length; i++) {
                    //store variable to compare
                    E curr = array[i];
                    int prevElements = i - 1;
                    //check each element to the left of current index
                    //if the previous element is greater than curr,
                    while (prevElements >= 0 && array[prevElements].compareTo(curr) > 0) {
                        //move that element to the right
                        array[prevElements + 1] = array[prevElements];
                        //initially I was missing the decrement to the area to compare
                        //this was causing my array to be the current element and then
                        //all other elements were the previous
                        prevElements--;
                    }
                    //finally, set the next element to current
                    array[prevElements + 1] = curr;
                }
            }
        }
        setList(array);
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

    public InsertionSort(E[] list){
        this.list = list;
    }
}
