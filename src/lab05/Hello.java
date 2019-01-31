/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Jan 30, 2019
* Time: 1:22:04 PM
*
* Project: csci205
* Package: lab05
* File: Hello
* Description:
*
* ****************************************
 */
package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple program to aid in understanding NetBeans
 *
 * @author Mitch Gavars
 * @version 0.1
 */
public class Hello {

    private static final int NUM_INTS = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Hello. What is your name? ");
        String name = in.next();
        System.out.println(name + ", becoming a good programmer takes practice");

        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i < NUM_INTS; i++) {
            x[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(x));
    }

}
