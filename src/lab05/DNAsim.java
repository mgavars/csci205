/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Jan 31, 2019
* Time: 6:59:03 PM
*
* Project: csci205
* Package: lab05
* File: DNAsim
* Description:
*
* ****************************************
 */
package lab05;

import static java.lang.Integer.parseInt;
import java.util.Random;
import java.util.Scanner;

/**
 * A class to design arrays of DNA
 *
 * @author mag051
 */
public class DNAsim {

    /**
     * Welcomes user and asks for input on the DNA arrays.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello. Welcome to the DNA Simulator");
        System.out.print(
                "Enter length of a DNA Sequence to be simulated (integer): ");
        int length = parseInt(in.next());

        System.out.print("Enter GC-content desired as a percent (without %): ");
        double gcContentPct = parseInt(in.next());

        printDNAStats(generateDNA(length, gcContentPct));
        printLongestRepeat(generateDNA(length, gcContentPct));

    }

    /**
     * Generates an array of characters: G, C, A, or T
     *
     * @param length The desired length of the array
     * @param gcContentPct The requested percent of G's and C's to be in the
     * array
     */
    public static char[] generateDNA(int length, double gcContentPct) {
        Random rand = new Random();
        int x;
        double gBound = gcContentPct / 2;
        double cBound = gcContentPct;
        double aBound = gcContentPct + (100.0 - gcContentPct) / 2;

        char[] dna = new char[length];
        for (int i = 0; i < length; i++) {
            x = rand.nextInt(100);
            if (x <= gBound) {
                dna[i] = 'G';
            }
            else if (x > gBound && x <= cBound) {
                dna[i] = 'C';
            }
            else if (x > cBound && x <= aBound) {
                dna[i] = 'A';
            }
            else {
                dna[i] = 'T';
            }

        }
        return dna;
    }

    /**
     * Prints the number of times each character is found in the array
     *
     * @param dna An array of G, C, A , or T characters
     */
    public static void printDNAStats(char[] dna) {
        int totalCount = 0;
        int gCount = 0;
        int cCount = 0;
        int aCount = 0;
        int tCount = 0;

        for (int i = 0; i < dna.length; i++) {
            switch (dna[i]) {
                case 'G':
                    gCount += 1;
                    break;
                case 'C':
                    cCount += 1;
                    break;
                case 'A':
                    aCount += 1;
                    break;
                default:
                    tCount += 1;
                    break;
            }
            totalCount += 1;
        }
        double gPct = (double) gCount / totalCount;
        double aPct = (double) aCount / totalCount;
        double cPct = (double) cCount / totalCount;
        double tPct = (double) tCount / totalCount;

        System.out.printf("A: %d (%.2f)\n", aCount, aPct * 100.0);
        System.out.printf("C: %d (%.2f)\n", cCount, cPct * 100.0);
        System.out.printf("G: %d (%.2f)\n", gCount, gPct * 100.0);
        System.out.printf("T: %d (%.2f)\n", tCount, tPct * 100.0);

    }

    /**
     * Prints the index, character, and count of the longest repeat found in an
     * array of characters G, C, A, or T
     *
     * @param dna An array of G, C, A, and T characters
     */
    public static void printLongestRepeat(char[] dna) {
        int longestRepeat = 0;
        int index = 0;
        int curCount;
        char longestChar = 'A';

        for (int i = 0; i < dna.length; i++) {
            curCount = 1;
            for (int j = i + 1; j < dna.length; j++) {
                if (dna[i] != dna[j]) {
                    break;
                }
                curCount += 1;
            }
            if (curCount > longestRepeat) {
                longestRepeat = curCount;
                index = i;
                longestChar = dna[i];
            }
        }

        System.out.printf("Longest repeated nucleotide: %d %c's [index: %d]\n",
                          longestRepeat, longestChar, index);
    }

}
