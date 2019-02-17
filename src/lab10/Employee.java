/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2019
 *
 * TODO - Enter the details below!
 * Name: Mitch Gavars
 * Date: 02/15/2019
 * Time: 1:20 pm
 *
 * Project: csci205
 * Package: lab10
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab10;

/**
 * A basic representation for an Employee.
 *
 * @author Brian King, Chris Dancy
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
public class Employee {

    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;

    private static HashSet<Integer> setOfIDs = new HashSet<Integer>();

    /**
     * Explicit construct to create new employee
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum,
                    Date hireDate, double salary) {
        if (setOfIDs.contains(empID) || empID <= 0) {
            this.empID = generateID();
        }
        else {
            this.empID = empID;
        }
        setOfIDs.add(this.empID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    private static Integer generateID() {
        if (setOfIDs.isEmpty()) {
            return (Integer) 1;
        }
        else {
            for (int i = 1; i < setOfIDs.size() + 1; i++) {
                if (!setOfIDs.contains(i)) {
                    return (Integer) i;
                }

            }
        }
        return (Integer) setOfIDs.size() + 1;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }

    /**
     * Helper method to parse a date string into a date object. This is really
     * here just to show how to deal with an exception that may be thrown in a
     * method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormat.parse(sDate);
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.ssNum != other.ssNum) {
            return false;
        }
        return true;
    }

    public static String dateToStr(Date date) {
        return empDateFormat.format(date);
    }

}
