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
* Description: Testing Java's Gaussian RNG
*
* *****************************************/

package lab04; 
import java.lang.Math;
import java.util.Random;


/**
 * The TestGaussian class is used to calculate the standard   
 * deviation in two different ways
 */
public class TestGaussian {

    // Class constant
    static final int MAX_NUMS = 5000000;


	/**
	 * Calculate stdev using the classic way
	 *
	 * @param nums[] An array of Gaussian distributed values
	 * @return The standard deviation of the values
	 */
	public static double calcStDev(double nums[]) {
	    double mean = 0.0;	   
	    double stDev = 0.0; 
	    double meansSquared = 0.0;

	    for (int i = 0; i < nums.length; i++) {
		mean += nums[i];
	    }

	    mean = mean / nums.length;

	    for (int i = 0; i < nums.length; i++) {
		meansSquared += Math.pow(nums[i] - mean, 2);
	    }

	    stDev = Math.sqrt(meansSquared / nums.length);
	    return stDev;

	}


	/**
	 * Calculate stdev using the alternate way
	 *
	 * @param nums[] An array of Gaussian distributed values
	 * @return The standard deviation of the values
	 */
	public static double calcAltStDev(double nums[]) {
	    double mean = 0.0;	   
	    double stDev = 0.0; 
	    double sumsSquared = 0.0;

	    for (int i = 0; i < nums.length; i++) {
		mean += nums[i];
		sumsSquared += nums[i]*nums[i];
	    }

	    mean = mean / nums.length;
	    stDev = Math.sqrt(sumsSquared / nums.length);
	    return stDev;
	}

	public static void main(String[] args) {
	    Random rand = new Random();
	    double[] nums = new double[MAX_NUMS];
	    for (int i = 0; i < MAX_NUMS; i++) {
		nums[i] = rand.nextGaussian();
	    }

	    System.out.println("Generating 5,000,000 numbers...");

	    long startTime = System.nanoTime();
	    System.out.printf("sd: %f\n", calcStDev(nums));
	    long estimatedTime = System.nanoTime() - startTime;
	    double estimatedTimeInNs = (System.nanoTime() - startTime)/1000.0;
	    System.out.printf("TIME: %f usec\n", estimatedTimeInNs);

	    long startTime2 = System.nanoTime();
	    System.out.printf("alt_sd: %f\n", calcAltStDev(nums));
	    long estimatedTime2 = System.nanoTime() - startTime2;
	    double estimatedTime2InNs = (System.nanoTime() - startTime2)/1000.0;
	    System.out.printf("TIME: %f usec\n", estimatedTime2InNs);

	    double percentTimeDifference = ( estimatedTime2InNs / estimatedTimeInNs ) * 100;
	    System.out.printf("alt_sd computed in %.2f%% of the time of sd\n", percentTimeDifference);
	}

}
