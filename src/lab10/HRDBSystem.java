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

import java.util.Date;

/**
 *
 * @author mag051
 */
public class HRDBSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee emp = new Employee(0, "Brian", "King", 123456789, new Date(),
                                    60000);
        Manager mgr = new Manager(1, "Keith", "Buffinton", 101010101, new Date(),
                                  150000, "ENGINEERING");

        System.out.println(emp);
        System.out.println(mgr);
    }

}
