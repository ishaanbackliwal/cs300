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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class BankTellerTester {
  
  /**
   * The main method that runs each tester method in this class and outputs their return values
   * @param args
   */
  public static void main(String[] args) throws FileNotFoundException, DataFormatException {
    System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    System.out.println(testBankTellerConstructor());
    System.out.println(testBankTellerLoadTransactionsFileNotFound());
  }
  /**
   * Explicit default constructor
   */
  public BankTellerTester() {
    
  }
  /**
   * Tests the addBankAccount method to see if adding two bank account with the same ID throws an
   * IllegalStateException
   * @return true if IllegalStateException is thrown, false otherwise
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    BankTeller man = new BankTeller();
    try {
      man.addBankAccount(new BankAccount("1", 1000));
      man.addBankAccount(new BankAccount("1", 1200));
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }
  /**
   * Tests whether the bank teller default constructor method creates an array list of size 0
   * @return true if array list size is 0, false otherwise
   */
  public static boolean testBankTellerConstructor() {
    BankTeller woman = new BankTeller();
    if(woman.getAccountsCount() != 0) {
      return false;
    }
    return true;
  }
  /**
   * Tests whether the loadTransaction method throws a FileNotFoundException exception when passed a
   * nonexistent file
   * @return true if FileNotFoundException is thrown, false otherwise
   * @throws DataFormatException --> can be thrown by loadTransactions method
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() throws DataFormatException{
    BankTeller human = new BankTeller();
    try {
      human.loadTransactions(new File("/Users/Hello/GoodMorning/HowAreYou/Yo.java"), 
          new BankAccount("1", 1000));
    }
    catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
      return true;
    }
    return false;
  }

}
