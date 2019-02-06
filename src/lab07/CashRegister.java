/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 5, 2019
* Time: 4:25:01 PM
*
* Project: csci205
* Package: lab07
* File: CashRegister
* Description: A simulation of a cash register
* @version 2.0
*
* ****************************************
 */
package lab07;

import java.util.ArrayList;

/**
 *
 * @author mag051
 */
public class CashRegister {

    /**
     * The name of the cash drawer
     */
    private String sName;

    /**
     * The amount of cash in the drawer
     */
    private double cashInDrawer;

    /**
     * Are we currently in a transaction
     */
    private boolean isInTransaction;

    /**
     * The total amount of the transaction
     */
    private double transTotal;

    /**
     * The total number of items purchased in this transaction so far
     */
    private int numItemsInTrans = 0;

    /**
     * The total amount of money collected toward the transaction
     */
    private double amountPaid;

    /**
     * Every item purchased during the day
     */
    private ArrayList<Double> itemList;

    /**
     * The total amount of transactions so far
     */
    private int totalTransactions = 0;

    private double totalMoneyRecieved = 0.0;

    /**
     * Initialize an empty cash register with name of Default
     *
     * @param itemList
     */
    public CashRegister() {
        this.cashInDrawer = 0;
        this.isInTransaction = false;
        this.transTotal = 0;
        this.numItemsInTrans = 0;
        this.amountPaid = 0;
        this.sName = "Default";
        this.itemList = new ArrayList<Double>();
    }

    /**
     * Initialize an empty cash register with a specified name
     *
     * @param sName
     */
    public CashRegister(String sName) {
        this();
        this.sName = sName;
    }

    public CashRegister(ArrayList<Double> itemList) {
        this();
        this.itemList = new ArrayList<Double>();
    }

    /**
     * Initialize the starting cash in the register
     *
     * @param initCash
     */
    public void startDay(double initCash) {
        this.itemList.clear();
        this.cashInDrawer = initCash;
        this.totalTransactions = 0;
        this.totalMoneyRecieved = 0.0;
    }

    /**
     * Check how much cash is in the register at the end of the day
     *
     * @return Cash in the drawer
     */
    public double finishDay() {
        return this.cashInDrawer;
    }

    /**
     * Have the current register start a transaction
     *
     * @return Boolean based on if the register can start a transaction
     */
    public boolean startTransaction() {
        if (this.cashInDrawer == 0 || this.isInTransaction) {
            return false;
        }
        else {
            this.isInTransaction = true;
            return true;
        }
    }

    /**
     * Check to see if current register can finish a transaction
     *
     * @return Boolean based on if register can finish a transaction
     */
    public boolean finishTransaction() {
        if (this.isInTransaction == true && this.transTotal == this.amountPaid) {
            this.isInTransaction = false;
            this.totalMoneyRecieved += this.amountPaid;
            this.transTotal = 0.0;
            this.amountPaid = 0.0;
            this.totalTransactions += 1;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Scan an item and add it to the transaction
     *
     * @param priceOfItem
     */
    public void scanItem(double priceOfItem) {
        this.transTotal += priceOfItem;
        this.numItemsInTrans++;
        this.itemList.add(priceOfItem);
    }

    public double getTransactionTotal() {
        return this.transTotal;
    }

    public int getNumItemsInTrans() {
        return this.numItemsInTrans;
    }

    public double getAmountPaid() {
        return this.amountPaid;
    }

    public String getName() {
        return this.sName;
    }

    public boolean isInTransaction() {
        return this.isInTransaction;
    }

    public double getAmountOwed() {
        return this.transTotal - this.amountPaid;
    }

    public void setName(String newName) {
        this.sName = newName;
    }

    public int getNumItemsToday() {
        return this.itemList.size();
    }

    public double getAveItemPurchasedToday() {
        double sum = 0.0;
        for (Double x : this.itemList) {
            sum += x;
        }
        return sum / this.itemList.size();
    }

    public void displayItemList() {
        System.out.printf("Item Log: %d items purchased today\n",
                          this.itemList.size());
        for (Double x : this.itemList) {
            System.out.printf("$%.2f\n", x);
        }
    }

    public int getNumTransToday() {
        return this.totalTransactions;
    }

    public double getAveTransToday() {
        return this.totalMoneyRecieved / this.totalTransactions;
    }

    /**
     * Collects payment from the customer
     *
     * @param customerPayment how much the customer is paying with
     * @return how much change the customer gets
     */
    public double collectPayment(double customerPayment) {
        if (this.getAmountOwed() == customerPayment) {
            this.amountPaid += customerPayment;
            this.cashInDrawer += customerPayment;
            return 0.0;
        }
        else if (this.getAmountOwed() > customerPayment) {
            this.amountPaid += customerPayment;
            this.cashInDrawer += customerPayment;
            return 0.0 - this.getAmountOwed();
        }
        else {
            double customerChange = customerPayment - this.getAmountOwed();
            this.amountPaid += customerPayment - customerChange;
            this.cashInDrawer += customerPayment - customerChange;
            return customerChange;
        }
    }

    @Override
    public String toString() {
        String register = sName + ": drawer: $";
        register += this.cashInDrawer;

        if (this.isInTransaction) {
            register += " CURRENT TRANS: #items: " + this.numItemsInTrans
                        + ", total sale: $" + this.transTotal + ", amount paid: $"
                        + this.amountPaid;
        }
        else {
            register += " NOT IN TRANSACTION ";
        }
        register += "\nTODAY: #items : " + this.itemList.size()
                    + ", #trans: " + this.totalTransactions;
        return register;
    }

}
