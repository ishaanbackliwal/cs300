//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P08 Ascii Art
// Files:           DrawingChange.java
//                  DrawingStack.java
//                  DrawingStackIterator.java
//                  AsciiArtTester.java
//                  Canvas.java
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
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class is the iterator for DrawingStack and is used for the implementation of undo and redo
 * methods in the Canvas class
 * @author Ishaan Backliwal
 */
public class DrawingStackIterator implements Iterator <DrawingChange>{
  
  private LinkedNode <DrawingChange> next;
  
  /**
   * The one argument constructor of this class that initializes next
   * @param top is the next element
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> top) {
    next = top;
  }
  @Override
  /**
   * Tests whether or not there is a enxt element
   * @return true if there is a next element, false otherwise
   */
  public boolean hasNext() {
    if(next == null) {
      return false;
    }
    return true;
  }
  @Override
  /**
   * Iterates to the next element
   * @return the next current element
   * @throws NoSuchElementException if there is no next element
   */
  public DrawingChange next() throws NoSuchElementException {
    if(next == null) {
      throw new NoSuchElementException("There is no next element");
    }
    LinkedNode<DrawingChange> current = new LinkedNode<DrawingChange>(next.getData());
    next = next.getNext();
    return current.getData();
  }

}
