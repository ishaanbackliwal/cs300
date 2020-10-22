import java.util.NoSuchElementException;
import java.util.Scanner;

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
 * This class represents the data type for the main scheduler for all the processes in this
 * application
 * 
 * @author Ishaan Backliwal
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private WaitingProcessQueue queue; // this processing unit’s queue

  /**
   * No argument constructor that initializes all instance fields
   */
  public ProcessScheduler() {
    queue = new WaitingProcessQueue();
    currentTime = 0;
    numProcessesRun = 0;
  }

  /**
   * This method inserts the given process in the WaitingProcessQueue queue.
   * 
   * @param process is the process to be inserted
   */
  public void scheduleProcess(CustomProcess process) {
    queue.insert(process);
  }

  /**
   * Runs the ready processes already scheduled in this processScheduler’s queue
   * 
   * @return a string with all formatted information
   */
  public String run() {
    String finalString = "Starting " + queue.size() + " processes\n\n";
    while (!queue.isEmpty()) {
      finalString = finalString.concat("Time " + currentTime + " : Process ID "
          + queue.peekBest().getProcessId() + " Starting.\n");
      currentTime += queue.peekBest().getBurstTime();
      finalString = finalString.concat("Time " + currentTime + " : Process ID "
          + queue.peekBest().getProcessId() + " Completed.\n");
      queue.removeBest();
      numProcessesRun++;
    }
    finalString =
        finalString.concat("\nTime " + currentTime + ": All scheduled processes completed.\n");
    return finalString;
  }

  /**
   * Takes input and prints appropriate information based on the input commands
   * 
   * @param args
   */
  public static void main(String[] args) {
    ProcessScheduler driver = new ProcessScheduler();
    Scanner input = new Scanner(System.in);
    String command = " ";
    System.out.println("========== Welcome to the SJF Process Scheduler App ========");
    try {
      while (command.compareTo("quit") != 0 && command.compareTo("q") != 0) {
        System.out.println(
            "\nEnter command:\n[schedule <burstTime>] or [s <burstTime>]\n[run] or [r]\n[quit] or [q]\n");
        command = input.nextLine();
        String[] spliter = command.split(" "); // splits command and potential burst time
        if (spliter.length == 2) {
          if (spliter[0].compareTo("schedule") == 0 || spliter[0].compareTo("s") == 0) { // if the
                                                                                         // command
                                                                                         // is to
                                                                                         // schedule
            try {
              Integer.parseInt(spliter[1]);
            } catch (NumberFormatException e) {
              System.out.println("WARNING: burst time MUST be an integer!\n"); // warning if user
                                                                               // inputs non integer
                                                                               // value
            }
            CustomProcess add = new CustomProcess(Integer.parseInt(spliter[1]));
            driver.scheduleProcess(add);
            System.out.println("Process ID " + add.getProcessId() + " scheduled. Burst Time = "
                + add.getBurstTime() + "\n");
          }
        } else {
          if (command.compareTo("run") == 0 || command.compareTo("r") == 0) { // if command is to
                                                                              // run
            System.out.println(driver.run()); // call the run method
          } else if (command.compareTo("quit") != 0 && command.compareTo("q") != 0) {
            System.out.println("WARNING: Please enter a valid command!"); // warning is any
                                                                          // formatting or command
                                                                          // input is incorrect
          }
        }
      }
    } catch (NoSuchElementException e) { // prints error if caught while running program
      System.out.println(e);
    } catch (IllegalArgumentException e) { // prints error if caught while running program
      System.out.println(e);
    }
    System.out.println(driver.numProcessesRun + " processes run in " + driver.currentTime
        + " units of time!\nThank you for using our scheduler!\nGoodbye!\n");
  }
}


