package FinalProject.SortingAlgorithms;

public class ShellSort {
    //starting with an array of n elements,
    //using shell's method to find the interval,
    //divide by (n/2, n/4, n/8 ...) until the value = 1.
    //first division n/2 = 8/2 = 4.
    //the interval of comparison is 4.
    //in each section,
    //compare the relatively placed elements
    // [2][7][13][24][0][6][3][18]
    //  1  2   3   4  1  2  3   4
    //each pair of elements is a sub list.
    //check each sub list and swap elements if necessary.
    // [0][6][3][18][2][7][13][24]
    //divide again to reduce the interval size. n/4 = 2
    // [0][6][3][18][2][7][13][24]
    //  1  2  1   2  1  2   1   2
    //check each sublist and swap elements if necessary.
    // [0][6][3][18][2][7][13][24]
    //divide again to reduce interval size n/8 = 1
    // [0][6][3][18][2][7][13][24]
    //  1  1  1   1  1  1   1   1
    //check each sublist and swap elements if necessary.
    // [0][3][6][2][7][13][18][24]
    //now perform insertion sort on the array.
    // [0][3][6][2][7][13][18][24]
    //     ^
    // [0][3][6][2][7][13][18][24]
    //        ^
    // [0][3][6][2][7][13][18][24]
    //           ^
    // [0][2][3][6][7][13][18][24]
    //              ^
    // [0][2][3][6][7][13][18][24]
    //                  ^
    // [0][2][3][6][7][13][18][24]
    //                      ^
    // [0][2][3][6][7][13][18][24]
    //                          ^
    // [0][2][3][6][7][13][18][24]
    // sort is complete.
}