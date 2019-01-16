/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2019
 *
 * Name: Mitch Gavars
 * Date: 01/16/2019
 *
 * Lab: Lab02, Exercise 2
 *
 * @author Brian King, 2012-Fall
 *
 * Description:
 * A simple program to ask the user for a temperature in Celsius, and converts
 * it to Fahrenheit.
 * *****************************************
 */

package lab02;
import java.util.Scanner;

public class CtoF 
{
    public static void main(String[] args) 
    {
	// Create the Scanner object, attached to console input
	Scanner in = new Scanner(System.in);

        // Prompt user for a Celsius temp
	System.out.print("Enter temperature in Celsius: ");

        // Read and store the Celsius temp
	int celsiusTemp = in.nextInt();

        // Convert the temp to Fahrenheit
	double fahTemp = celsiusTemp * 9.0 / 5 + 32;

        // Output the results with correct formatting, one significant digit
	System.out.printf("%d C = %.1f F\n",celsiusTemp, fahTemp);
    }
}
