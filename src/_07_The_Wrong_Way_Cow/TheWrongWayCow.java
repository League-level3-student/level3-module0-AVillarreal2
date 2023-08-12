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

import java.util.ArrayList;
import java.util.List;
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

        // NW(1) N(2) NE(3)     [i-1][j-1]  [i-1][j]  [i-1][j+1]
        // W  c  E  =  [i][j-1]     [i][j]     [i][j+1]
        // SW S  SE    [i+1][j-1]  [i+1][j]  [i+1][j+1]

//        int cx1 = 0;
//        int cy1 = 0;
//        int ox1 = 0;
//        int oy1 = 0;
//
//        int cx2 = 0;
//        int cy2 = 0;
//        int ox2 = 0;
//        int oy2 = 0;

//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                if (Objects.equals(field[i][j], "c")) { //checks if [i][j] is c
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
//                    }
//                }
//            }
//        }
//
//        //go through list, and then return the one cow
//
//        int directionN = 0, directionW = 0, directionE = 0, directionS = 0;
//
//        List<Integer> xes = new ArrayList<Integer>();
//        List<Integer> yes = new ArrayList<Integer>();
//        List<String> direction = new ArrayList<String>(); //direction defined from left->right up->down 1-9
//
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) { //go through field
//                if (Objects.equals((field[i][j]), 'c')) { //check if character is c
//                    if(i>0) {
//                        for (int k = -1; k < 1; k++) {
//                            if(j>0) {
//                                for (int l = -1; l < 1; l++) { //go through 3x3 around c
//                                    if (Objects.equals(field[i + k][j + l], 'o')) { //check if character is o
//                                        xes.add(i);
//                                        yes.add(j); //add x and y of the c position to a list
//
//                                        //check the cardinal directions but make sure it doesnt go out of bounds
//
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; direction.size() > i; i++) {
//            if (direction.get(i).equals("North")) {
//                directionN++;
//            }
//            if (direction.get(i).equals("West")) {
//                directionW++;
//            }
//            if (direction.get(i).equals("East")) {
//                directionE++;
//            }
//            if (direction.get(i).equals("South")) {
//                directionS++;
//            }
//        }
//        System.out.println("N:" + directionN);
//        System.out.println("W:" + directionW);
//        System.out.println("E:" + directionE);
//        System.out.println("S:" + directionS);
//
//        if (directionN == 1) {
//            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
//                if (direction.get(i).equals("North")) { //check if the direction i is the same one as the direction counted once
//                    return new int[]{xes.get(i), yes.get(i)};
//                }
//            }
//        } else if (directionW == 1) {
//            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
//                if (direction.get(i).equals("West")) { //check if the direction i is the same one as the direction counted once
//                    return new int[]{xes.get(i), yes.get(i)};
//                }
//            }
//        } else if (directionE == 1) {
//            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
//                if (direction.get(i).equals("East")) { //check if the direction i is the same one as the direction counted once
//                    return new int[]{xes.get(i), yes.get(i)};
//                }
//            }
//        } else if (directionS == 1) {
//            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
//                if (direction.get(i).equals("South")) { //check if the direction i is the same one as the direction counted once
//                    return new int[]{xes.get(i), yes.get(i)};
//                }
//            }
//        }
//
//        return null; //actually return something
//        // return new int[]{xes.get(i), yes.get(i)}; //return the x and y values that SHOULD be the same i as the direction only counted once
//    }
//
//
//    int checkDirectionIfOne(int directionasd, List<Integer> dirlist, List<Integer> xes, List<Integer> yes) { //put void for now
//        if (directionasd == 1) {
//            for (int i = 0; i < dirlist.size(); i++) { //if it has, then go through the direction list
//                if (dirlist.get(i) == directionasd) { //check if the direction i is the same one as the direction counted once
//                    return i;
//                }
//            }
//        }
//        return 0;
//    }
//
//    //        if(direction1==1){ //checks if the specified direction has only been counted once
//    //            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
//    //                if (direction.get(i)==direction1){ //check if the direction i is the same one as the direction counted once
//    //                    return new int[]{xes.get(i), yes.get(i)}; //return the x and y values that SHOULD be the same i as the direction only counted once
//    //                }
//    //            }
//    //        }

        // Fill in the code to return the [col, row] coordinate position of the
        // head (letter 'c') of the wrong way cow!

        int[] result = checkFinalColumn(field);
        if (result != null) {
            return result;
        }
        result = checkIfOfollowsC(field);
        if (result != null) {
            return result;
        }
        return null;
    }

    private static int[] checkFinalColumn(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            int col = field[row].length - 1;
            char current = field[row][col];
            if (current == 'c') return new int[]{col, row};
        }
        return null;
    }

    private static int[] checkIfOfollowsC(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field[row].length; column++) {
                char current = field[row][column];
                if(current == 'c'){
                    if(field[row][column-1] == 'o') return new int[]{column, row};
                }
            }
        }
        return null;
    }
}

