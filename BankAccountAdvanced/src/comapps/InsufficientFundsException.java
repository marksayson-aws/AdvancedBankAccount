package comapps;

/**
 * Everything looks good and functional.
 * Code Reviewer: Christine Marasigan
 */

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception {
    /**This is the correct constructor for the class.
     * @param message
     */
    public InsufficientFundsException(final String message) {
        super(message);
    }
}

@SuppressWarnings("serial")
class InvalidAmountException extends Exception {
    // This is the correct constructor for the class
    InvalidAmountException(final String message) {
        super(message);
    }
}

@SuppressWarnings("serial")
class AccountFrozenException extends Exception {
    // This is the correct constructor for the class
    AccountFrozenException(final String message) {
        super(message);
    }
}
