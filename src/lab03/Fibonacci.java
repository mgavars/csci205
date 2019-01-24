/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
* Instructor: Prof. Dancy
* Section: 1pm
*
* Name: Mitch Gavars
* Date: 01/23/2019
*
* Lab / Assignment: Lab03 Methods, and the String class
*
* Description: Fibonacci Numbers
*
*
* *****************************************/

package lab03;

import java.util.Scanner;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci
 *
 * Date: 2015-fall
 *
 * @author BRK
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
        // TODO - Complete this method
	if (n == 0) {
	   return 0;	
	}

	else if (n == 1) {
	   return 1;	
	}

	else {
	   return recFib(n-1) + recFib(n-2);
	}
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        // TODO - Complete this method

	// Variables: num1 & num2 start at 0,1 because those are the 
	// base cases for fibonacci. Count starts at 1 because Fib(1)=1
	int num1 = 0, num2 = 1, count = 1;

	while (count < n) {

	   int sum = num1 + num2;
	   num1 = num2;
	   num2 = sum;
	   count += 1;
	}

        return num2;
    }

    /**
     * Main program to test both fibonacci methods
     */
    public static void main(String[] args) {
        System.out.println("Request your fibonacci number:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println("Recursive fib: " + recFib(n));
        System.out.println("Non-recursive fib: " + nonRecFib(n));
    }

}
