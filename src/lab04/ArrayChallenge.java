/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
* Instructor: Prof. Dancy
* Section: 1pm
*
* Name: Mitch Gavars
* Date: 01/28/2019
*
* Lab / Assignment: Lab04 Arrays and Switch
*
* Description: Array Challenges
*
* *****************************************/

package lab04;  
import java.util.Arrays;

/**
 * The ArrayChallenge class is used to evaluate several different array exercises 
 *
 */
public class ArrayChallenge {

	/**
	 * Concatenate two arrays of type double
	 *
	 * @param a1 The starting array
	 * @param a2 The array to concatenate onto a1
	 * @return The concatenated array
	 */
	public static double[] concat(double[] a1, double[] a2) {

	   double[] result = Arrays.copyOf(a1, a1.length + a2.length);

	   for (int i = 0; i < a2.length; i++) {
		result[a1.length + i] = a2[i];
	   }
	
	   return result;	
	}

	/**
	 * Reverse an array using recursion
	 *
	 * @param a The array to be reversed
	 * @return The reversed array
	 */

	public static double[] reverse( double[] a ) {
	   if ( a.length == 1 ) {
		return a;
	   }

	   else {
		double[] lastValue = {a[a.length - 1]};
		return concat(lastValue, reverse(Arrays.copyOf(a, a.length-1)));
	   }
	}


	/**
	 * Sum an array alternating signs
	 * ex: elements 1, 3, 5, 7, 10, 15, 20 would compute: 
	 * 1 – 3 + 5 – 7 + 10 – 15 + 20,
	 *
	 * @param a The array to be summed
	 * @return The final count
	 */
	public static double altSum(double[] a) {
	   double count = 0.0;
	   
	   for (int i = 0; i < a.length; i++) {
		if (i % 2 == 0) {
		   count += a[i];
		}

		else {
		   count -= a[i];
		}
	   }
	   
	   return count;
	}

	/**
	 * Check to see if an array is in increasing order
	 *
	 * @param a The array to be checked
	 * @return If in increasing order, return true, otherwise, 		 *  return false
	 */
	public static boolean isSorted(double[] a) {
	   for (int i = 0; i < a.length - 1; i++) {
		for (int j = i + 1; j < a.length; j++) {
		   if (a[i] > a[j]) {
			return false;
		   }
		}
	   }

	   return true;
	}


	public static void main(String[] args) {
		double[] array1 = { 2, 3, 5, 7, 11 };
		double[] array2 = { 1, 4, 6, 8, 0 };
		System.out.printf("array1: %s\n", Arrays.toString(array1));
		System.out.printf("array2: %s\n", Arrays.toString(array2));
		System.out.printf("concat test: %s\n",
		Arrays.toString(concat(array1,array2)));
		System.out.printf("reverse test: %s\n", Arrays.toString(reverse(array1)));
		System.out.printf("altSum test: %.1f\n",altSum(concat(array1, array2)));
		System.out.printf("sorted test 1: %b\n", isSorted(array1));
		System.out.printf("sorted test 2: %b\n", isSorted(array2));

	}
}

