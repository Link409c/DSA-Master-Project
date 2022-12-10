package FinalProject.SortingAlgorithms;

/**
 * Merge Sort arranges the elements of a list by recursively dividing the list into halves.
 * Each half is sorted according to its elements, and divided again until it cannot be split.
 * Once each half is sorted, it is "merged" with its respective half, and so on, until the
 * recursion ends and the full list is sorted. This sorting algorithm is superior in the fact
 * that it can handle significantly larger sets of data in less time using the splitting process.
 * The smaller a sub list of data gets, the less time the algorithm needs to traverse that sub list
 * and sort the elements.
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public class MergeSort<E extends Comparable<E>> implements ChristianSorter<E> {

    /**
     * Starter method for the recursive Split method. This initial method call passes
     * the original array
     * @return
     */
    public E[] split(){}

    /**
     * Split method calculates the middle point of the array and divides it into two sub
     * arrays. Recursive calls to this method will split the array to be sorted until it
     * contains a single element.
     * @param array the array to be split
     * @param left the left endpoint of the array
     * @param middle the midpoint of the array
     * @param right the right endpoint of the array
     * @return returns a new sub array containing half the elements of the passed array.
     */
    public E[] split(E[] array, int left, int middle, int right){

    }
    @Override
    public void sortArray(E[] array) {
        //if array is not null,
        //and has at least 2 elements
        //check if left and right most elements are out of order
        //if so, split the array
        //continue splitting these sub arrays until each sub array has one element.
        //now, compare each element and combine them into larger lists.
        //continue this process until we have a final merged list.

    }

    @Override
    public void printList() {

    }
}
