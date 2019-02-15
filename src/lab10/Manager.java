/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 15, 2019
* Time: 1:24:19 PM
*
* Project: csci205
* Package: lab10
* File: Manager
* Description:
*
* ****************************************
 */
package lab10;

import java.util.Date;

public class Manager extends Employee {

    private String deptName;

    /**
     * Get the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Set the value of deptName
     *
     * @param deptName new value of deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Manager(int empID, String firstName, String lastName, int ssNum,
                   Date hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.getDeptName();
    }

}
