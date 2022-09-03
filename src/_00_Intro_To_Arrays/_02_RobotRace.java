package _00_Intro_To_Arrays;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
    // 1. make a main method
    public static void main(String[] args) {

        // 2. create an array of 5 robots.
        Robot[] robotArray = new Robot[100];

        // 3. use a for loop to initialize the robots.
        for (int i = 0; i < robotArray.length; i++) {
            robotArray[i] = new Robot();
        }

        // 4. make each robot start at the bottom of the screen, side by side, facing up
        for (int i = 0; i < robotArray.length; i++) {
            robotArray[i].setX(i*10+50);
            robotArray[i].setY(550);
            robotArray[i].setSpeed(10);
        }

        // 5. use another for loop to iterate through the array and make each robot move
        // a random amount less than 50.
        // 6. use a while loop to repeat step 5 until a robot has reached the top of the
        // screen.
        Random randy = new Random();
        boolean raceCompleted = false;
        int winner = 0;

        while(!raceCompleted){
            for (int i = 0; i < robotArray.length; i++) {
                robotArray[i].move(randy.nextInt(50));
                if(robotArray[i].getY()<55){
                    raceCompleted=true;
                    winner = i;
                }
            }
        }

        // 7. declare that robot the winner and throw it a party!
        robotArray[winner].sparkle();

        // 8. try different races with different amounts of robots.

        // 9. make the robots race around a circular track.

    }
}
