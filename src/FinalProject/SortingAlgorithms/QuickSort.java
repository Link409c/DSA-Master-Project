package FinalProject.SortingAlgorithms;

import java.util.Arrays;

/**
 * Quick Sort, like Merge Sort, uses the divide and conquer idea to split and sort a list of elements.
 * For each pass through the list, the sorting algorithm chooses a pivot point in the list.
 * Then, each element is compared to the pivot, being placed before or after it if they are smaller or
 * larger than the pivot respectively. Choosing a random pivot is more efficient than the endpoint
 * approach, as when your pivot is the endpoint, more movement of elements will have to occur.
 */
public class QuickSort<E extends Comparable<E>> implements ChristianSorter<E> {

    /**
     * Quick Sort method uses a divide and conquer strategy similar to merge sort. However, instead of
     * breaking up the array into smaller ones until we have one element, we instead sort the elements of
     * the array around a pivot point. Choosing any element as our pivot point, each element in the array is
     * compared to the pivot. If an element is less than the pivot, it is moved to the left side of it, and
     * vice-versa for greater elements. Then, the method is called recursively to perform the same sorting on
     * each section, or sub array, to the left and right of the pivot point. If there are less than 2 elements
     * in the sub arrays, they are considered sorted.
     * @param array the array to be sorted.
     * @param leftIndex the starting index of this sub-array.
     * @param rightIndex the ending index of this sub-array.
     * @return returns a sorted array of generic elements.
     */
    public E[] quickSort(E[] array, int leftIndex, int rightIndex){
        //make a list to return
        E[] result = Arrays.copyOf(array, array.length);
        if(result.length > 2) {
            //pivot point can be any value, choosing endpoint of the array is easier to visualize for me
            //ex. array = [2][7][5][3][1][8][6]
            //                               ^ with 6 as the pivot, we sort all the elements before it
            int pivotIndex = rightIndex;
            //set two pointers to traverse the array from the left and right sides of the section to sort
            int leftPointer = leftIndex;
            int rightPointer = pivotIndex - 1;
            //ex. array = [2][7][5][3][1][8] | [6]
            //             l              r     p
            //              sort this part
            E elementP = array[pivotIndex];
            E elementL = array[leftPointer];
            //while lP and rP are not the same index,
            while (leftPointer < rightPointer) {
                //check the elements at index leftPointer and rightPointer
                elementL = array[leftPointer];
                E elementR = array[rightPointer];
                //if leftPointer element is greater than the pivot element,
                //and rightPointer element is less than pivot element,
                if (elementL.compareTo(elementP) > 0 && elementR.compareTo(elementP) < 0) {
                    //swap those elements and step leftPointer right and rightPointer left one index.
                    result[rightPointer] = elementL;
                    result[leftPointer] = elementR;
                    if (rightPointer == leftPointer + 1) {
                        leftPointer++;
                    } else {
                        rightPointer--;
                        leftPointer++;
                    }
                }
                //else if left is smaller,
                else if (elementL.compareTo(elementP) < 0) {
                    //move left to the right one index.
                    leftPointer++;
                }
                //else if right is greater,
                else if (elementR.compareTo(elementP) > 0) {
                    //move right to the left one index.
                    rightPointer--;
                }
                //repeat until the pointers are at the same index.
            }
            //then, swap the pivot element with the leftPointer element.
            result[leftPointer] = elementP;
            result[pivotIndex] = elementL;
            //this results in two subarrays of elements
            //left of the pivot are all elements smaller than it
            //right of the pivot are all elements larger than it.
            //repeat the sorting process on these subarrays,
            //for the left part,
            //pass in result, the leftmost index for leftIndex, and pivot - 1 for rightIndex
            quickSort(result, leftIndex, pivotIndex - 1);
            //for the right part,
            //pass in result, pivot + 1, and rightIndex
            quickSort(result, pivotIndex + 1, rightIndex);
            //repeat until the list is sorted.
            return result;
        }else {
            return result;
        }
    }
    @Override
    public void sortArray(E[] array) {
        //if array is not null and has more than one element,
        if(array != null) {
            //get array length
            int length = array.length;
            //get first index and last index to pass to quick sort method
            int startingIndex = 0;
            int lastElement = length - 1;
            //sort the array
            E[] result = quickSort(array, startingIndex, lastElement);
            //set the global variable list to the sorted array.
            setList(result);
        }
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

    public QuickSort(E[] list){
        this.list = list;
    }
}
