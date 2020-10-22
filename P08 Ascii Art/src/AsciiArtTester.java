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
import java.util.EmptyStackException;
import java.util.Iterator;
/**
 * This class tests numerous methods in the project
 * @author Ishaan Backliwal
 */
public class AsciiArtTester {
  /**
   * Main method that runs the ascii art test suite method
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(runAsciiArtTestSuite());
  }
  /**
   * Tester method for DrawingStack's push, peek, and pop methods
   * @return true if all tests run appropriately, false otherwise
   */
  public static boolean testStackPushPeek(){
    DrawingStack stack = new DrawingStack();
    try {
      stack.peek();
      return false;
    }
    catch(EmptyStackException e) {}
    DrawingChange data = new DrawingChange(0, 1, 'a', 'b');
    stack.push(data);
    if(!stack.peek().equals(data)) {
      return false;
    }
    stack.push(new DrawingChange(2, 3, 'd', 'e'));
    DrawingChange data2 = new DrawingChange(4, 5, 'f', 'g');
    stack.push(data2);
    DrawingChange data3 = new DrawingChange(6, 7, 'h', 'i');
    stack.push(data3);
    if(!stack.peek().equals(data3)) {
      return false;
    }
    DrawingChange popped = stack.pop();
    if(popped != data3 || !stack.peek().equals(data2)) {
      return false;
    }
    return true;
  }
  /**
   * Runs all four other tester methods in this class
   * @return true if all tester methods return true, false otherwise
   */
  public static boolean runAsciiArtTestSuite() {
    if(!testStackPushPeek()) {
      return false;
    }
    if(!testDrawingStackIterator()) {
      return false;
    }
    if(!testIteratorHasNext()) {
      return false;
    }
    if(!testIteratorNext()) {
      return false;
    }
    return true;
  }
  /**
   * Tests the functionality of the DrawingStackIterator class
   * @return true if all tests run appropriately, false otherwise
   */
  public static boolean testDrawingStackIterator() {
    DrawingStack stack = new DrawingStack();
    stack.push(new DrawingChange(0, 0, 'a', 'b'));
    stack.push(new DrawingChange(0, 1, 'a', 'b'));
    stack.push(new DrawingChange(0, 2, 'a', 'b'));
    int count = 2;
    boolean condition = true;
    for(DrawingChange x : stack) {
      if(x.row != 0)
        condition = false;
      if(x.col != count)
        condition = false;
      if(x.prevChar != 'a')
        condition = false;
      if(x.newChar != 'b')
        condition = false;
      count--;
    }
    return condition;
  }
  /**
   * This method tests the hasNext() method of the DrawingStackIterator
   * @return true if the test runs appropriately, false otherwise
   */
  public static boolean testIteratorHasNext() {
    DrawingStack stack = new DrawingStack();
    stack.push(new DrawingChange(0, 0, 'a', 'b'));
    stack.push(new DrawingChange(0, 1, 'a', 'b'));
    Iterator<DrawingChange> iterator = stack.iterator();
    if(!iterator.hasNext()) 
      return false;
    return true;
  }
  /**
   * This method tests the next() method of the DrawingStackIterator
   * @return true if the test runs appropriately, false otherwise
   */
  public static boolean testIteratorNext() {
    DrawingStack stack = new DrawingStack();
    DrawingChange change = new DrawingChange(0, 1, 'a', 'b');
    stack.push(new DrawingChange(0, 0, 'a', 'b'));
    stack.push(change);
    Iterator<DrawingChange> iterator = stack.iterator();
    if(iterator.next().equals(change))
      return true;
    return false;
  }
}
