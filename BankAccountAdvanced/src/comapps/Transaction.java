package comapps;

/**
 * Everything looks good and functional.
 * Code Reviewer: Christine Marasigan
 */

public class Transaction {
    /** stores string for type of transaction. */
    private final String type;
    /** stores amount of the transaction. */
    private final double amount;

    /** constructor for transaction.
     * @param types
     * @param amounts
     */
    public Transaction(final String types, final double amounts) {
        this.type = types;
        this.amount = amounts;
    }

    /** returns String type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /** returns amount.
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /** Returns the type and amount in String type..
     * @return both
     */
    public String toString() {
        return type + ": " + String.format("%.2f", amount);
    }
}
