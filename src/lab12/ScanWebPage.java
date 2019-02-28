/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 25, 2019
* Time: 1:32:10 PM
*
* Project: csci205
* Package: lab12
* File: ScanWebPage
* Description:
*
* ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 *
 * @author mag051
 */
public class ScanWebPage {

    public static BufferedInputStream inBuf;

    public static boolean flag = true;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        String address;

        while (flag) {

            System.out.print("Please enter a url to scan: ");
            address = scan.next();
            scanURL(address);

        }
        System.out.print(
                "Connection established. What tag do you want to scan for? ");
        String tag = scan.next();
        System.out.print("Enter the file name to store the results: ");
        String filename = scan.next();

        Pattern p1 = Pattern.compile("<(\\w+)\\s+\\w+=\"[^\"]+\">");
        Pattern p2 = Pattern.compile("<(\\w+)>");

        PrintWriter out = new PrintWriter(filename);
        String sMatch;

        Scanner buff = new Scanner(inBuf);

        int tagCount = 0;
        while ((sMatch = buff.findWithinHorizon(p1, 0)) != null) {
            MatchResult match = buff.match();
            if (match.group(1).equals(tag)) {
                out.println(sMatch);
                tagCount += 1;
            }
        }

        System.out.println(
                "Wrote " + tagCount + " <" + tag + "> tags to " + filename);
        System.out.println("Goodbye!");
        buff.close();
        inBuf.close();
        scan.close();
        out.close();

    }

    public static void scanURL(String address) {
        try {
            URL locator = new URL(address);
            inBuf = new BufferedInputStream(locator.openStream());
            flag = false;
            /*
            HttpURLConnection huc = (HttpURLConnection) locator.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            OutputStream os = huc.getOutputStream();
            int code = huc.getResponseCode();
            if (code != 200) {
                System.out.println(
                        "Could not find resource on host. Please try again");
                flag = true;
            }
             */

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL! Please try again.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL syntax. Please try again.");

        } catch (IOException e) {
            System.out.println(
                    "Valid URL but host does not exist. Please try again.");
        }
    }

}
