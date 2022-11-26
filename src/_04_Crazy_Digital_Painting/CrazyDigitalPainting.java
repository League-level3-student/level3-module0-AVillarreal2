package _04_Crazy_Digital_Painting;

import javax.swing.*;
import java.awt.*;

public class CrazyDigitalPainting {
    // 1. Create two final static integers for the width and height of the display.
    final static int screenWidth = 100;
    final static int screenHeight = 100;

    // 2. Create a 2D array of Color objects. You will need to import
    //    java.awt.Color. Initialize the size of the array using the 
    //    integers created in step 1.

    Color[][] color2DArray = new Color[screenWidth][screenHeight];

    public CrazyDigitalPainting() {
        // 3. Open the crazy_digital_painting.png file and look at the image.
        // 4. Iterate through the 2D array and initialize each Color object
        //    to a new color. The sample image was created using the following 
        //    pattern:
        //    colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
        for (int i = 0; i < color2DArray.length; i++) {
            for (int j = 0; j < color2DArray[i].length; j++) {
                //color2DArray[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
            }
        }

        // 5. Come up with your own pattern to make a cool crazy image.
        for (int i = 0; i < color2DArray.length; i++) {
            for (int j = 0; j < color2DArray[i].length; j++) {
                color2DArray[i][j] = new Color(i % 128, (i * j) % 256, j % 128);
            }
        }

        // 6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
        //    to show off your picture.
        ColorArrayDisplayer.displayColorsAsImage(color2DArray);
        JOptionPane.showMessageDialog(null, "");
    }

    public static void main(String[] args) {
        new CrazyDigitalPainting();
    }
}
