package FinalProject.SortingAlgorithms;

import java.util.Arrays;

/**
 * Merge Sort arranges the elements of a list by recursively dividing the list into halves.
 * Each half is divided again until it cannot be split. Once we have single elements, those elements
 * are grouped in order. Then each part is merged until the recursion ends and the full list is sorted.
 * This sorting algorithm is superior in the fact that it can handle significantly larger sets of data in
 * less time using the splitting process. The smaller a sub list of data gets, the less time the algorithm
 * needs to traverse that sub list and sort the elements. Because of this, the time complexity of this
 * algorithm ends up being O(n log n) time, where each call of the recursive methods is O(n), and the total
 * number of method calls is equal to 2^(n-1), where n is the number of elements in the array, which can be
 * written as log base 2 n (b^y = x <=> logbx = y).
 *
 * @author Christian Simpson
 * @version 12/9/22
 */
public class MergeSort<E extends Comparable<E>> implements ChristianSorter<E> {

    /**
     * Merge Method takes two arrays and sorts their elements, adding them into the original array
     * to return. Each pair of elements in the left and right halves will be compared, and the
     * smaller one inserted into the array first. This continues until there are no more elements
     * in either array. Then, any remaining elements left over will be inserted, and the array is returned.
     * @param array the original array to be updated.
     * @param leftHalf the lower half of elements to be sorted.
     * @param rightHalf the upper half of elements to be sorted.
     * @return Returns an array of sorted elements consisting of the combined elements of
     * leftHalf and rightHalf.
     */
    public E[] merge(E[] array, E[] leftHalf, E[] rightHalf){
        //get size of both arrays
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        //variables to track location in each half
        //i is left half, j is right half, k is location to insert in new array
        int i = 0, j = 0, k = 0;
        //loop while both arrays have unsorted elements
        while(i < leftSize && j < rightSize){
            //compare each pair of elements
            //if left array element is lower than right array element,
            if(leftHalf[i].compareTo(rightHalf[j]) <= 0){
                //insert that element into the new array
                array[k] = leftHalf[i];
                //increment i to compare next leftHalf element
                i++;
            }
            else{
                //otherwise insert the right element
                array[k] = rightHalf[j];
                //increment j to compare next rightHalf element
                j++;
            }
            //increment k, moving to the next index of the sorted array
            k++;
        }
        //if any array still has elements,
        //add those remaining elements.
        //no sorting needed because each passed array should be in the correct order
        while(i < leftSize){
            array[k] = leftHalf[i];
            k++;
            i++;
        }
        while(j < rightSize){
            array[k] = rightHalf[j];
            k++;
            j++;
        }
        return array;
    }

    /**
     * mergeSort method contains two recursive method calls to run the Merge Sort algorithm.
     * recursive calls to the method splits the passed array into halves until each passed array
     * only has one element. Then, the two halves are passed to the merge method, which compares
     * them, places them in the correct order in a new array, and returns that array. Each time
     * this method runs, it returns an array of double the amount of elements that were in each array passed
     * to the merge method, until all of the elements have been sorted.
     * @param array the array to be split into parts and sorted.
     * @return returns a sorted array.
     */
    public E[] mergeSort(E[] array){
        int arraySize = array.length;
        //if there is less than 2 elements no splitting or sorting required
        if(arraySize < 2){
            return array;
        }
        //otherwise,
        //get midpoint for splitting
        int midPoint = arraySize / 2;
        //divide the array into 2 halves
        //using Arrays.copyOf because we are implementing generics
        E[] leftHalf = Arrays.copyOf(array, midPoint);
        E[] rightHalf = Arrays.copyOf(array, arraySize - midPoint);
        //copy the right half of the original array to rightHalf
        for (int i = midPoint, j = 0; i < arraySize && j < rightHalf.length; i++, j++) {
            rightHalf[j] = array[i];
        }
        //continue splitting until the arrays only have one element
        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);
        //finally, sort each part and merge them into the one array
        array = merge(array, leftHalf, rightHalf);
        return array;
    }


    @Override
    public void sortArray(E[] array) {
        //if array is not null,
        if (array != null) {
            int length = array.length;
            //sort only if there is more than one element
            if (length > 1) {
                E[] result = mergeSort(array);
                setList(result);
            }
        }
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

    public MergeSort(E[] list){
        this.list = list;
    }
}
