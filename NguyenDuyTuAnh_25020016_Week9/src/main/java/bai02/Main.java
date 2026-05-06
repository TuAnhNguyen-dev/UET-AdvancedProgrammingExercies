package bai02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the BankSystem application. Demonstrates deposit and withdrawal
 * operations with comprehensive logging output.
 */
public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  /**
   * Main method to run the bank system demo.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    logger.info("=== Bank System Application Started ===");

    try {
      // Test Case 1: Basic operations with first account
      logger.info("=== TEST CASE 1: Basic Operations ===");
      BankSystem account1 = new BankSystem("1234567890123456", 1000.0);

      // Perform deposit operations
      logger.info("--- Performing Deposit Operations ---");
      account1.deposit(500.0);
      logger.info("Current balance: {}", account1.getBalance());

      account1.deposit(250.5);
      logger.info("Current balance: {}", account1.getBalance());

      // Perform successful withdrawal
      logger.info("--- Performing Withdrawal Operations ---");
      boolean withdrawSuccess = account1.withdraw(300.0);
      logger.info("Withdrawal successful: {}", withdrawSuccess);
      logger.info("Current balance: {}", account1.getBalance());

      // Attempt withdrawal with insufficient balance
      logger.warn("--- Attempting withdrawal with insufficient balance ---");
      withdrawSuccess = account1.withdraw(2000.0);
      logger.info("Withdrawal successful: {}", withdrawSuccess);
      logger.info("Current balance: {}", account1.getBalance());

      // Test Case 2: Edge cases with zero balance
      logger.info("=== TEST CASE 2: Zero Balance Account ===");
      BankSystem account2 = new BankSystem("9876543210987654", 0.0);
      logger.info("Initial balance: {}", account2.getBalance());

      // Try to withdraw from zero balance
      withdrawSuccess = account2.withdraw(100.0);
      logger.info("Withdrawal from zero balance successful: {}", withdrawSuccess);

      // Deposit to zero balance account
      account2.deposit(1000.0);
      logger.info("Balance after deposit: {}", account2.getBalance());

      // Test Case 3: Large amounts
      logger.info("=== TEST CASE 3: Large Amount Operations ===");
      BankSystem account3 = new BankSystem("1111222233334444", 1000000.0);
      account3.deposit(500000.0);
      logger.info("Balance after large deposit: {}", account3.getBalance());

      account3.withdraw(750000.0);
      logger.info("Balance after large withdrawal: {}", account3.getBalance());

      // Test Case 4: Small decimal amounts
      logger.info("=== TEST CASE 4: Small Decimal Operations ===");
      BankSystem account4 = new BankSystem("5555666677778888", 100.0);
      account4.deposit(0.01);
      logger.info("Balance after tiny deposit: {}", account4.getBalance());

      account4.deposit(0.99);
      logger.info("Balance after another small deposit: {}", account4.getBalance());

      // Test Case 5: Invalid operations
      logger.info("=== TEST CASE 5: Invalid Operations ===");
      try {
        account1.deposit(-100.0);
      } catch (IllegalArgumentException e) {
        logger.error("Caught expected exception for negative deposit: {}", e.getMessage());
      }

      try {
        account1.withdraw(-50.0);
      } catch (IllegalArgumentException e) {
        logger.error("Caught expected exception for negative withdrawal: {}", e.getMessage());
      }

      try {
        account1.deposit(0.0);
      } catch (IllegalArgumentException e) {
        logger.error("Caught expected exception for zero deposit: {}", e.getMessage());
      }

      try {
        account1.withdraw(0.0);
      } catch (IllegalArgumentException e) {
        logger.error("Caught expected exception for zero withdrawal: {}", e.getMessage());
      }

      // Test Case 6: Boundary testing
      logger.info("=== TEST CASE 6: Boundary Testing ===");
      BankSystem account5 = new BankSystem("9999000011112222", 100.0);

      // Withdraw exact balance
      withdrawSuccess = account5.withdraw(100.0);
      logger.info("Withdrawal of exact balance successful: {}", withdrawSuccess);
      logger.info("Balance after exact withdrawal: {}", account5.getBalance());

      // Try to withdraw after emptying account
      withdrawSuccess = account5.withdraw(1.0);
      logger.info("Withdrawal after emptying account successful: {}", withdrawSuccess);

      logger.info("=== Bank System Application Completed Successfully ===");

    } catch (Exception e) {
      logger.error("Unexpected error occurred: ", e);
      System.exit(1);
    }
  }
}
