/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 10, 2019
* Time: 5:44:13 PM
*
* Project: csci205
* Package: lab08
* File: AddRemoveChoices
* Description:
*
* ****************************************
 */
package lab08;

/**
 *
 * @author mag051
 */
public enum AddRemoveChoices {

    ADD("Add Coins"), REMOVE("Remove Coins"), DONE("Done");

    private String label;

    AddRemoveChoices(String s) {
        this.label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
