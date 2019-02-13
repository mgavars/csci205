/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 11, 2019
* Time: 1:50:00 PM
*
* Project: csci205
* Package: lab09
* File: CashRegisterTest
* Description:
*
* ****************************************
 */
package lab09;

import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author mag051
 */
public class CashRegisterTest extends TestCase {

    static final double EPSILON = 1.0E-12;

    private CashRegister instance;

    public CashRegisterTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instance = new CashRegister();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getPurchaseCount method, of class CashRegister.
     */
    public void testGetPurchaseCount() {
        System.out.println("getPurchaseCount");

        // Test the initial state. It should have no items
        assertEquals(0, instance.getPurchaseCount());

        // Now, set up a test of two items
        instance.scanItem(.55);
        instance.scanItem(1.27);
        int expResult = 2;
        int result = instance.getPurchaseCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfPurchases method, of class CashRegister.
     */
    public void testGetListOfPurchases() {
        System.out.println("getListOfPurchases");

        instance.scanItem(.55);
        instance.scanItem(1.27);
        List<Double> expResult = new LinkedList<Double>();
        expResult.add(.55);
        expResult.add(1.27);
        List<Double> result = instance.getListOfPurchases();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTransactionTotal method, of class CashRegister.
     */
    public void testGetTransactionTotal() {
        System.out.println("getTransactionTotal");
        assertEquals(0, instance.getTransactionTotal(), EPSILON);

        // Now, set up a test of two items
        instance.scanItem(1.27);
        instance.scanItem(.55);
        double expResult = 1.82;
        double result = instance.getTransactionTotal();
        assertEquals(expResult, result, EPSILON);

    }

    /**
     * Test of getPaymentCollected method, of class CashRegister.
     */
    public void testGetPaymentCollected() {
        System.out.println("getPaymentCollected");
        assertEquals(0, instance.getPaymentCollected(), EPSILON);

        instance.collectPayment(Money.NICKEL, 5);
        instance.collectPayment(Money.DIME, 1);
        instance.collectPayment(Money.TWENTY, 2);
        double expResult = 40.35;
        double result = instance.getPaymentCollected();
        assertEquals(expResult, result, EPSILON);

    }

    /**
     * Test of collectPayment method, of class CashRegister.
     */
    public void testCollectPaymentException() {
        System.out.println("collectPayment");
        Money moneyType = null;
        int unitCount = 0;

        try {
            instance.collectPayment(moneyType, -1);
            fail("Improper checking for negative count in collectPayment");
        } catch (IllegalArgumentException expected) {
        }
    }

    /**
     * Test of giveChange method, of class CashRegister.
     */
    public void testGiveChange() throws Exception {
        System.out.println("giveChange");
        assertEquals(0, instance.getPaymentCollected(), EPSILON);

        instance.scanItem(1.27);
        instance.scanItem(.55);
        instance.collectPayment(Money.TWENTY, 1);
        double expResult = 18.18;
        double result = instance.giveChange();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of giveChange method, of class CashRegister.
     */
    public void testGiveChangeException() throws Exception {
        System.out.println("giveChange");
        assertEquals(0, instance.getPaymentCollected(), EPSILON);

        instance.scanItem(1.27);
        instance.scanItem(.55);
        instance.scanItem(20.0);
        instance.collectPayment(Money.TWENTY, 1);
        try {
            instance.giveChange();
            fail("Improper checking for giveChange()");
        } catch (ChangeException expected) {
        }
    }

    /**
     * Test for a scanned item to be bad and thrown an IllegalArgumentExpression
     */
    public void testScanItemIllegalArgumentException() {
        boolean wasThrown = false;
        try {
            instance.scanItem(-.5);
            fail("Improper checking for low scanItem()");
        } catch (IllegalArgumentException expected) {
        }
        try {
            // Now, let's scan for a large value
            instance.scanItem(1.0E6);
            fail("Improper checking for high scanItem()");
        } catch (IllegalArgumentException expected) {
        }
    }

}
