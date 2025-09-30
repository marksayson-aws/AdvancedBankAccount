package comapps;

/**
 * Everything looks good and functional.
 * Code Reviewer: Christine Marasigan
 */

public class SavingsAccount extends AbstractBankAccount {
    /** Holds the name of the owner’s account. */
    private final String ownerName;

    /** Initializes the owner name and handles errors.
     * @param owner
     */
    public SavingsAccount(final String owner) {
        this.ownerName = owner;
    }

    /** returns ownerName.
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }
}
