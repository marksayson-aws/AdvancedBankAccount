/** package */
package comapps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Everything looks good and functional.
 * Code Reviewer: Christine Marasigan
 */

public class BankAccountManager {
    /** package. */
    private final Map<Integer, BankAccount> accounts;
    /** package. */
    private int nextAccountId;

    /** package. */
    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.nextAccountId = 1;
    }

    /**
     * Adds an account and assigns the next available ID.
     * @param account
     */
    public void addAccount(final BankAccount account) {
        getAccounts().put(nextAccountId++, account);
    }

    /**
     * Returns the account with the given ID, or null if not found.
     * @return BankAccount
     * @param accountId
     */
    public BankAccount getAccount(final int accountId) {
        return getAccounts().get(accountId);
    }

    /** Lists all accounts with their balances. */
    public void listAccounts() {
        getAccounts().forEach((id, acc) ->
                System.out.println("Account ID: " + id
                        + " | Balance: " + acc.getBalance()));
    }

    /**
     * Filters transactions above the specified amount.
     * Use a lambda expression.
     * @return txList
     * @param amount
     * @param txList
     * */
    public static List<Transaction> filterTransactionsAbove(
            final double amount, final List<Transaction> txList) {
        return txList.stream()
                .filter(tx -> tx.getAmount() > amount)
                .collect(Collectors.toList());
    }

    /**
     * Sorts transactions by amount using a lambda expression.
     * @return txList
     * @param txList
     * */
    public static List<Transaction> sortTransactionsByAmount(
            final List<Transaction> txList) {
        return txList.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .collect(Collectors.toList());
    }

    /** getter for accounts.
     * @return accounts
     */
    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }
}
