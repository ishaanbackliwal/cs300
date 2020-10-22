//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P03 Kaleidoscopic Pen
// Files:           KaleidoscopicPen.java
//                  Point.java
//                  Triangle.java
//                  TrianglePen.java
// Course:          CS 300, Fall 2019
//
// Author:          Ishaan Backliwal
// Email:           backliwal@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Malcolm Balles
// Partner Email:   mballes@wisc.edu
// Partner Lecturer's Name: Mouna
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
// Persons:         N/A
// Online Sources:  The Java API
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import processing.core.PApplet;

public class Point {
  
  private int mouseX;
  private int mouseY;
  private final static int POINT_DIAMETER = 8;
  /**
   * Constructor used to initialize instance/static field(s) of the class 
   * @param xx is the x coordinate of the mouse position where a point is created
   * @param yy is the y coordinate of the mouse position where a point is created
   */
  public Point(int xx, int yy) {
    mouseX = xx;
    mouseY = yy;
  }
  /**
   * getter method for the x-coordinate of mouse position where a point was created
   * @return int form of the x-coordinate of the mouse position
   */
  public int getX() {
    return mouseX;
  }
  /**
   * getter method for the y-coordinate of mouse position where a point was created
   * @return int form of the y-coordinate of the mouse position
   */
  public int getY() {
    return mouseY;
  }
  /**
   * sets the position of a point to a new position (the passed coordinates)
   * @param newX the new x coordinate of the mouse/point
   * @param newY the new y coordinate of the mouse/point
   */
  public void setPosition(int newX, int newY) {
    mouseX = newX;
    mouseY = newY;
  }
  /**
   * draws a circle of POINT_DIAMATER in the position of the object that it is passed, 
   * onto the display window
   * @param drawTo is the object that is created and is where the point is drawn
   */
  public void draw(PApplet drawTo) { // draw a white circle at this point’s position
    if(drawTo != null) {
      drawTo.fill(-1);
      drawTo.circle(mouseX,  mouseY,  POINT_DIAMETER); 
    }
  }
  /**
   * find out if the mouse is over any point object that has been been drawn on the display window
   * @param x is the x coordinate of the mouse that is being tested to see if it is over a point
   * @param y is the y coordinate of the mouse that is being tested to see if it is over a point
   * @return returns true when the position x, y is within the circle drawn to visualize this point, 
   * otherwise returns false
   */
  public boolean isOver(int x, int y) { 
    double formulaX = Math.pow((mouseX - x), 2);
    double formulaY = Math.pow((mouseY - y), 2);
    if(Math.sqrt(formulaX + formulaY) < ((double)POINT_DIAMETER / 2.0)) {
      return true;
    }
    else {
      return false; 
    }
  }
}
