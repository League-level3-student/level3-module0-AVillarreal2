/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

import java.util.Objects;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the [col, row] coordinate position of the
        // head (letter 'c') of the wrong way cow!

        //how to find the wrong way cow:
        //1. go through all of the characters, check if it is "c"
        //2. if it is, look at all of the different sides of where the "o" is
        //3. add it to a list of which if the first two are the same keep looking until there is a different one,
        // and if there is already a different one just give the location of that one.

        // NW N NE     [i-1][j-1]  [i-1][j]  [i-1][j+1]
        // W  c  E  =  [i][j-1]     [i][j]     [i][j+1]
        // SW S SE     [i+1][j-1]  [i+1][j]  [i+1][j+1]

        int cx1 = 0;
        int cy1 = 0;
        int ox1 = 0;
        int oy1 = 0;

        int cx2 = 0;
        int cy2 = 0;
        int ox2 = 0;
        int oy2 = 0;

        //

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (Objects.equals(field[i][j], "c")) { //checks if [i][j] is c
                    for (int k = -1; k < 1; k++) {
                        for (int l = -1; l < 1; l++) {
                            if (Objects.equals(field[i + k][j + l], "o")) { //runs through a 3x3 around the c
                                ox1 = cx1 + k;
                                oy1 = cy1 + l;
                            }
                        }
//                    if(Objects.equals(field[i-1][j], "o")) { //if it is, checks if o is N
//                        ox1 = cx1-1;
//                        oy1 = cy1;
//                    }else if(Objects.equals(field[i-1][j-1], "o")) { //if it is, checks if o is NW
//                        ox1 = cx1-1;
//                        oy1 = cy1-1;
//                    }else if(Objects.equals(field[i-1][j+1], "o")) { //if it is, checks if o is NE
//                        ox1 = cx1-1;
//                        oy1 = cy1+1;
//                    }else if(Objects.equals(field[i][j-1], "o")) { //if it is, checks if o is W
//                        ox1 = cx1;
//                        oy1 = cy1-1;
//                    }else if(Objects.equals(field[i][j+1], "o")) { //if it is, checks if o is E
//                        ox1 = cx1;
//                        oy1 = cy1+1;
//                    }else if(Objects.equals(field[i+1][j-1], "o")) { //if it is, checks if o is SW
//                        ox1 = cx1+1;
//                        oy1 = cy1-1;
//                    }else if(Objects.equals(field[i+1][j], "o")) { //if it is, checks if o is S
//                        ox1 = cx1+1;
//                        oy1 = cy1;
//                    }else if(Objects.equals(field[i+1][j+1], "o")) { //if it is, checks if o is SE
//                        ox1 = cx1+1;
//                        oy1 = cy1+1;
//                    }
                    }
                }
            }
        }
        return new int[]{cx2, cy2}; //actually return something
    }
}