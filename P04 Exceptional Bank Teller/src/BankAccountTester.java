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
import java.util.zip.DataFormatException;

public class BankAccountTester {
  
  /**
   * The main method that runs each tester method in this class and outputs their return values
   * @param args
   */
  public static void main(String[] args) throws DataFormatException {
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println(testBankAccountDepositNegativeAmount());
    System.out.println(testBankAccountEquals());
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
    System.out.println(testBankAccountWithdrawValidAmount());
  }
  /**
   * Tests to see if the bank account correctly initializes the transactions array list with one, 
   * correctly formatted, deposit of the initial balance
   * @return true if only one transaction is present in the array list and that that transaction 
   * starts with the number 1, or false if not
   * also return false if the constructor throws an IllegalArgumentException
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {
    try {
      BankAccount goldmanSachs = new BankAccount("1", 1000);
      if(goldmanSachs.getID().compareTo("1") == 0 && goldmanSachs.getTransactionsCount() == 1) {
        return true;
      }
      else {
        return false;
      }
    }
    catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  /**
   * Tests to see if the bank account constructor, when passed an invalid initial balance value, 
   * throws an IllegalArgumentException
   * @return true if the bank account constructor throws an IllegalArgumentException and false 
   * otherwise
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount citiBank = new BankAccount("2", 1);
    }
    catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }
  /**
   * Tests to see if the deposit method throws an IllegalArgumentException when passed a negative 
   * value
   * @return true if the deposit method throws an IllegalArgumentException and false otherwise
   */
  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount wellsFargo = new BankAccount("3", 123);
    try {
      wellsFargo.deposit(-10);
    }
    catch(IllegalArgumentException e) {
      if(wellsFargo.getBalance() != 123) {
        return false;
      }
      else {
        System.out.println(e.getMessage());
        return true; 
      }
    }
    return false;
  }
  /**
   * Tests to see if the equals method correctly returns true when the bank accounts are equal
   * @return true if the bank accounts are equal and false otherwise
   */
  public static boolean testBankAccountEquals() {
    BankAccount capitalOneNebraska = new BankAccount("4", 123);
    BankAccount capitalOneOhio = new BankAccount("4", 123);
    if(capitalOneNebraska.equals(capitalOneOhio)) {
      return true;
    }
    else {
      return false; 
    }
  }
  /**
   * test to see if the withdraw method throws a DataFormatException when passed a negative value 
   * and a DataFormatException if it is passed a value that is not divisible by 10
   * @return true if both tests throw an exception and false otherwise
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount chase = new BankAccount("5", 2000);
    boolean negative = false;
    boolean divisible = false;
    try {
      chase.withdraw(-100);
    }
    catch(DataFormatException e) {
      System.out.println(e.getMessage());
      negative = true;
    }
    try {
      chase.withdraw(14);
    }
    catch(DataFormatException e) {
      System.out.println(e.getMessage());
      divisible = true;
    }
    if(negative == true && divisible == true) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Tests whether the withdraw method throws an IllegalStateException when passed a value that is 
   * larger than its current balance
   * @return true if the IllegalStateException is thrown and false otherwise
   * @throws DataFormatException can be thrown by the withdraw method
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() throws DataFormatException{
    BankAccount bankOfAmerica = new BankAccount("6", 1200);
    try {
      bankOfAmerica.withdraw(2000);
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }
  /**
   * Tests whether the withdraw method throws a DataFormatException or an IllegalStateException when 
   * passed a valid amount 
   * @return false if any exception is thrown and true otherwise
   * @throws DataFormatException can be thrown by the withdraw method
   */
  public static boolean testBankAccountWithdrawValidAmount() throws DataFormatException{
    BankAccount deutscheBank = new BankAccount("7", 1000);
    try {
      deutscheBank.withdraw(100);
    }
    catch(DataFormatException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }
  
}