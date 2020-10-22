import java.util.NoSuchElementException;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 SJF Process Scheduler
// Files: WaitingProcessQueue.java
// CustomProcess.java
// ProcessScheduler.java
// ProcessSchedulerTester.java
// Course: CS 300, Fall 2019
//
// Author: Ishaan Backliwal
// Email: backliwal@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: N/A
// Online Sources: The Java API
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * Class to test various methods implemented in this project
 * 
 * @author Ishaan Backliwal
 *
 */
public class ProcessSchedulerTester {
  /**
   * Main method that runs each test method in this class and prints their results
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testInsertWaitingProcessQueue());
    System.out.println(testRemoveBestWaitingProcessQueue());
    System.out.println(testSizeWaitingProcessQueue());
    System.out.println(testIsEmptyWaitingProcessQueue());
  }

  /**
   * Checks the correctness of the insert operation implemented in the WaitingProcessQueue class
   * 
   * @return true if all tests run appropriately, false otherwise
   */
  public static boolean testInsertWaitingProcessQueue() {
    CustomProcess reset = new CustomProcess(1);
    reset.initNextProcessID();
    boolean condition1 = false;
    boolean condition2 = false;
    boolean condition3 = false;
    boolean condition4 = false;
    boolean overall = false;
    try {
      WaitingProcessQueue test = new WaitingProcessQueue();
      CustomProcess ten = new CustomProcess(10);
      CustomProcess fifteen = new CustomProcess(15);
      CustomProcess five = new CustomProcess(5);
      CustomProcess one = new CustomProcess(1);
      test.insert(ten);
      if (test.peekBest().equals(ten))
        condition1 = true;
      test.insert(fifteen);
      if (test.peekBest().equals(ten))
        condition2 = true;
      test.insert(five);
      if (test.peekBest().equals(five))
        condition3 = true;
      test.insert(one);
      if (test.peekBest().equals(one))
        condition4 = true;
      if (condition1 && condition2 && condition3 && condition4) {
        overall = true;
      }
    } catch (NoSuchElementException e) {
      overall = false;
    } catch (IllegalArgumentException e) {
      overall = false;
    }
    return overall;
  }

  /**
   * Checks the correctness of the removeBest operation implemented in the WaitingProcessQueue class
   * 
   * @return true if all tests run appropriately, false otherwise
   */
  public static boolean testRemoveBestWaitingProcessQueue() {
    CustomProcess reset = new CustomProcess(1);
    reset.initNextProcessID();
    boolean condition = false;
    try {
      WaitingProcessQueue test = new WaitingProcessQueue();
      CustomProcess best = new CustomProcess(1);
      test.insert(best);
      test.insert(new CustomProcess(2));
      test.insert(new CustomProcess(3));
      CustomProcess removed = test.removeBest();
      String testerString = "p2(2) p3(3)";
      if (best.equals(removed))
        if (test.toString().compareTo(testerString) == 0)
          condition = true;
    } catch (NoSuchElementException e) {
    } catch (IllegalArgumentException e) {
    }
    return condition;
  }

  /**
   * Checks the correctness of the size operation implemented in the WaitingProcessQueue class
   * 
   * @return true if all tests run appropriately, false otherwise
   */
  public static boolean testSizeWaitingProcessQueue() {
    WaitingProcessQueue test = new WaitingProcessQueue();
    test.insert(new CustomProcess(2));
    test.insert(new CustomProcess(3));
    test.insert(new CustomProcess(4));
    test.insert(new CustomProcess(5));
    if (test.size() == 4) {
      return true;
    }
    return false;
  }

  /**
   * Checks the correctness of the isEmpty operation implemented in the WaitingProcessQueue class
   * 
   * @return true if all tests run appropriately, false otherwise
   */
  public static boolean testIsEmptyWaitingProcessQueue() {
    WaitingProcessQueue test = new WaitingProcessQueue();
    return test.isEmpty();
  }
}


