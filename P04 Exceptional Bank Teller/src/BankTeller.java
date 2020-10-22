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
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class BankTeller {
  
  private ArrayList<BankAccount> accounts;
  
  /**
   * Default constructor that initializes the accounts array list of BankAccount objects
   */
  public BankTeller() {
    accounts = new ArrayList<BankAccount>();
  }
  /**
   * Adds a new bank account to the account array list and test to see whether an account with the 
   * same id already exists and if the account passed is null 
   * @param newAccount is the bank account being added
   * @throws IllegalStateException if an account with the same identifier already exists
   * @throws IllegalArgumentException if the account is null
   */
  public void addBankAccount(BankAccount newAccount) {
    for(int i = 0; i < accounts.size(); i++) {
      if(accounts.get(i).getID().compareTo(newAccount.getID()) == 0) {
        throw new IllegalStateException("Account ID already exists");
      }
    }
    if(newAccount == null) {
      throw new IllegalArgumentException("Account is null");
    }
    accounts.add(newAccount);
    
  }
  /**
   * Adds a transaction to the specific bank account being passed to the method and makes sure to 
   * test whether the format of the transaction is correct
   * @param transaction is the transaction being added to the bank account
   * @param account is the bank account to which a transaction is being added
   * @throws DataFormatException if the transaction is not properly formatted
   * @throws NullPointerException if the account is null
   */
  public void addTransaction(String transaction, BankAccount account) throws DataFormatException{
    String split[] = transaction.split(" ");
    if(account == null) {
      throw new NullPointerException();
    }
    if(split[0].compareTo("0") != 0 || split[0].compareTo("1") != 0) {
      throw new DataFormatException("Transaction not properly formatted");
    }
    if(split[0].compareTo("0") == 0) {
      account.withdraw(Integer.valueOf(split[split.length-1]));
    }
    else {
      account.deposit(Integer.valueOf(split[split.length-1]));
    }
  }
  /**
   * Gets an account with the same id that is being passed to the method
   * @param id is the id being used to find the account
   * @throws NoSuchElementException if no bank account with the identifier passed exists
   * @return the account who's id matches the parameter the method was passed
   */
  public BankAccount findAccount(String id) {
    BankAccount returnThis = null;
    for(int i = 0; i < accounts.size(); i++) {
      if(accounts.get(i).getID().compareTo(id) == 0) {
        returnThis = accounts.get(i);
      }
    }
    if(returnThis == null) {
      throw new NoSuchElementException("No such account in this bank with that ID");
    }
    return returnThis;
  }
  /**
   * Gets the size of the account array list
   * @return an integer representing the size of the accounts array list
   */
  public int getAccountsCount() {
    return accounts.size();
  }
  /**
   * Goes through a passed file and adds the transactions in that file to the specified bank account
   * @param file is the file being searched for transaction to be added
   * @param account is the specific bank account to which the transactions are needed to be added to
   * @throws DataFormatException if addTransaction throws this exception
   * @throws FileNotFoundException if addTransaction throws this exception
   * @throws NullPointerException if addTransaction throws this exception
   */
  public void loadTransactions(File file, BankAccount account) throws FileNotFoundException, 
    DataFormatException{
    if(!file.exists()) {
      throw new FileNotFoundException("File object does not correspond to an actual file within "
          + "the file system");
    }
    Scanner fileReader = null;
    try {
      do{
        fileReader = new Scanner(file);
        String transaction = fileReader.nextLine().trim();
        if(transaction.startsWith("0") || transaction.startsWith("1")){
          addTransaction(transaction, account);
          
        }
      }
      while(fileReader.hasNextLine());
    }
    catch(DataFormatException e) {
      throw e;
    }
    catch(NullPointerException e) {
      throw e;
    }
    catch(FileNotFoundException e) {
      throw e;
    }
    finally {
      fileReader.close();
    }
  }
}
