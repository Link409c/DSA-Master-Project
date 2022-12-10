package FinalProject.SortingAlgorithms;

/**
 * Christian Sorter is an interface designed to be implemented in sorting algorithms.
 * The examples within this package will use an array of objects. If my algorithms are
 * to be used within other programs, those programs must contain methods that represent
 * their data structures as arrays.
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public interface ChristianSorter<E extends Comparable<E>> {

    /**
     * The Sort Array method should perform the Class's specified sorting algorithm.
     * @param array the array to be sorted.
     */
    void sortArray(E[] array);

    /**
     * Print List prints the elements of the Class's list object.
     */
    void printList();

}
