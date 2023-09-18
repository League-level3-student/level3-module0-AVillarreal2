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

        //go through list, and then return the one cow

        int directionU = 0, directionL = 0, directionR = 0, directionD = 0;

        List<Integer> xes = new ArrayList<Integer>();
        List<Integer> yes = new ArrayList<Integer>();
        List<String> direction = new ArrayList<String>(); //direction defined from left->right up->down 1-9

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) { //going through field
                if (Objects.equals((field[x][y]), 'c')) { //check if character is c
                    if(y > 0) { //if statement to check if out of bounds
                        if(Objects.equals((field[x][y-1]), 'o')) {
                            xes.add(x);
                            yes.add(y);
                            direction.add("Up");
                        }
                    }
                    if(x > 0) {
                        if(Objects.equals((field[x-1][y]), 'o')) {
                            xes.add(x);
                            yes.add(y);
                            direction.add("Left");
                        }
                    }
                    if(x < field.length-1) {
                        if(Objects.equals((field[x+1][y]), 'o')) {
                            xes.add(x);
                            yes.add(y);
                            direction.add("Right");
                        }
                    }
                    if(y < field[x].length-1) {
                        if(Objects.equals((field[x][y+1]), 'o')) {
                            xes.add(x);
                            yes.add(y);
                            direction.add("Down");
                        }
                    }
                }
            }
        }
        for (int i = 0; direction.size() > i; i++) {
            if (direction.get(i).equals("Up")) {
                directionU++;
            }
            if (direction.get(i).equals("Left")) {
                directionL++;
            }
            if (direction.get(i).equals("Right")) {
                directionR++;
            }
            if (direction.get(i).equals("Down")) {
                directionD++;
            }
        }
        System.out.println("Up: " + directionU);
        System.out.println("Left: " + directionL);
        System.out.println("Right: " + directionR);
        System.out.println("Down: " + directionD);

        if (directionU == 1) {
            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
                if (direction.get(i).equals("Up")) { //check if the direction i is the same one as the direction counted once
                    return new int[]{xes.get(i), yes.get(i)};
                }
            }
        } else if (directionL == 1) {
            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
                if (direction.get(i).equals("Left")) { //check if the direction i is the same one as the direction counted once
                    return new int[]{xes.get(i), yes.get(i)};
                }
            }
        } else if (directionR == 1) {
            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
                if (direction.get(i).equals("Right")) { //check if the direction i is the same one as the direction counted once
                    return new int[]{xes.get(i), yes.get(i)};
                }
            }
        } else if (directionD == 1) {
            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
                if (direction.get(i).equals("Down")) { //check if the direction i is the same one as the direction counted once
                    return new int[]{xes.get(i), yes.get(i)};
                }
            }
        }

        return null; //actually return something
        // return new int[]{xes.get(i), yes.get(i)}; //return the x and y values that SHOULD be the same i as the direction only counted once
    }


    int checkDirectionIfOne(int directionasd, List<Integer> dirlist, List<Integer> xes, List<Integer> yes) { //put void for now
        if (directionasd == 1) {
            for (int i = 0; i < dirlist.size(); i++) { //if it has, then go through the direction list
                if (dirlist.get(i) == directionasd) { //check if the direction i is the same one as the direction counted once
                    return i;
                }
            }
        }
        return 0;
    }

    //        if(direction1==1){ //checks if the specified direction has only been counted once
    //            for (int i = 0; i < direction.size(); i++) { //if it has, then go through the direction list
    //                if (direction.get(i)==direction1){ //check if the direction i is the same one as the direction counted once
    //                    return new int[]{xes.get(i), yes.get(i)}; //return the x and y values that SHOULD be the same i as the direction only counted once
    //                }
    //            }
    //        }





//        int[] result = checkFinalColumn(field);
//        if (result != null) {
//            return result;
//        }
//        result = checkIfOfollowsC(field);
//        if (result != null) {
//            return result;
//        }
//        return null;
//    }
//
//    private static int[] checkFinalColumn(char[][] field) {
//        for (int row = 0; row < field.length; row++) {
//            int col = field[row].length - 1;
//            char current = field[row][col];
//            if (current == 'c') return new int[]{col, row};
//        }
//        return null;
//    }
//
//    private static int[] checkIfOfollowsC(char[][] field) {
//        for (int row = 0; row < field.length; row++) {
//            for (int column = 0; column < field[row].length; column++) {
//                char current = field[row][column];
//                if(current == 'c'){
//                    if(field[row][column-1] == 'o') return new int[]{column, row};
//                }
//            }
//        }
//        return null;
//    }
}

