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
 * This class implements the WaitingQueueADT interface of CustomProcesses
 * 
 * @author Ishaan Backliwal
 */
public class WaitingProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of this
                                                  // waiting process queue
  private CustomProcess[] data; // min heap-array storing the CustomProcesses
                                // inserted in this WaitingProcessQueue.
                                // data is an oversize array
  private int size; // number of CustomProcesses stored in this WaitingProcessQueue

  /**
   * No argument constructor that initializes the data array and size
   */
  public WaitingProcessQueue() {
    data = new CustomProcess[INITIAL_CAPACITY];
    size = 0;
  }

  /**
   * inserts a newObject in this waiting queue.
   * 
   * @param newObject to insert in this waiting queue
   */
  @Override
  public void insert(CustomProcess newObject) {
    if (size == data.length) {
      CustomProcess[] copy = new CustomProcess[size * 2];
      for (int i = 0; i < size; i++) {
        copy[i] = data[i];
      }
      data = copy;
    }
    data[size] = newObject;
    minHeapPercolateUp(size);
    size++;
  }

  /**
   * removes and returns the element with the highest priority.
   * 
   * @return the removed element
   * @throws java.util.NoSuchElementException with a descriptive error message if this waiting queue
   *         is empty
   */
  @Override
  public CustomProcess removeBest() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("This waiting queue is empty.");
    }
    CustomProcess removed = data[0];
    data[0] = data[size - 1];
    data[size - 1] = null;
    minHeapPercolateDown(0);
    size--;
    return removed;
  }

  /**
   * returns without removing the element with the highest priority.
   * 
   * @return the element with the highest priority
   * @throws java.util.NoSuchElementException with a descriptive error message if this waiting queue
   *         is empty
   */
  @Override
  public CustomProcess peekBest() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("This waiting queue is empty.");
    }
    return data[0];
  }

  /**
   * returns size of priority queue
   * 
   * @return the size of priority queue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * checks whether this waiting queue is empty or not.
   * 
   * @return true if this waiting queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Percolates up the node at the given index using the min-heap system
   * 
   * @param index is the item being percolated up
   */
  private void minHeapPercolateUp(int index) {
    CustomProcess node = data[index];
    CustomProcess parent = data[(index - 1) / 2];
    if (node.compareTo(parent) < 0) {
      data[index] = parent;
      data[(index - 1) / 2] = node;
      minHeapPercolateUp((index - 1) / 2);
    }
  }

  /**
   * Percolates down the node at the given index using the min-heap system
   * 
   * @param index is the item being percolated down
   */
  private void minHeapPercolateDown(int index) {
    CustomProcess node = data[index];
    CustomProcess leftChild = data[(index * 2) + 1];
    CustomProcess rightChild = data[(index * 2) + 2];
    if (leftChild != null) {
      if (node.compareTo(leftChild) > 0) {
        data[index] = leftChild;
        data[(index * 2) + 1] = node;
        minHeapPercolateDown((index * 2) + 1);
      } else {
        if (node.compareTo(rightChild) > 0) {
          data[index] = rightChild;
          data[(index * 2) + 2] = node;
          minHeapPercolateDown((index * 2) + 2);
        }
      }
    }
  }

  /**
   * creates a string representation of the entire queue
   * 
   * @return a string representation of the queue
   */
  public String toString() {
    if (this.isEmpty()) {
      return " ";
    }
    String rep = data[0].toString();
    for (int i = 1; i < size; i++) {
      rep = rep.concat(" " + data[i].toString());
    }
    return rep;
  }
}


