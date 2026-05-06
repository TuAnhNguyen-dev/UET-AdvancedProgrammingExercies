package bai02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Banking system simulator for deposit and withdrawal operations.
 * Refactored to follow Google Java Style guidelines and integrated with SLF4J Logging.
 */
public class BankSystem {

  // Initialize Logger from SLF4J
  private static final Logger logger = LoggerFactory.getLogger(BankSystem.class);

  private final String accountNumber;
  private double balance;

  /**
   * Initialize a new bank account.
   *
   * @param accountNumber the customer account number
   * @param initialBalance the initial balance
   */
  public BankSystem(String accountNumber, double initialBalance) {
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
    logger.info("New account created successfully. Account: {}", maskAccount(accountNumber));
  }

  /**
   * Deposit money into the account.
   *
   * @param amount the amount to deposit
   */
  public void deposit(double amount) {
    if (amount <= 0) {
      logger.warn("Attempted deposit with invalid amount (<= 0). Amount: {}", amount);
      throw new IllegalArgumentException("Deposit amount must be greater than 0");
    }
    balance += amount;
    logger.info("Deposit successful. Account: {}, Amount: +{}", maskAccount(accountNumber), amount);
  }

  /**
   * Withdraw money from the account.
   *
   * @param amount the amount to withdraw
   * @return true if withdrawal is successful, false if insufficient balance
   */
  public boolean withdraw(double amount) {
    if (amount <= 0) {
      logger.error("Business logic error: Withdrawal amount <= 0. Amount: {}", amount);
      throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
    }

    if (amount > balance) {
      logger.warn("Withdrawal failed due to insufficient balance. Account: {}, Requested: {}, Balance: {}",
              maskAccount(accountNumber), amount, balance);
      return false;
    }

    balance -= amount;
    logger.info("Withdrawal successful. Account: {}, Amount: -{}", maskAccount(accountNumber), amount);
    return true;
  }

  /**
   * Get the current balance of the account.
   *
   * @return the current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Get the account number.
   *
   * @return the account number
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * Mask part of the account number for security in logs.
   *
   * @param accNumber the account number to mask
   * @return the masked account number (last 4 digits visible)
   */
  private String maskAccount(String accNumber) {
    if (accNumber == null || accNumber.length() < 4) {
      return "****";
    }
    return "****" + accNumber.substring(accNumber.length() - 4);
  }
}