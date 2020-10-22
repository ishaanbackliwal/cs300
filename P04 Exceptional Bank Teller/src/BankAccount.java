//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P04 Exceptional Bank Teller
// Files:           BankAccount.java
//                  BankAccountTester.java
//                  BankTeller.java
//                  BankTellerTester.java
// Course:          CS 300, Fall 2019
//
// Author:          Ishaan Backliwal
// Email:           backliwal@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  The Java API
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class BankAccount {
  
  private String account;
  private int balance;
  private ArrayList<String> transactions;
  
  /**
   * The class constructor that initializes the instance fields and runs a test to see if one of the 
   * parameters it is passed is valid, and then adds the initial deposit as a transaction
   * @param accountID is the identifier for each bank account object
   * @param initialBalance is the starting amount for the bank account object at hand
   * @throws IllegalArgumentException if the initial balance parameter is lower than 10 
   */
  public BankAccount(String accountID, int initialBalance) throws IllegalArgumentException {
    account = accountID;
    balance = initialBalance;
    if(balance < 10) {
      throw new IllegalArgumentException("Initial balance is too low (< $10)");
    }
    transactions = new ArrayList<String>();
    transactions.add("1 " + initialBalance);
  }
  /**
   * Deposits the passed amount as a transaction for this specific bank account object and runs a 
   * test to make sure the deposit amount is valid, and then adds the deposit amount to the 
   * account balance
   * @param depositAmount is the amount needed to be deposited
   * @throws IllegalArgumentException if the deposit amount parameter is negative 
   */
  public void deposit(int depositAmount) throws IllegalArgumentException {
    if(depositAmount < 0) {
      throw new IllegalArgumentException("Invalid deposit amount (negative)");
    }
    balance += depositAmount;
    transactions.add("1 " + depositAmount);
  }
  /**
   * Checks whether a bank account object is equal to the current bank account object
   * @param other is the other bank account object that is needed to be checked for equality
   * @return true if accounts are equal or false otherwise
   */
  public boolean equals(BankAccount other) {
    if(this.getID().equals(other.getID())) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Gets the current balance of the bank account
   * @return the current balance of the account
   */
  public int getBalance() {
    return balance;
  }
  /**
   * Gets the idea of the current bank account
   * @return a string representing the id of the bank account
   */
  public String getID() {
    return account;
  }
  /**
   * Gets the 5 most recent transactions of the bank account in an array
   * @return an array of the 5 most recent transactions, the most recent being in index 0 and the 
   * least recent being in index 4. If transaction count is less than 5, the array will be filled 
   * with null in the non-existent transaction places
   */
  public String[] getMostRecentTransactions() {
    String[] recent = new String[5];
    int count = 0;
    for(int i = transactions.size() - 1; i >= transactions.size() - 5; i--) {
      if(i < 0) {
        recent[count] = null;
      }
      else {
        recent[count] = transactions.get(i); 
      }
      count++;
    }
    return recent;
  }
  /**
   * Gets the number of transactions made
   * @return an integer representing the number of transactions made
   */
  public int getTransactionsCount() {
    return transactions.size();
  }
  /**
   * Withdraws a certain amount from the bank account and runs tests to make sure the withdrawal 
   * amount is valid, and adds that withdrawal to the list of transactions if appropriate
   * @param withdrawAmount is the amount to be withdrawn from the bank account
   * @throws IllegalStateException if the withdraw amount if greater than the account balance
   * @throws DataFormatException if the withdraw amount is not divisible by 10 OR if the withdraw 
   * amount is negative
   */
  public void withdraw(int withdrawAmount) throws IllegalStateException, DataFormatException{
    if(withdrawAmount < 0) {
      throw new DataFormatException("Invalid withdraw amount (negative)");
    }
    if(withdrawAmount % 10 != 0) {
      throw new DataFormatException("Invalid withdraw amount (not a multiple of 10)");
    }
    if(withdrawAmount > balance) {
      throw new IllegalStateException("Insufficient account balance for withdrawal request");
    }
    balance -= withdrawAmount;
    transactions.add("0 " + withdrawAmount);
  }
}