package MovingX;

public class MovingX {
    //global variables
    private int rowsN, columnsM;

    public MovingX(){};

    //Write a constructor that will populate those two global variables.
    public MovingX(int aRows, int aColumns) {
        rowsN = aRows;
        columnsM = aColumns;
    }

    //setters and getters
    public int getRows() {
        return rowsN;
    }

    public void setRows(int aRows) {
        rowsN = aRows;
    }

    public int getColumns() {
        return columnsM;
    }

    public void setColumns(int aColumns) {
        columnsM = aColumns;
    }

    //Method  1: Make a method forLoopGrid()
    /*Write nested loops to print out "[ ]". With two local variables x, y. They start at x = 0 and y = 0;
    During your loop if i = x and j = y, then print out a "[ x ]" instead.
    Once the whole grid is printed. x++ if x < the length of the rows.  Else set x to 0 and y++.
    Loop this whole procedure n x m times.  Ie 9 times if your array is 3 x 3.*/
    public void forLoopGrid() {
        //set sentinel variables
        int x = 0, y = 0, r = (getColumns() * getRows());
        //beginning of loops
        do {
            //loop rows
            for (int i = 0; i < getRows(); i++) {
                //loop columns
                for (int j = 0; j < getColumns(); j++) {
                    //starting from the first position print "X"
                    if (i == x && j == y) {
                        //X case for newline
                        if (j == getColumns() - 1) {
                            System.out.print("[x]\n");
                        } else {
                            System.out.print("[x] ");
                        }
                        //non-"X" case for newline
                    } else if (j == getColumns() - 1) {
                        System.out.print("[ ]\n");
                    } else {
                        System.out.print("[ ] ");
                    }
                }
                //if we have reached the end of a row, update the column value
                if (x == getRows() - 1) {
                    x = 0;
                    y++;
                    //else update the row value
                } else {
                    x++;
                }
            }
            //decrement the loop counter
            r--;
            //loop for the amount of times required to show movement of the x in the grid
        } while (r > 0);
    }

    //Method 2: Create a method arrayGrid().
    /*It will use String[][] xPosition to keep track of the current position. Position [0][0] of the array should hold the initial position of the X.
    Loop through the above array and print out "[ ]" in every cell except the first one, which will have "[ x ]".
    After the full grid is printed, update the position of x from the grid to the next spot over and replace the previous cell with null.
    Now loop this whole process n * m times.  ie.  a 3x4 array would be 12 iterations of this (minus the 1 you just did)*/
    public void arrayGrid() {
        //set sentinel variables
        int r = (getColumns() * getRows());
        boolean foundX = false;
        //beginning of loops
        //create 2d Array to hold position
        String[][] xPosition = new String[getRows()][getColumns()];
        //set x at first position in array
        xPosition[0][0] = "[X]";
        //fill the rest of the array with empty boxes
        for (int i = 0; i < getRows(); i++) {
            for (int j = 1; j < getColumns(); j++) {
                xPosition[i][j] = "[ ]";
            }
        }
        do {
            //print the grid from the array
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getColumns(); j++) {
                    //case for newline
                    if (j == getColumns() - 1) {
                        System.out.print(xPosition[i][j] + "\n");
                    } else {
                        System.out.print(xPosition[i][j] + " ");
                    }
                }
            }
            //check the array for the X
            while (foundX == false) {
                for (int s = 0; s < getRows(); s++) {
                    for (int t = 0; t < getColumns(); t++) {
                        //when found, move it forward one element
                        if (xPosition[s][t] == "[X]") {
                            foundX = true;
                            xPosition[s][t + 1] = "[X]";
                            xPosition[s][t] = "[ ]";
                        }
                    }
                }
            }
            //decrement the loop counter
            r--;
            foundX = false;
            //loop for the amount of times required to show movement of the x in the grid
        } while (r > 0);
    }

    public void runFor(){
        forLoopGrid();
    }

    public void runArray(){
        arrayGrid();
    }
}