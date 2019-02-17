/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 15, 2019
* Time: 1:40:48 PM
*
* Project: csci205
* Package: lab10
* File: HRDBSystem
* Description:
*
* ****************************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author mag051
 */
public class HRDBSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        ArrayList<Employee> mainList = new ArrayList<Employee>();

        Manager mgr1 = new Manager(0, "Keith", "Buffinton", 101010101,
                                   Employee.strToDate("2011-08-20"),
                                   150000, "ENGINEERING");
        Manager mgr2 = new Manager(1, "Mick", "Smyer", 100000000,
                                   Employee.strToDate("2010-08-20"),
                                   120000, "ADMIN");
        mainList.add(new Employee(1, "Brian", "King", 111111111,
                                  Employee.strToDate("2002-05-10"),
                                  60000));
        mainList.add(new Employee(2, "Mitch", "Gavars", 222222222,
                                  Employee.strToDate("2013-04-13"),
                                  60000));
        mainList.add(new Employee(201, "Rachel", "Orange", 333333333,
                                  Employee.strToDate("2010-02-11"),
                                  60000));
        mainList.add(new Employee(4, "Michael", "Brack", 444444444,
                                  Employee.strToDate("2000-06-01"),
                                  60000));
        mainList.add(new Employee(0, "Kevin", "Door", 555555555,
                                  Employee.strToDate("2002-04-02"),
                                  60000));
        mainList.add(new Employee(200, "Megan", "Rock", 666666666,
                                  Employee.strToDate("2007-05-20"),
                                  60000));

        System.out.println(mgr1);
        System.out.println(mgr2);

        for (Employee e : mainList) {
            System.out.println(e);
        }

    }

}
