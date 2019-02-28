/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 27, 2019
* Time: 4:54:22 PM
*
* Project: csci205
* Package: lab12
* File: ScanWebPageTest
* Description:
*
* ****************************************
 */
package lab12;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import junit.framework.TestCase;
import static lab12.ScanWebPage.inBuf;

/**
 *
 * @author mag051
 */
public class ScanWebPageTest extends TestCase {

    public ScanWebPageTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test Malformed URL.
     */
    public void testMalformedURL() {
        System.out.println("Malformed URL");
        String address = "www.bucknell.edu";
        try {
            URL locator = new URL(address);
            fail("Improper checking for a Malformed URL.");

        } catch (MalformedURLException e) {
        }
    }

    /**
     * Test IllegalArgumentException
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    public void testIllegalArgumentException() throws MalformedURLException, IOException {
        System.out.println("Malformed URL");
        String address = "https:\\www.bucknell.edu";
        try {
            URL locator = new URL(address);
            inBuf = new BufferedInputStream(locator.openStream());
            fail("Improper checking for an Illegal Argument Exception.");

        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test IOException
     */
    public void testIOException() {
        System.out.println("Malformed URL");
        String address = "https://www.bucknell.edu/blah.html";
        try {
            URL locator = new URL(address);
            inBuf = new BufferedInputStream(locator.openStream());
            fail("Improper checking for an IO Exception.");

        } catch (IOException e) {
        }
    }

}
