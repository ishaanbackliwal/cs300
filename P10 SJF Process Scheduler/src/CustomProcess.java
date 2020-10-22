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
 * This class represents the data type for the processes used in this application.
 * 
 * @author Ishaan Backliwal
 */
public class CustomProcess implements Comparable<CustomProcess> {
  private static int nextProcessId = 1; // stores the id to be assigned to the next process
                                        // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  public CustomProcess(int burstTime) {
    if (burstTime <= 0)
      throw new IllegalArgumentException("Provided burst time is not a non-zero number.");
    this.burstTime = burstTime;
    PROCESS_ID = nextProcessId;
    nextProcessId++;
  }

  /**
   * Returns a String representation of this CustomProcess
   * 
   * @return a string representation of this CustomProcess
   */
  public String toString() {
    return "p" + this.PROCESS_ID + "(" + this.burstTime + ")";
  }

  /**
   * Compares this CustomProcess with another one and sees if one is greater than, less than, or
   * equal to the other
   * 
   * @return 1 if this is greater than other, -1 if less than, or 0 if equal
   */
  public int compareTo(CustomProcess other) {
    if (burstTime > other.burstTime)
      return 1;
    if (burstTime < other.burstTime)
      return -1;
    if (PROCESS_ID > other.PROCESS_ID)
      return 1;
    if (PROCESS_ID < other.PROCESS_ID)
      return -1;
    return 0;
  }

  /**
   * Gets this objects process id
   * 
   * @return the process id of this object
   */
  public int getProcessId() {
    return PROCESS_ID;
  }

  /**
   * Gets the burst time of this object
   * 
   * @return the burst time of this object
   */
  public int getBurstTime() {
    return burstTime;
  }

  /**
   * Initializes the nextProcessId to zero. This method can be called at the beginning of the test
   * methods.
   */
  static void initNextProcessID() {
    CustomProcess.nextProcessId = 1;
  }
}
