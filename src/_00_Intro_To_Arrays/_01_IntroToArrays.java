package _00_Intro_To_Arrays;

import java.util.Random;

public class _01_IntroToArrays {
    public static void main(String[] args) {
        // 1. declare and Initialize an array 5 Strings
        String[] stringArray = new String[5];
        stringArray[0] = "a";
        stringArray[1] = "b";
        stringArray[2] = "c";
        stringArray[3] = "d";
        stringArray[4] = "e";

        // 2. print the third element in the array
        //System.out.println(stringArray[3]);

        // 3. set the third element to a different value
        stringArray[3] = "2";

        // 4. print the third element again
        //System.out.println(stringArray[3]);

        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = "2" + i;
        }

        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE
        for (int i = 0; i < stringArray.length; i++) {
            //System.out.println(stringArray[i]);
        }

        // 7. make an array of 50 integers
        int[] intArray = new int[50];

        // 8. use a for loop to make every value of the integer array a random
        //    number
        Random randy = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = randy.nextInt(100);
        }

        // 9. without printing the entire array, print only the smallest number
        //    on the array

        int smallest;
        int current;
        smallest = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            current = intArray[i];
            if(smallest>current){
                smallest = current;
            }
            //System.out.println(current);
        }
        System.out.println(smallest);

        // 10 print the entire array to see if step 8 was correct


        // 11. print the largest number in the array.

        int largest;
        int current2;
        largest = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            current2 = intArray[i];
            if(largest<current2){
                largest = current2;
            }
            //System.out.println(current);
        }
        System.out.println(largest);
        // 12. print only the last element in the array

        System.out.println(intArray[intArray.length-1]);

    }
}
