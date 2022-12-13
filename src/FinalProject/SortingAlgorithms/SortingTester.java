package FinalProject.SortingAlgorithms;

import java.util.Random;

/**
 * Sorting Tester is an object used to test the various sorting algorithms I have implemented.
 * Each algorithm will sort an array of random length and variables.
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public class SortingTester {

    /**
     * Randomize Array gives the array to be sorted a new length and instantiates it with
     * that many values.
     */
    public Integer[] randomizeArray(){
        Random r = new Random();
        Integer[] theArray = new Integer[r.nextInt(1000)];
        for(int i = 0; i < theArray.length; i++){
            int data = r.nextInt(200);
            theArray[i] = data;
        }
        return theArray;
    }

    /**
     * Test calls each sorting algorithm implemented in the Final Project - Sorting Algorithms package
     * with a different array of values each time.
     */
    public void test() {

        setArray(randomizeArray());

        SelectionSort<Integer> selectionSorter = new SelectionSort<>(getArray());
        System.out.println("Selection Sort " + getArray().length + " elements: ");

        System.out.println("Unsorted List: ");
        selectionSorter.printList();

        selectionSorter.sortArray(selectionSorter.getList());

        System.out.println("\nSorted List: ");
        selectionSorter.printList();

        setArray(randomizeArray());

        InsertionSort<Integer> insertionSorter = new InsertionSort<>(getArray());
        System.out.println("\nInsertion Sort " + getArray().length + " elements: ");

        System.out.println("Unsorted List: ");
        insertionSorter.printList();

        insertionSorter.sortArray(insertionSorter.getList());

        System.out.println("\nSorted List: ");
        insertionSorter.printList();

        setArray(randomizeArray());

        BubbleSort<Integer> bubbleSorter = new BubbleSort<>(getArray());
        System.out.println("\nBubble Sort " + getArray().length + " elements: ");

        System.out.println("Unsorted List: ");
        bubbleSorter.printList();

        bubbleSorter.sortArray(bubbleSorter.getList());

        System.out.println("\nSorted List: ");
        bubbleSorter.printList();

        setArray(randomizeArray());

        MergeSort<Integer> mergeSorter = new MergeSort<>(getArray());
        System.out.println("\nMerge Sort " + getArray().length + " elements: ");

        System.out.println("Unsorted List: ");
        mergeSorter.printList();

        mergeSorter.sortArray(mergeSorter.getList());

        System.out.println("\nSorted List: ");
        mergeSorter.printList();

        setArray(randomizeArray());

        //need to debug quicksort. currently the recursion does not terminate.
        QuickSort<Integer> quickSorter = new QuickSort<>(getArray());
        System.out.println("\nQuick Sort " + getArray().length + " elements: ");

        System.out.println("Unsorted List: ");
        quickSorter.printList();

        quickSorter.sortArray(quickSorter.getList());

        System.out.println("\nSorted List: ");
        quickSorter.printList();


    }

    private Integer[] array;

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }
}
