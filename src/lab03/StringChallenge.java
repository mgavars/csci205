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
* Description: String Challenge
*
*
* *****************************************/
package lab03;

/**
 * The StringChallenge class is used to evaluate several different string
 * exercises from lab03.
 *
 * @author brk009
 */
public class StringChallenge {

    /**
     * Count the number of vowels in a string.
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowels(String s) {
        // TODO - Finish this method!
	int vowelCount = 0;
	for(int i = 0; i < s.length(); i++) {
		// Check whether each letter is a vowel or not, incrementing vowelCount if it is
		if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
			vowelCount += 1;		
		}
	}
        return vowelCount;
    }

    /**
     * Count the number of vowels in a string. This method uses recursion
     *
     * @param s The string to test
     * @return The number of vowels in <code>s</code>
     */
    public static int countVowelsRec(String s) {
        // TODO - Finish this method!
	if (s.isEmpty()) {
		return 0;
	}
	
	else if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u') {
		return 1 + countVowelsRec(s.substring(1));
	}
	
	else {
		return countVowelsRec(s.substring(1));
	}
    }

    /**
     * Determine whether the string is a palindrome or not using recursion
     *
     * @param s The string to test
     * @return True or False
     */
    public static boolean isPalindrome(String s) {
	
	// Base Case: if string is empty or only 1 letter remaining
    	if (s.isEmpty() || s.length() == 1) {
	   return true; 
	}
	
	// If char at beginning and end are the same, call the recursive function of the string from 1 to length()-1
	else if (s.charAt(0) == s.charAt(s.length()-1)) {
	   return isPalindrome(s.substring(1, s.length() - 1));
	}
	
	else {
	   return false;
	}
    }

    /**
     * Swap the first and last characters of a string, if and only if the first and last characters are letters
     *
     * @param s The string to have letters swapped
     * @return The swapped string or the original string
     */
    public static String swapLastAndFirstLetter(String s) {
	// Check whether the first and last characters are letters, if not then return original string
	if (!(Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(s.length() -1)))) {
	   return s;
	}
	
	else {
	   // Check if the first letter is uppercase, swapping the letters accordingly
	   if (Character.isUpperCase(s.charAt(0))) {
		return Character.toUpperCase(s.charAt(s.length()-1)) + s.substring(1, s.length()-1) + Character.toLowerCase(s.charAt(0));
	   }
	   else {
		return s.charAt(s.length()-1) + s.substring(1, s.length()-1) + s.charAt(0);
	   }
	}
    }

    /**
     * Remove any occurence of the String sRemove in the String s
     *
     * @param s The string to be edited
     * @param sRemove The string to be look for and removed in String s
     * @return The new, edited string
     */
    public static String withoutString(String s, String sRemove) {
	String withoutString = s.replaceAll(sRemove, "");
	return withoutString;
    }

    /**
     * Sum all numbers in a string; if there is a sequence of digits, they must be converted into one integer
     *
     * @param s The string to be counted
     * @return The total sum
     */
    public static int sumNumbersInString(String s) {
	int totalSum = 0;
	String numberString = "";
	for (int i = 0; i < s.length(); i++) {
	    // If the character is a digit, add the string of it to numberString
	    if (Character.isDigit(s.charAt(i))) {
		numberString += s.charAt(i);
	    }
	
	    // If not, then add a space
	    else {
		numberString += " ";
	    }
	}
	// trim the string to get rid of beginning whitespace
	String trimmed = numberString.trim();

	// Make trimmed into a list of strings
	String [] numValues = trimmed.split(" ");
	for (String a: numValues) {
	    if (a.isEmpty()) {
	 	totalSum += 0;
	    }
	    else {
		totalSum += Integer.parseInt(a);
	    }


	    
	}
	
	
	return totalSum;
    }

    /**
     * Sum all unicode values of all characters in a string
     *
     * @param s The string to be counted
     * @return The total sum
     */
    public static int addUnicodeValues(String s) {
	int totalSum = 0;
	for (int i = 0; i < s.length(); i++) {
	    totalSum += (int)s.charAt(i);
	    
	}
	
	return totalSum;
    }

    /**
     * Main program to test out each String processing method
     */
    public static void main(String[] args) {

        String sTest = "Mississippi River";
        System.out.printf("countVowels(\"%s\") = %d\n", sTest, countVowels(sTest));
        System.out.printf("countVowelsRec(\"%s\") = %d\n", sTest, countVowelsRec(sTest));

        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
        sTest = "amanapanama";
        System.out.printf("isPalindrome(\"%s\") = %b\n", sTest, isPalindrome(sTest));
//
        sTest = "Testing";
        System.out.printf("swapLastAndFirstLetter(\"%s\") = \"%s\"\n", sTest, swapLastAndFirstLetter(sTest));
        sTest = "Testing123";
        System.out.printf("swapLastAndFirstLetter(\"%s\") = \"%s\"\n", sTest, swapLastAndFirstLetter(sTest));
//
        sTest = "Testing Running Walking Jumping";
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "ing", withoutString(sTest, "ing"));
        System.out.printf("withoutString(\"%s\",\"%s\") = \"%s\"\n", sTest, "Sleep", withoutString(sTest, "Sleep"));
//
        sTest = "a1b2c3";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "aa12bb34cc56dd78";
        System.out.printf("sumNumbersInString(\"%s\") = %d\n", sTest, sumNumbersInString(sTest));
        sTest = "a9D>Zc8";
        System.out.printf("addUnicodeValues(\"%s\") = %d\n", sTest, addUnicodeValues(sTest));
    }
}
