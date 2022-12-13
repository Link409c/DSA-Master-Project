package FinalProject.SortingAlgorithms;

/**
 * Shell Sort is a sorting algorithm based on insertion sort. However, to further simplify
 * the process, the array or structure to be sorted is divided into intervals or "gaps".
 * Each element in the intervals are compared to each other, and swapped if necessary. Then,
 * the interval is made smaller and smaller, comparing elements closer to each other each
 * interval until we have an interval of 1. Then, a final insertion sort is done to complete
 * the sorting process.
 */
public class ShellSort<E extends Comparable<E>> implements ChristianSorter<E> {
    public E[] shellSort(E[] array) {
        //starting with an array of n elements,
        //using shell's method to find the interval,
        int size = array.length;
        //divide array by (n/2, n/4, n/8 ...) until the value = 1.
        //each pass of the outer loop divides the interval by 2.
        for (int interval = size / 2; interval > 0; interval /= 2) {
            //in each section,
            //get the 2 indices to compare, starting at the first pair (left should be 0)
            for (int i = 0, j = interval - i; i < interval; i++, j++) {
                //compare the relatively placed elements
                E elementL = array[i];
                E elementR = array[j];
                //swap elements if necessary.
                if (elementL.compareTo(elementR) > 0) {
                    array[j] = elementL;
                    array[i] = elementR;
                }
            }
        }
        return array;
    }

        @Override
        public void sortArray (E[]array){
            //if array is not null and has more than one element,
            if (array != null) {
                //get array length
                int length = array.length;
                if (length > 1) {
                    //sort the array
                    E[] result = shellSort(array);
                    //set the global variable list to the sorted array.
                    setList(result);
                }
            }
        }
        @Override
        public void printList () {
            if (getList() != null) {
                for (E e : getList()) {
                    System.out.print(e.toString() + " ");
                }
            } else {
                System.out.println("List is empty.");
            }
        }

        private E[] list;

        public E[] getList () {
            return list;
        }

        public void setList (E[]list){
            this.list = list;
        }

    public ShellSort(E[]list){
            this.list = list;
        }
}