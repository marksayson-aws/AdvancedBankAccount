package comapps;

import java.util.List;

/**
 * Everything looks good and functional.
 * Code Reviewer: Christine Marasigan
 */

public interface BankAccount {
    /**
     * method that deposits money to account (after various checks).
     * @param amount
     */
    void deposit(double amount)
            throws InvalidAmountException, AccountFrozenException;

    /**
     * method that withdraws money from account (after various checks).
     * @param amount
     */
    void withdraw(double amount)
            throws InvalidAmountException,
            InsufficientFundsException, AccountFrozenException;

    /**
     * stores balance of account.
     * @return getBalance
     */
    double getBalance();

    /**
     * if account is frozen or not.
     * @return isFrozen
     */
    boolean isFrozen();

    /**
     * freezes an account.
     */
    void freezeAccount();

    /**
     * unfreezes an account.
     */
    void unfreezeAccount();

    /**
     * Returns all transactions with String-based types.
     * @return List<Transaction>
     */
    List<Transaction> getTransactionHistory();

//    /**
//     * Main method testing.
//     * @param args
//     */
//    static void main(final String[] args) {
//        // Test 1
//        BankAccountManager bam = new BankAccountManager();
//        SavingsAccount sa = new SavingsAccount("Betlog");
//        bam.addAccount(sa);
//        bam.getAccounts().forEach((id, acc) -> {
//            if (acc == sa) {
//                System.out.println("ID: " + id + " | Account: "
//            + sa.getOwnerName() + " | Balance: " + sa.getBalance());
//            }
//        });
//
//        //System.out.print(sa.getOwnerName() + " | ");
//        //bam.listAccounts();
//
//        // --- 2 Deposit with valid amount
//        try {
//            int depositAmount = 1000;
//            sa.deposit(depositAmount);
//        } catch (Exception e) {
//            System.out.println("Unexpected: " + e);
//        }
//
//        // --- 3 Deposit with zero amount
//        try {
//            sa.deposit(0);
//        } catch (Exception e) {
//            System.out.println("Expected InvalidAmountException: " + e);
//        }
//
//        // --- 4 Deposit with negative amount
//        try {
//            int invalidDeposit = -500;
//            sa.deposit(invalidDeposit);
//        } catch (Exception e) {
//            System.out.println("Expected InvalidAmountException: " + e);
//        }
//
//        // --- 5 Withdraw with sufficient funds
//        try {
//            int withdrawAmount = 500;
//            sa.withdraw(withdrawAmount);
//        } catch (Exception e) {
//            System.out.println("Unexpected: " + e);
//        }
//
//        // --- 6 Withdraw with insufficient funds
//        try {
//            int invalidWithdraw = 1500;
//            sa.withdraw(invalidWithdraw);
//        } catch (Exception e) {
//            System.out.println("Expected InsufficientFundsException: " + e);
//        }
//
//        // --- 7 Withdraw with negative amount
//        try {
//            int withdrawAmount = -100;
//            sa.withdraw(withdrawAmount);
//        } catch (Exception e) {
//            System.out.println("Expected InvalidAmountException: " + e);
//        }
//
//        // --- 8 Deposit when account is frozen
//        try {
//            int withdrawAmount = 500;
//            sa.freezeAccount();
//            sa.deposit(withdrawAmount);
//        } catch (Exception e) {
//            System.out.println("Expected AccountFrozenException: " + e);
//        }
//
//        // --- 9 Withdraw when account is frozen
//        try {
//            int withdrawAmount = 500;
//            sa.withdraw(withdrawAmount);
//        } catch (Exception e) {
//            System.out.println("Expected AccountFrozenException: " + e);
//        }
//
//        // --- 10 Unfreeze and withdraw
//        try {
//            int withdrawAmount = 100;
//            sa.unfreezeAccount();
//            sa.withdraw(withdrawAmount);
//        } catch (Exception e) {
//            System.out.println("Unexpected: " + e);
//        }
//
//        // --- 11 Check balance after multiple transactions
//        System.out.println("Balance: " + sa.getBalance());
//
//        // --- 12 Check transaction history above 500
//        List<Transaction> history = sa.getTransactionHistory();
//        List<Transaction> filtered =
//                BankAccountManager.filterTransactionsAbove(500, history);
//        System.out.println("Transactions above 500:");
//        filtered.forEach(t -> System.out.println(t));
//
//        // --- 13 Check transaction history sorted by amount
//        List<Transaction> sorted =
//                BankAccountManager.sortTransactionsByAmount(history);
//        System.out.println("Transactions sorted by amount:");
//        sorted.forEach(t -> System.out.println(t));
//
//        // --- 14 Handle invalid account object access
//        try {
//            BankAccount missing =
//                    bam.getAccount(999); // an id that doesn't exist
//            // calling a method on a null reference
//            System.out.println(missing.getBalance());
//        } catch (NullPointerException e) {
//            System.out.println("Expected NullPointerException: " + e);
//        }
//
//        // EXTRA 1: Test getType()
//        for (Transaction tx : history) {
//            System.out.println("Transaction type: " + tx.getType());
//        }
//
//    }

}
