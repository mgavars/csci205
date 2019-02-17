/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 17, 2019
* Time: 3:24:56 PM
*
* Project: csci205
* Package: lab10
* File: EmployeeTest
* Description:
*
* ****************************************
 */
package lab10;

import java.text.ParseException;
import junit.framework.TestCase;

/**
 *
 * @author mag051
 */
public class EmployeeTest extends TestCase {

    private Employee emp;

    public EmployeeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        emp = new Employee(0, "Kevin", "Door", 555555555,
                           Employee.strToDate("2002-04-02"),
                           60000);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        emp = null;
    }

    /**
     * Test of changeName method, of class Employee.
     */
    public void testChangeName() {
        System.out.println("changeName");

        Employee instance = emp;
        String first = "John";
        String last = "Andrews";
        instance.changeName(first, last);

        String expResult = "John Andrews";
        String result = instance.getFirstName() + " " + instance.getLastName();
        assertEquals(expResult, result);

    }

    /**
     * Test of raiseSalary method, of class Employee.
     */
    public void testRaiseSalary() {
        System.out.println("raiseSalary");

        double salaryAdj = 10000.0;
        Employee instance = emp;
        double expResult = instance.getSalary() + salaryAdj;
        double result = instance.raiseSalary(salaryAdj);

        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class Employee.
     */
    public void testEquals() throws ParseException {
        System.out.println("equals");
        Object obj = new Employee(200, "Megan", "Rock", 666666666,
                                  Employee.strToDate("2007-05-20"),
                                  60000);
        Employee instance = emp;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
