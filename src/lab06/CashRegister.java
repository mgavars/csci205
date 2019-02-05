/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2019
*
* Name: Mitch Gavars
* Date: Feb 3, 2019
* Time: 4:25:01 PM
*
* Project: csci205
* Package: lab06
* File: CashRegister
* Description: A simulation of a cash register
*
* ****************************************
 */
package lab06;

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
     * Initialize an empty cash register with name of Default
     */
    public CashRegister() {
        this.cashInDrawer = 0;
        this.isInTransaction = false;
        this.transTotal = 0;
        this.numItemsInTrans = 0;
        this.amountPaid = 0;
        this.sName = "Default";
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

    /**
     * Initialize the starting cash in the register
     *
     * @param initCash
     */
    public void startDay(double initCash) {
        this.cashInDrawer = initCash;
    }

    /**
     * Check how much cash is in the register at the end of the day
     *
     * @return Cash in the drawer
     */
    public double finishDay() {
        double endOfDay = this.cashInDrawer;
        this.cashInDrawer = 0.0;
        return endOfDay;
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
            this.transTotal = 0.0;
            this.amountPaid = 0.0;
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
        return register;
    }

    public static void main(String[] args) {
        CashRegister reg1 = new CashRegister(), reg2 = new CashRegister(
                "Register 2");
        System.out.println("Constructed:\n" + reg1 + "\n" + reg2);
        reg1.setName("Register 1");
        reg1.startDay(100.0);
        reg2.startDay(200.0);
        System.out.println("Started day:\n" + reg1 + "\n" + reg2);
        System.out.println(
                "TESTING: reg1: New transaction: $2.50, $9.95, $5.50 = $17.95");
        reg1.startTransaction();
        reg1.scanItem(2.50);
        reg1.scanItem(9.95);
        reg1.scanItem(5.50);
        System.out.println(
                "reg1.isInTransaction() = true. ACTUAL = " + reg1.isInTransaction());
        System.out.printf("reg1.getTotal() = $17.95. ACTUAL = $%.2f%n",
                          reg1.getTransactionTotal());
        System.out.println(
                "reg1.getNumItems() = 3. ACTUAL = " + reg1.getNumItemsInTrans());
        System.out.println(
                "reg1.getAmountPaid = 0.0 ACTUAL = " + reg1.getAmountPaid());
        System.out.println(
                "reg1.getAmountOwed() = 17.95. ACTUAL = " + reg1.getAmountOwed());
        System.out.println("Testing out toString() for reg1...");
        System.out.println(reg1);
        double amtBack = reg1.collectPayment(15.0);
        System.out.printf(
                "reg1: made payment of $15. Result = -2.95: ACTUAL = $%.2f%n",
                amtBack);
        System.out.println(reg1);
        System.out.println(
                "reg1: reg1.finishTransaction() = false. ACTUAL = " + reg1.finishTransaction());
        System.out.printf(
                "reg1: reg1.collectPayment(10), result: $7.05 ACTUAL = $%.2f%n",
                reg1.collectPayment(10));
        System.out.println(reg1);
        System.out.println(
                "reg1: reg1.finishTransaction() = true. ACTUAL = " + reg1.finishTransaction());
        System.out.println(reg1);
        System.out.println(
                "reg1: New transaction: $10, $7.50, $19.95, $5 = $42.45");
        reg1.startTransaction();
        reg1.scanItem(10);
        reg1.scanItem(7.50);
        reg1.scanItem(19.95);
        reg1.scanItem(5.00);
        System.out.println(reg1);
        System.out.printf("reg1.collectPayment($42.45) = 0.0. ACTUAL = $%.2f%n",
                          reg1.collectPayment(42.45));
        System.out.println(reg1);
        reg1.finishTransaction();
        System.out.println("Checking reg2, should still be untouched:");
        System.out.println(reg2);
        System.out.printf("reg1.finishDay() = $160.40. ACTUAL = $%.2f%n",
                          reg1.finishDay());
        System.out.println("Reg1 should be empty: " + reg1);
        System.out.printf("reg2.finishDay(): = $200. ACTUAL = $%.2f%n",
                          reg2.finishDay());
        System.out.println("Reg2 shuold be empty: " + reg2);
    }
}
