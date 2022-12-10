package FinalProject.SortingAlgorithms;

/**
 * Bubble Sort traverses an array, swapping adjacent elements if they are out of order.
 * This sorting algorithm uses linear traversal, which gets slower as the size of the data set
 * grows. Because the algorithm uses a nested for-loop, its Big O Time Complexity is O(n^2) in
 * the worst case.
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public class BubbleSort<E extends Comparable<E>> implements ChristianSorter<E> {

    @Override
    public void sortArray(E[] array) {
        //if the array is not null,
        if (array != null) {
            //get the array length
            int length = array.length;
            //if the array has at least 2 elements,
            if (length > 1) {
                //nested for loop compares each two adjacent elements
                for (int i = 0; i < length - 1; i++) {
                    for (int j = i + 1; j < length; j++) {
                        //get both elements and compare them
                        E elementI = array[i];
                        E elementJ = array[j];
                        //if j is less than i, switch the elements
                        if (elementJ.compareTo(elementI) < 0) {
                            array[i] = elementJ;
                            array[j] = elementI;
                        }
                    }
                }
            }
        }
        setList(array);
    }

    @Override
    public void printList() {
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

    public BubbleSort(E[] list) {
        this.list = list;
    }
}
