/**
 * CSCI 205 - Software Engineering and Design Lab08
 *
 * This exercise is designed to teach the student about enumerated types, a
 * powerful class mechanism in Java, particularly when compared to enumerations
 * in other languages. The student steps through creating a CoinCollection
 * class, adding several capabilities throughout the lab exercise.
 *
 * @author Prof. Brian King 2014-fall, modified 2015-spring
 * 	   modified 2019-spring by Prof. Chris Dancy
 */
/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 6, 2019
* Time: 12:36 PM
*
* Project: csci205
* Package: lab08
* File: CoinCollection
* Description: Representing a collection of coins using newly learned enumerated type
*
* ****************************************
 */
package lab08;

/**
 * A class to represent a collection of coins. The coins that can be stored are
 * determined by the enumerated type {@link Coin}.
 */
public class CoinCollection {

    /**
     * An array to store the individual values of each coin
     */
    //private static final double[] coinValues = {0.05, 0.10, 0.25};
    /**
     * array of integers contains actual count of each coin type in the
     * collection
     */
    private final int coinCount[];

    /**
     * Constructor to create a new empty coin collection. No coins are in the
     * collection when created.
     */
    public CoinCollection() {
        this.coinCount = new int[Coin.values().length];
    }

    /**
     * Add coins to the collection
     *
     * @param coinType - The type of coin to add
     * @param count - The number of coins to add of the specified type
     */
    public void addCoins(Coin coinType, int count) {
        // TODO - FINISH THIS METHOD
        this.coinCount[coinType.ordinal()] += count;

    }

    /**
     * Remove coins from the collection
     *
     * @param coinType - The type of coin to remove
     * @param count - the number of coins to remove
     * @return - the number of coins actually removed, ensuring that we can't
     * remove more coins than we have, preventing negative coin amounts.
     */
    public int removeCoins(Coin coinType, int count) {
        // TODO -- FINISH THIS METHOD!
        int removeCount = 0;
        for (int i = 0; i < count; i++) {
            if (this.coinCount[coinType.ordinal()] != 0) {
                this.coinCount[coinType.ordinal()] -= 1;
                removeCount += 1;
            }
        }
        return removeCount;
    }

    /**
     * Return the count of the specified coin type in the collection
     *
     * @param coinType - the coin type to return the count for
     * @return the number of coins of the specified type
     */
    public int getCount(Coin coinType) {
        return this.coinCount[coinType.ordinal()];
    }

    /**
     * Compute the total amount of the collection
     *
     * @return the total amount of the collection in dollars
     */
    public double getTotal() {
        // TODO - FINISH THIS METHOD
        double totalAmount = 0.0;
        for (Coin coinType : Coin.values()) {
            totalAmount += this.coinCount[coinType.ordinal()] * coinType.getValue();
        }
        /*
        for (int i = 0; i < Coin.values().length; i++) {
            totalAmount += this.coinCount[i] * coinValues[i];
        }
         */
        return totalAmount;
    }

    @Override
    public String toString() {
        String coins = "";
        for (Coin coinType : Coin.values()) {
            coins += coinType + ": " + this.coinCount[coinType.ordinal()] + "\n";
        }
        coins += "Total = $" + this.getTotal();
        return coins;
    }

    /**
     * Main program - designed to test out the CoinCollection class
     */
    public static void main(String args[]) {
        CoinCollection myCoins = new CoinCollection();

        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        System.out.println(myCoins);

        System.out.println("TEST: Removing 10 nickels, only 5 to remove ");
        System.out.printf("ACTUAL: Removed %d nickels%n",
                          myCoins.removeCoins(Coin.NICKEL, 10));

        System.out.println(myCoins);

        System.out.println("TEST: Removing 1 quarter");
        System.out.printf("RESPONSE: Removed %d quarter%n",
                          myCoins.removeCoins(Coin.QUARTER, 1));

        System.out.println(myCoins);
    }

}
