/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 9, 2019
* Time: 4:56:24 PM
*
* Project: csci205
* Package: lab08
* File: CoinCollectionClient
* Description: A JOptionPane for coin collection
*
* ****************************************
 */
package lab08;

import javax.swing.JOptionPane;

/**
 *
 * @author mag051
 */
public class CoinCollectionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        String coinAmount;
        int choice = 0;

        CoinCollection myCoins = new CoinCollection();

        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        while (choice != 2) {

            choice = JOptionPane.showOptionDialog(null,
                                                  myCoins.toString() + "\nSelect your action: ",
                                                  "Add or remove?",
                                                  JOptionPane.DEFAULT_OPTION,
                                                  JOptionPane.INFORMATION_MESSAGE,
                                                  null,
                                                  AddRemoveChoices.values(),
                                                  AddRemoveChoices.values()[0]);

            if (choice == 0) {
                Coin coinAddChoice = (Coin) JOptionPane.showInputDialog(null,
                                                                        "Which coin to add?",
                                                                        "Coin Selection",
                                                                        JOptionPane.INFORMATION_MESSAGE,
                                                                        null,
                                                                        Coin.values(),
                                                                        Coin.values()[0]);

                coinAmount = JOptionPane.showInputDialog(
                        null, "How many coins to add?");

                myCoins.addCoins(coinAddChoice, Integer.parseInt(
                                 coinAmount));

            }

            else if (choice == 1) {
                Coin coinRemoveChoice = (Coin) JOptionPane.showInputDialog(null,
                                                                           "Which coin to remove?",
                                                                           "Coin Selection",
                                                                           JOptionPane.INFORMATION_MESSAGE,
                                                                           null,
                                                                           Coin.values(),
                                                                           Coin.values()[0]);

                coinAmount = JOptionPane.showInputDialog(
                        null,
                        "How many coins to remove? Max is " + myCoins.getCount(
                                coinRemoveChoice));

                myCoins.removeCoins(coinRemoveChoice, Integer.parseInt(
                                    coinAmount));
            }

            else if (choice == JOptionPane.CLOSED_OPTION) {
                break;
            }

            else {
                break;
            }

        }

        JOptionPane.showMessageDialog(null, myCoins.toString() + "\n\nGoodbye!",
                                      "Thanks!",
                                      choice);
    }

}
