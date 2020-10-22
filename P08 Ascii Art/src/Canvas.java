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
 * This class represents an ASCII-art image
 * @author Ishaan Backliwal
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char [][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  /**
   * Constructor creates a new canvas which is initially blank
   * @param width is the width of the new array/canvas
   * @param height is the height of the new array/canvas
   * @throws IllegalArgumentException if the width or height of the canvas 0 or negative
   */
  public Canvas(int width, int height) {
    if(width < 1) {
      throw new IllegalArgumentException("Width cannot be less than 1");                            //Throws an IllegalArgumentException with a descriptive error message if width or height is 0 or negative.
    }
    if(height < 1) {
      throw new IllegalArgumentException("Height cannot be less than 1");
    }
    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }
  /**
   * Draws a character at the given position drawingArray[row][col]
   * @param row is the row position where the character is going to be drawn
   * @param col is the column position where the character is going to be drawn
   * @param c is the character being drawn onto the canvas
   */
  public void draw(int row, int col, char c) {
    if(row >= height || col >= width) {
      throw new IllegalArgumentException("Drawing position is outside the canvas.");                //Throws an IllegalArgumentException if the drawing position is outside the canvas
    }
    undoStack.push(new DrawingChange(row, col, drawingArray[row][col], c));                         //Adds a matching DrawingChange to the undoStack so that it is possible to undo if needed.
    drawingArray[row][col] = c;
    while(!redoStack.isEmpty()) {                                                                   //Clear the redoStack if it is not already empty
      redoStack.pop();
    }
  }
  /**
   * Undo the most recent drawing change
   * @return true of successful, false otherwise
   */
  public boolean undo() {
    if(undoStack.isEmpty()) {
      return false;
    }
    DrawingChange prev = undoStack.pop();                                                           //Undone DrawingChange is popped off the undoStack.
    DrawingChange change = new DrawingChange(prev.row, prev.col, prev.newChar, prev.prevChar);
    redoStack.push(change);                                                                         //Undone DrawingChange is added to the redoStack so that it is possible to redo if needed.
    drawingArray[change.row][change.col] = change.newChar;                                          //The content of the drawingArray is updated accordingly to this change
    return true;
  }
  /**
   * Redo the most recent drawing change
   * @return true of successful, false otherwise
   */
  public boolean redo() {
    if(redoStack.isEmpty()) {
      return false;
    }
    DrawingChange prev = redoStack.pop();                                                           //Redone DrawingChange is popped off the redoStack.
    DrawingChange change = new DrawingChange(prev.row, prev.col, prev.newChar, prev.prevChar);
    drawingArray[change.row][change.col] = change.newChar;                                          //The content of the drawingArray is updated accordingly to this change.
    undoStack.push(change);                                                                         //Redone DrawingChange is added (back) to the undoStack so that it is possible to undo again if needed.
    return true;
  }
  /**
   * Converts the array into a string representation that can be printed
   * @return the string representation of the array
   */
  public String toString() {
    String printer = "";
    for(int i = 0; i  < drawingArray.length; i ++) {
      for(int j = 0; j < drawingArray[i].length; j++) {
        Character c = drawingArray[i][j];
        printer = printer.concat(c.toString());
      }
      printer = printer.concat(System.lineSeparator());
    }
    return printer;
    /* Format example:
    * [_ is blank]
    * X___X
    * _X_X_
    * __X__
    * _X_X_
    * X___X
    */
  }
  /**
   * Prints the drawing
   */
  public void printDrawing() {
    System.out.println(this.toString());
  }
  /**
   * Prints the history of the changes made to this array/canvas
   */
  public void printHistory() {
    Iterable<DrawingChange> history = undoStack;
    for(DrawingChange i : history) {
      System.out.println(i);
    }
  }
}
