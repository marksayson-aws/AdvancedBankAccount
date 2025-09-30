package comapps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Checkstyle errors.
 * Magic numbers and lines past 80 characters.
 * Code Reviewer: Christine Marasigan
 */

@TestMethodOrder(OrderAnnotation.class)
class BankAccountTests {
    /** for instantiating BankAccountManager object. */
    private BankAccountManager bam;
    /** for instantiating SavingsAccount object. */
    private SavingsAccount sa;

    /** for testing amount. */
    private final double oneThou = 1000.0;
    /** for testing amount. */
    private final double negFiveHun = -500.0;
    /** for testing amount. */
    private final double fiveHun = 500.0;
    /** for testing amount. */
    private final double oneFive = 1500.0;
    /** for testing amount. */
    private final double negOneHun = -100.0;
    /** for testing amount. */
    private final double oneHun = 100.0;
    /** for testing amount. */
    private final double nineHun = 900.0;
    /** for testing amount. */
    private final double fourHun = 400.0;
    /** for testing amount. */
    private final int nine = 999;
    /** for testing amount. */
    private final double twoHun = 200.0;

    /** for test ordering. */
    private final int o1 = 1;
    /** for test ordering. */
    private final int o2 = 2;
    /** for test ordering. */
    private final int o3 = 3;
    /** for test ordering. */
    private final int o4 = 4;
    /** for test ordering. */
    private final int o5 = 5;
    /** for test ordering. */
    private final int o6 = 6;
    /** for test ordering. */
    private final int o7 = 7;
    /** for test ordering. */
    private final int o8 = 8;
    /** for test ordering. */
    private final int o9 = 9;
    /** for test ordering. */
    private final int o10 = 10;
    /** for test ordering. */
    private final int o11 = 11;
    /** for test ordering. */
    private final int o12 = 12;
    /** for test ordering. */
    private final int o13 = 13;
    /** for test ordering. */
    private final int o14 = 14;
    /** for test ordering. */
    private final int o15 = 15;
    /** for test ordering. */
    private final int o16 = 16;

    @BeforeEach
    void setUp() throws Exception {
        bam = new BankAccountManager();
        sa = new SavingsAccount("Betlog");
        bam.addAccount(sa);
        System.out.println("\n[New Bank Account and"
                + " Manager Made for New Test]");

    }

    // 1 Add savings account to BankAccountManager
    @Order(o1)
    @Test
    void test1AddAccount() {
        bam.getAccounts().forEach((id, acc) -> {
            if (acc == sa) {
                System.out.println("ID: " + id + " | Account: "
                        + sa.getOwnerName() + " | Balance: " + sa.getBalance());
                assertEquals(1, id);
            }
     });
        assertEquals("Betlog", sa.getOwnerName());
        assertEquals(0.0, sa.getBalance());
    }

    // 2 Deposit with valid amount
    @Order(o2)
    @Test
    void test2DepositValidAmount() throws Exception {
        sa.deposit(oneThou);
        assertEquals(oneThou, sa.getBalance());
    }

    // 3 Deposit with zero amount
    @Order(o3)
    @Test
    void test3DepositZeroAmount() {
        InvalidAmountException thrownException = assertThrows(
            InvalidAmountException.class,
            () -> sa.deposit(0),
            "Expected InvalidAmountException to be thrown, but it wasn't."
        );

        // Print the error message to the console
        System.err.println("Expected Exception: "
        + thrownException.getMessage());
    }

    // 4 Deposit with negative amount
    @Order(o4)
    @Test
    void test4DepositNegativeAmount() {
        InvalidAmountException thrownException = assertThrows(
                InvalidAmountException.class,
                () -> sa.deposit(negFiveHun),
                "Expected InvalidAmountException to be thrown, but it wasn't."
            );

            // Print the error message to the console
            System.err.println("Expected Exception: "
            + thrownException.getMessage());
    }

    // 5 Withdraw with sufficient funds
    @Order(o5)
    @Test
    void test5WithdrawSufficientFunds() throws Exception {
        sa.deposit(oneThou);
        sa.withdraw(fiveHun);
        assertEquals(fiveHun, sa.getBalance());
    }

    // 6 Withdraw with insufficient funds
    @Order(o6)
    @Test
    void test6WithdrawInsufficientFunds() throws Exception {
        sa.deposit(oneThou);

        InsufficientFundsException thrownException = assertThrows(
                InsufficientFundsException.class,
                () -> sa.withdraw(oneFive),
                "Expected InsufficientFundsException to be thrown,"
                + "but it wasn't."
            );

            // Print the error message to the console
            System.err.println("Expected Exception: "
            + thrownException.getMessage());
    }

    // 7 Withdraw with negative amount
    @Order(o7)
    @Test
    void test7WithdrawNegativeAmount() {

        InvalidAmountException thrownException = assertThrows(
                InvalidAmountException.class,
                () -> sa.withdraw(negOneHun),
                "Expected InvalidAmountException to be thrown, but it wasn't."
            );

            // Print the error message to the console
            System.err.println("Expected Exception: "
            + thrownException.getMessage());
    }

    // 8 Deposit when account is frozen
    @Order(o8)
    @Test
    void test8DepositWhenFrozen() throws Exception {
        sa.freezeAccount();

        AccountFrozenException thrownException = assertThrows(
                AccountFrozenException.class,
                () -> sa.deposit(fiveHun),
                "Expected AccountFrozenException to be thrown, but it wasn't."
            );

            // Print the error message to the console
            System.err.println("Expected Exception: "
            + thrownException.getMessage());
    }

    // 9 Withdraw when account is frozen
    @Order(o9)
    @Test
    void test9WithdrawWhenFrozen() throws Exception {
        sa.deposit(oneThou);
        sa.freezeAccount();

        AccountFrozenException thrownException = assertThrows(
                AccountFrozenException.class,
                () -> sa.withdraw(fiveHun),
                "Expected AccountFrozenException to be thrown, but it wasn't."
            );

            // Print the error message to the console
            System.err.println(
                    "Expected Exception: " + thrownException.getMessage());
    }

    // 10 Unfreeze account and withdraw
    @Order(o10)
    @Test
    void test10UnfreezeAndWithdraw() throws Exception {
        sa.deposit(oneThou);
        sa.freezeAccount();
        sa.unfreezeAccount();
        sa.withdraw(oneHun);
        assertEquals(nineHun, sa.getBalance());
    }

    // 11 Check balance after multiple transactions
    @Order(o11)
    @Test
    void test11CheckBalanceAfterMultipleTransactions() throws Exception {
        sa.deposit(oneThou);
        sa.withdraw(fiveHun);
        sa.withdraw(oneHun);
        assertEquals(fourHun, sa.getBalance());
    }

    // 12 Check transaction history above 500
    @Order(o12)
    @Test
    void test12FilterTransactionsAbove500() throws Exception {
        sa.deposit(oneThou);
        sa.withdraw(fiveHun);
        List<Transaction> history = sa.getTransactionHistory();
        List<Transaction> filtered =
                BankAccountManager.filterTransactionsAbove(fiveHun, history);
        assertEquals(1, filtered.size());
        assertEquals("Deposit", filtered.get(0).getType());
        assertEquals(oneThou, filtered.get(0).getAmount());
    }

    // 13 Check transaction history sorted by amount
    @Order(o13)
    @Test
    void test13SortTransactionsByAmount() throws Exception {
        sa.deposit(oneThou);
        sa.withdraw(fiveHun);
        sa.withdraw(oneHun);
        List<Transaction> history = sa.getTransactionHistory();
        List<Transaction> sorted =
                BankAccountManager.sortTransactionsByAmount(history);
        assertEquals(oneHun, sorted.get(0).getAmount());
        assertEquals(oneThou, sorted.get(sorted.size() - 1).getAmount());
    }

    // 14 Handle invalid account object access
    @Order(o14)
    @Test
    void test14InvalidAccountAccess() {
        NullPointerException thrownException =
                assertThrows(NullPointerException.class, () -> {
            BankAccount missing = bam.getAccount(nine);
            missing.getBalance();
        });

     // Print the error message to the console
        System.err.println("Expected Exception: "
     + thrownException.getMessage());
    }

    // EXTRA 1: ListAccounts (no exception expected)
    @Order(o15)
    @Test
    void testExtra1ListAccountsNoException() {
        assertDoesNotThrow(() -> bam.listAccounts());
    }

    // EXTRA 2: Verify Transaction.getType()
    @Order(o16)
    @Test
    void testExtra2TransactionGetType() throws Exception {
        sa.deposit(oneThou);
        sa.withdraw(twoHun);

        // prints transaction history
        List<Transaction> history = sa.getTransactionHistory();
        for (Transaction tx : history) {
          System.out.println("Transaction type: " + tx.getType());
        }

        // assertion
        for (Transaction tx : sa.getTransactionHistory()) {
            assertTrue(tx.getType().equals("Deposit")
                    || tx.getType().equals("Withdrawal"));
        }
    }
}
