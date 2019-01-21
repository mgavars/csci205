/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2019
 *
 * Name: Mitch Gavars
 * Date: 01/16/2019
 *
 * Lab: Lab02, Exercise 4
 *
 *
 * Description:
 * A simple program to ask the user for a temperature in Celsius, and converts
 * it to Fahrenheit.
 * *****************************************
 */

package lab02;
import java.util.Scanner;
import java.lang.Math;

public class Sphere
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the radius of a sphere: ");
		int sphereRadius = in.nextInt();
		
		double sphereVolume = 4.0 / 3 * Math.PI * Math.pow(sphereRadius, 3);

		long sphereVolumeRound = Math.round(sphereVolume);

		System.out.printf("The volume is: %.2f\n", sphereVolume);
		System.out.println("Rounded to the nearest integer: " + sphereVolumeRound);

	}
}
