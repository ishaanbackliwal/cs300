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
/**
 * This class records the details of a single change made to the canvas
 * @author Ishaan Backliwal
 */
public class DrawingChange {
  
  public final int row; // row (y-coordinate) for this DrawingChange
  public final int col; // col (x-coordinate) for this DrawingChange
  public final char prevChar; // previous character in the (row,col) position
  public final char newChar; // new character in the (row,col) position
  /**
   * Four argument constructor for this class that initializes all final instance fields
   * @param row is the row in which the change is being made
   * @param col is the column in which the change is being made
   * @param prevChar is the previous character that is being changed
   * @param newChar is the new character that is the change
   */
  public DrawingChange(int row, int col, char prevChar, char newChar) {
    this.row = row;
    this.col = col;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
  
  
}
