/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 11, 2019
* Time: 1:07:44 PM
*
* Project: csci205
* Package: lab09
* File: ExceptionExample
* Description:
*
* ****************************************
 */
package lab09;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mag051
 */
public class ExceptionExample {

    public static final int SIZE = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] x = new int[SIZE];
        int i = 0;
        do {
            try {
                System.out.print(
                        "Enter an index to fill, or " + SIZE + " to finish: ");
                i = in.nextInt();
                if (i != SIZE) {
                    x[i] = i;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(i + " is out of range! Try again!");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers! Try again!");
                in.nextLine();
                continue;
            }

        } while (i != SIZE);
    }

}
