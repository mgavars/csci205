/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
* Instructor: Prof. Dancy
* Section: 1pm
*
* Name: Mitch Gavars
* Date: 01/15/2019
*
* Lab / Assignment: Lab01 "Hello, CSCI 205!"
*
* Description: Begin learning how to use the Java programming language.
*		A "Hello World" program in Java. 
*
* *****************************************/
package lab01;

public class Hello
{
	public static void main( String[] args )
		{
		long startTime = System.nanoTime();
		System.out.println("Programming is not a spectator sport!");
		long estimatedTime = System.nanoTime() - startTime;
		double estimatedTimeInMs = (System.nanoTime() - startTime)/1000000.0;
		System.out.println("Time to execute: "+ estimatedTimeInMs + " ms");

		System.exit(0);
		}
}
