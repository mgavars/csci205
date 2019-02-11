/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 6, 2019
* Time: 1:36:46 PM
*
* Project: csci205
* Package: lab08
* File: Coin
* Description:
*
* ****************************************
 */
package lab08;

/**
 * Coin - a simple enumerated type to represent the different types of coins
 *
 * @author mag051
 */
public enum Coin {
    NICKEL(.05), DIME(.10), QUARTER(.25);

    private double value;

    Coin(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
