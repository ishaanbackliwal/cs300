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
import java.lang.Iterable;
import java.util.EmptyStackException;
import java.util.Iterator;
/**
 * This class overrides StackADT methods in terms of the solution
 * @author Ishaan Backliwal
 */
public class DrawingStack implements Iterable<DrawingChange>, StackADT<DrawingChange> {

  private LinkedNode<DrawingChange> top;
  private int size; // size of the stack
  /**
   * The no argument constructor of this class that initializes the instance fields
   */
  public DrawingStack() {
    top = null;
    size = 0;
  }
  @Override
  /**
   * This is the iterator method
   * @return a new DrawingStackIterator that starts at the top of the stack of DrawingChanges
   */
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(top); //new DrawingStackIterator(top);
  }
  @Override
  /**
   * Push method that adds a new DrawingChange to the top of the stack and pushes the existing 
   * elements towards the front
   * @param element is the DrawingChange object that is being added to the stack
   * @throws IllegalArgumentException if the passed element is null
   */
  public void push(DrawingChange element) {
    if(element == null) {
      throw new IllegalArgumentException("The element passed is null.");
    }
    LinkedNode<DrawingChange> add = new LinkedNode<DrawingChange>(element);
    if(top == null) {
      top = add;
    }
    else {
      add.setNext(top);
      top = add;
    }
    size++; 
  }
  @Override
  /**
   * The pop method that removes the DrawingChange element at the top of the stack
   * @return the removed element
   * @throws EmptyStackException if the stack is empty
   */
  public DrawingChange pop() {
    if(this.isEmpty()) {
      throw new EmptyStackException();
    }
    DrawingChange poppedData = top.getData();
    top = top.getNext();
    size--;
    return poppedData;
  }
  @Override
  /**
   * Peek method that returns, without removing, the element at the top of the stack
   * @return the element at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public DrawingChange peek() {
    if(this.isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getData();
  }
  @Override
  /**
   * Method that tests wheteher of not the stack is empty
   * @return true if the stack is empty and false otherwise
   */
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    return false;
  }
  @Override
  /**
   * Getter method for the size of the stack
   * @return the size of the stack
   */
  public int size() {
    return size;
  }

}
