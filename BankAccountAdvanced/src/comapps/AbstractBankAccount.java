package comapps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Missing some javadoc comments.
 * Code Reviewer: Christine Marasigan
 */

public abstract class AbstractBankAccount implements BankAccount {
    /** variable declaration. */
    private double balance;
    /** variable declaration. */
    private boolean isFrozen;
    /** variable declaration. */
    private final List<Transaction> transactionHistory;

    /** constructor. */
    public AbstractBankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
        this.transactionHistory = new ArrayList<>();
    }

    /** deposit method.
     * @param amount */
    public synchronized void deposit(final double amount)
            throws InvalidAmountException, AccountFrozenException {

        if (isFrozen) {
            throw new AccountFrozenException("Account is frozen");
        }
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than 0");
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposited: " + amount + ". Balance: " + balance);
    }

    /** withdraw method.
     * @param amount */
    public synchronized void withdraw(final double amount)
            throws InvalidAmountException,
            InsufficientFundsException, AccountFrozenException {

        if (isFrozen) {
            throw new AccountFrozenException("Account is frozen");
        }
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds for withdrawal");
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
        System.out.println("Withdrawn: " + amount + ". Balance: " + balance);
    }

    /** getter for balance.
     * @return balance */
    public synchronized double getBalance() {
        return balance;
    }

    /** getter for isFrozen.
     * @return isFrozen */
    public boolean isFrozen() {
        return isFrozen;
    }

    /** freezes account. */
    public void freezeAccount() {
        isFrozen = true;
    }

    /** unfreezes account. */
    public void unfreezeAccount() {
        isFrozen = false;
    }

    /** getter for transactionHistory.
     * @return transactionHistory */
    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }
}
