//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P06 Mega Blocks Builder
// Files:           MegaBlock.java
//                  MegaBlockBuilderTester.java
//                  LinkedMegaBlock.java
//                  LinkedListMegaBlock.java
//                  Color.java
// Course:          CS 300, fall 2019
//
// Author:          Malcolm Balles
// Email:           mballes@wisc.edu
// Lecturer's Name: Mouna
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ishaan Backliwal
// Partner Email:   backliwal@wisc.edu
// Partner Lecturer's Name: Gary
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         none
// Online Sources:  http://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2019/10/p6javadocs/index.html
//                  gave javadocs as instructions on what methods to code
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class tests 
 * @author Malcolm Balles and Ishaan Backliwal
 *
 */
public class LinkedListMegaBlock {
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  /**
   * Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Returns true if this list contains no elements.
   * 
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * Returns the size of this list
   * 
   * @return the number of megablocks stored in this list
   */
  public int size() {
    return size;
  }

  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    tail = null;
    head = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;

  }

  /**
   * Adds a blueBlock at the end of this list
   * 
   * @param blueBlock - new element to be added to this list
   * @throws IllegalArgumentException - if blueBlock is null or if the color of the specific
   *                                  blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) throws IllegalArgumentException {
    if (blueBlock == null)
      throw new IllegalArgumentException("Error: MegaBlock cannot be null");
    if (blueBlock.equals(new MegaBlock(Color.BLUE, 'r')) == false) // test if blueBlock is blue
      throw new IllegalArgumentException("Error: MegaBlock has to be blue to use addBlue");
    LinkedMegaBlock add = new LinkedMegaBlock(blueBlock); // block to be added
    if (head == null) { // if empty list, make this the head and tail
      head = add;
      tail = add;
      size++;
      blueCount++;
    } else { // else put it on the end and make it the new tail
      tail.setNext(add);
      tail = tail.getNext();
      size++;
      blueCount++;
    }

  }

  /**
   * Adds a new object at the head of this list
   * 
   * @param redBlock - new element to be added to this list
   * @throws IllegalArgumentException - if redBlock is null or if its color does not equal to
   *                                  Color.RED
   */
  public void addRed(MegaBlock redBlock) throws IllegalArgumentException {
    if (redBlock == null)
      throw new IllegalArgumentException("Error: MegaBlock cannot be null");
    if (redBlock.equals(new MegaBlock(Color.RED, 'r')) == false)// tes if redblock is red
      throw new IllegalArgumentException("Error: MegaBlock has to be red to use addRed");
    LinkedMegaBlock add = new LinkedMegaBlock(redBlock); // block to be added
    if (head == null) { // if empty list, make this the head and tail
      head = add;
      tail = add;
      size++;
      redCount++;
    } else { // else make this the link old head to this' next and set this as the new head
      add.setNext(head);
      head = add;
      size++;
      redCount++;
    }
  }

  /**
   * Adds the provided yellowBlock at the position index in this list
   * 
   * @param index       - index at which the specified yellow block is to be inserted
   * @param yellowBlock - new element to be added to this list
   * @throws IllegalArgumentException  - if yellowBlock is null or if it does not have a
   *                                   Color.YELLOW color
   * @throws IndexOutOfBoundsException - if the index is out of the range reserved for yellow blocks
   *                                   (index < redCount || index > size - blueCount)
   */
  public void addYellow(int index, MegaBlock yellowBlock)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    if (yellowBlock == null)
      throw new IllegalArgumentException("Error: MegaBlock cannot be null");
    if (yellowBlock.equals(new MegaBlock(Color.YELLOW, 'r')) == false)// test if block is yellow
      throw new IllegalArgumentException("Error: MegaBlock has to be yellow to use addYellow");
    if (index < redCount || index > size - blueCount) // make sure index is between red and blue
      throw new IndexOutOfBoundsException("Error: Entered index is not a yellow MegaBlock");
    LinkedMegaBlock add = new LinkedMegaBlock(yellowBlock); // new block to be added
    if (head == null) { // if empty list, make this the head and tail
      head = add;
      tail = add;
      size++;
      yellowCount++;
    } else {// if else, put in the correct index
      LinkedMegaBlock curr = head; // current node code is looking at
      if (index == 0) { // if index is 0, make this the new head and link it properly
        add.setNext(head);
        head = add;
      } else {// if not 0, then add normally
        for (int c = 0; c < index - 1; c++) {// cycles current node to node before the index
          curr = curr.getNext();
        }
        add.setNext(curr.getNext()); // adds new block between current node and its next node
        curr.setNext(add);
        if (add.getNext() == null) {// if added block is at the end, makes it the new tail
          tail = add;
        }
      }
      size++;
      yellowCount++;
    }
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index - position within this list
   * @return the megablock object stored at position index of this list
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size)// makes sure index is within the list
      throw new IndexOutOfBoundsException("Error: Index must be bteween 0 and the size of list");
    LinkedMegaBlock curr = head; // sets current node counter
    for (int c = 0; c < index; c++) {// sets the current node to wanted index
      curr = curr.getNext();
    }
    return curr.getBlock();// returns wanted block
  }

  /**
   * Replaces the megablock at the specified position in this list with the specified element if
   * they have the same Color
   * 
   * @param index - index of the block to replace
   * @param block - element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IllegalArgumentException  - if object is null or is not equal to the megablock already
   *                                   at at index position
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock set(int index, MegaBlock block)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    if (block == null)
      throw new IllegalArgumentException("Error: MegaBlock cannot be null");
    if (index < 0 || index >= size) // make sure index is a proper index
      throw new IndexOutOfBoundsException("Error: Index must be between 0 and the size of list");
    LinkedMegaBlock curr = head; // sets up current node counter
    for (int c = 0; c < index; c++) {// sets current node to the desired index
      curr = curr.getNext();
    }
    LinkedMegaBlock old = new LinkedMegaBlock(curr.getBlock()); // saves old node data
    if (old.getBlock().equals(block) == false) // makes sure new block is the same color as old
      throw new IllegalArgumentException("Error: New MegaBlock must be same color as old");
    curr.setBlock(block); // sets the new block desired index and returns old data
    return old.getBlock();
  }

  /**
   * Removes and returns the mega block at the head of this list if its color is red
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException - if this list does not contain any red mega block
   */
  public MegaBlock removeRed() throws NoSuchElementException {
    if (redCount == 0)
      throw new NoSuchElementException("Error: No red blocks to remove");
    LinkedMegaBlock old = new LinkedMegaBlock(head.getBlock()); // copies old data
    head = head.getNext();// sets new head to the data after the old head, removing it
    size--;
    redCount--;
    return old.getBlock();
  }

  /**
   * Removes and returns the element at the tail of this list if it has a blue color
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException - if this list does not contain any blue block
   */
  public MegaBlock removeBlue() throws NoSuchElementException {
    if (blueCount == 0)
      throw new NoSuchElementException("Error: No blue blocks to remove");
    LinkedMegaBlock old = new LinkedMegaBlock(tail.getBlock()); // copies old data
    if (head == tail) {// if head is also the tail, make an empty list
      head = null;
      size--;
      blueCount--;
      tail = null;
      return old.getBlock();
    } // else take data right before tail, and make it the new tail
    resetTail(); // helper method that removes tail and resets it
    size--;
    blueCount--;
    return old.getBlock();
  }

  /**
   * Removes and returns the element stored at index position in this list
   * 
   * @param index - position of the element to remove in this list
   * @return a reference to the removed element
   * @throws NoSuchElementException - if the index is out of range (index < redCount or index >=
   *                                size - blueCount)
   */
  public MegaBlock removeYellow(int index) throws NoSuchElementException {
    if (index < redCount || index >= size - blueCount)// makes sure index is between red and yellow
      throw new NoSuchElementException("Error: No yellow blocks to remove");
    LinkedMegaBlock curr = head; // sets up current node counter
    for (int c = 0; c < index - 1; c++) { // sets the current node to the one before the index
      curr = curr.getNext();
    }
    LinkedMegaBlock old = new LinkedMegaBlock(curr.getBlock()); // copies data
    if (tail == head) {// head and tail are the same, set to empty list
      old = new LinkedMegaBlock(tail.getBlock()); // copies data
      head = null;
      tail = null;
    } else if (curr.getNext() == tail) { // if index is the tail, remove and reset tail
      old = new LinkedMegaBlock(tail.getBlock()); // copies data
      resetTail();// helper method that resets and removes tail

    } else if (index == 0) {// if index is 0, remove and reset head
      old = new LinkedMegaBlock(head.getBlock());// copies data
      head = head.getNext();
    } else {// if a normal case (index 1 to size-2)
      old = new LinkedMegaBlock(curr.getBlock()); // copies data
      curr.setNext(curr.getNext().getNext()); // connects current (which is one before index) to
                                              // one after index, deleting it
    }
    yellowCount--;
    size--;
    return old.getBlock();
  }

  /**
   * Returns the number of red mega bloks stored in this list
   * 
   * @return the redCount
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * Returns the number of yellow mega bloks stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * Returns the number of blue mega bloks stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * Returns a String representation of the contents of this list
   * 
   * @return return a String representation of the content of this list. If this list is empty, an
   *         empty String ("") will be returned.
   */
  @Override
  public String toString() {
    String to = "";
    if (head == null)// if empty return empty string
      return to;
    LinkedMegaBlock curr = head; // set up current node counter
    while (curr.getNext() != null) {// go through list adding each megablocks 2 string to the string
      to = to.concat(curr.toString());
      curr = curr.getNext();
    }
    return to + curr.toString();// once current node's next is null, add its string and return it
  }

  /**
   * Used any time a remove color is used as is the tail. Finds the reference before the tail, sets
   * the tail to it, and then removes the old tail, removing that element from the list.
   */
  private void resetTail() {
    LinkedMegaBlock curr = head; // set up current node counter
    while (curr.getNext() != tail) {// sets current node to 1 before the tail
      curr = curr.getNext();
    }
    tail = curr; // sets tail to current node and removes old tail.
    curr.setNext(null);
  }

}
