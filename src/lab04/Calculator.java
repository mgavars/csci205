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
* Description: A custom made calculator using switches
*
* *****************************************/

package lab04;

import java.util.Scanner;
import java.lang.Math;

/**
 * The Calculator class is used to mimic a calculator's basic operations
 *
 */
public class Calculator {
	public static void main(String[] args) {
	    Scanner read = new Scanner(System.in);
	    System.out.println("Welcome to the Calculator!");
	    System.out.println("Enter expressions with two numeric operands and a single operator from +, -, *, /, %, or ^");

	    while (true) {
		    System.out.print("Enter a simple arithmetic expression with spacing: ");
		    boolean pass = true;

		    double operand1 = 0.0;
		    if (read.hasNextDouble()) {
			operand1 = read.nextDouble();
		    }
		    else {
			System.out.println("ERROR: Cannot parse operand 1.");
			pass = false;
		    }
		    

		    String operator = read.next();

		    double operand2 = 0.0;
		    if (read.hasNextDouble()) {
			operand2 = read.nextDouble();
		    }
		    else {
			System.out.println("ERROR: Cannot parse operand 2.");
			pass = false;
		    }

		    double answer = 0.0;
			

		    if (pass == true) {
			    switch (operator){
				case "+":
				    answer = operand1 + operand2;
				    System.out.printf("The sum is %f\n", answer);
				    break;
				case "-":
				    answer = operand1 - operand2;
				    System.out.printf("The difference is %f\n", answer);
				    break;
				case "*":
				    answer = operand1 * operand2;
				    System.out.printf("The product is %f\n", answer);
				    break;
				case "/":
				    answer = operand1 / operand2;
				    System.out.printf("The quotient is %f\n", answer);
				    break;
				case "%":
				    answer = operand1 % operand2;
				    System.out.printf("The remainder is %f\n", answer);
				    break;
				case "^":
				    answer = Math.pow(operand1, operand2);
				    System.out.printf("The power is %f\n", answer);
				    break;
				default:
				    System.out.printf("ERROR: %s is not a valid operator.", operator);
				    break;
			    }
		    }
		    
		    System.out.print("Try Again? [y | n] ");
		    if (read.next().equalsIgnoreCase("n")) {
			System.out.println("Goodbye!");
			break;	
		    }

	    }
	}
}
