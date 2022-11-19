package _03_Intro_to_2D_Arrays;

/*
 *  A 2D array is comparable to a matrix/grid ordered by rows and columns.
 *  A 2D array that holds 3, 1D arrays with each 1D array having 3 elements
 *  can be thought of a 3x3 matrix/grid:
 *                 col0 col1 col2
 *                  \/   \/   \/
 *          row 0  { 1,  2,  3 }
 *          row 1  { 4,  5,  6 }
 *          row 2  { 7,  8,  9 }
 *
 *  Where row 0 contains the numbers 1, 2, 3.
 *  and column 0 contains the numbers 1, 4, 7.
 *
 *  Java stores a 2D array in 'row-major order', meaning the row number is
 *  the first number in the square brackets. The row 0 elements are:
 *
 *  Row 0 = matrix[0][0], matrix[0][1], matrix[0][2]    // 1, 2, 3
 *
 *  The second number in the square brackets is the column number.
 *  The column 0 elements are:
 *
 *  Column 0 = matrix[0][0], matrix[1][0], matrix[2][0] // 1, 4, 7
 */
public class _02_2DArrayPractice {
    public static void main(String[] args) {
        _02_2DArrayPractice practice = new _02_2DArrayPractice();
        practice.test1();
        practice.test2();
        practice.test3();
        practice.test4();
        practice.test5();
        practice.test6();
        practice.test7();
    }

    /*
     * Return a 2D array that can accommodate the grid of values below:
     *          0, 1, 2
     *          3, 4, 5
     *          6, 7, 8
     */
    public Integer[][] test1() {
        Integer[][] intarray2d = {{0, 1, 2},
                {3, 4, 5},
                {6, 7, 8,}};
        for (int i = 0; i < intarray2d.length; i++) {
            for (int j = 0; j < intarray2d[i].length; j++) {
                System.out.print(intarray2d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return intarray2d;
    }

    /*
     * Return a 2D array that can accommodate the grid of values below:
     *          "a", "b", "c", "d",
     *          "e", "f", "g", "e"
     */
    public String[][] test2() {
        String[][] stringarray2d = {{"a", "b", "c", "d"},
                {"e", "f", "g", "e",}};
        for (int i = 0; i < stringarray2d.length; i++) {
            for (int j = 0; j < stringarray2d[i].length; j++) {
                System.out.print(stringarray2d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return stringarray2d;
    }

    /*
     * Return a 2D array that can accommodate the grid of values below:
     *          true, false,
     *          false, false,
     *          false, true,
     *          true, true,
     *          true, false
     */
    public Boolean[][] test3() {
        Boolean[][] booleanarray2d = {{true, false},
                {false, false},
                {false, true},
                {true, true},
                {true, false}};
        return booleanarray2d;
    }

    /*
     * Draw the grid of values for the following 2D array of ints:
     * Assume all the elements in the 2D array are initialized to ran
     * dom ints
     *
     * int[][] grid = new int[2][3];
     *
     *
     *
     * Show your teacher the grid you created
     */

    /*
     * Draw the grid of values for the following 2D array of Robots
     * Assume all the elements in the 2D array are initialized.
     *
     * Robot[][] robots = new Robot[4][2];
     *
     *
     *
     * Show your teacher the grid you created
     */

    /* Given the array of Objects below, return the element that is not null
     *          null, null, null, null
     *          null, null, null, Object
     */
    public Object test4() {
        Object[][] objects = {{null, null, null, null}, {null, null, null, new Object()}};
        return objects[1][3];
    }

    /* Given the array of Objects below, return the element that is not null
     *          null, null, Object, null
     *          null, null, null, null
     */
    public Object test5() {
        Object[][] objects = {{null, null, new Object(), null}, {null, null, null, null}};
        return objects[0][2];
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * first row (row 0)
     */
    public Integer test6() {
        int sum = 0;
        int[][] nums = {{8, 7, 6, 5}, {4, 3}, {2, 1, 0}};
        int[] row1 = nums[0];
        for (int i = 0; i < row1.length; i++) {
            sum += row1[i];
        }
        System.out.println(sum);
        return sum;
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * first column (column 0)
     */
    public Integer test7() {
        int[][] nums = {{8, 7, 6, 5}, {4, 3}, {2, 1, 0}};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i][0];
        }
        System.out.println(sum);
        return sum;
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * specified row
     */
    public Integer getSumByRow(int[][] matrix, int row) {
        int sum = 0;
        int[] chosenrow = matrix[row];
        for (int i = 0; i < chosenrow.length; i++) {
            sum += chosenrow[i];
        }
        System.out.println(sum);
        return sum;
    }

    /*
     * Write an algorithm to return the sum of all the numbers in the
     * specified column
     */
    public Integer getSumByColumn(int[][] matrix, int col) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][col];
        }
        System.out.println(sum);
        return sum;
    }

    /*
     * Return the value of the element adjacent to the specified row and column
     * The directions East, West, North, South are relative to the 2D array
     * matrix/grid. For example in this 3x3 2D array:
     *
     *          [1][2][3]
     *          [4][5][6]
     *          [7][8][9]
     *
     * for the 5 in the middle (row = 1, column = 1), then
     * East neighbor = 6
     * West neighbor = 4
     * North neighbor = 2
     * South neighbor = 8
     *
     * 1. Assume input row and column values are valid indexes in the matrix.
     * 2. If the neighbor does not exist, i.e. it's outside the grid
     *    boundaries, return null.
     */
    public Integer getEastNeighbor(int[][] matrix, int row, int col) {

        return null;
    }

    public Integer getWestNeighbor(int[][] matrix, int row, int col) {

        return null;
    }

    public Integer getNorthNeighbor(int[][] matrix, int row, int col) {

        return null;
    }

    public Integer getSouthNeighbor(int[][] matrix, int row, int col) {

        return null;
    }
}
