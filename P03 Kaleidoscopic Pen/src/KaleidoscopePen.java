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

public class KaleidoscopePen {
  
  private TrianglePen[] pens;
  /**
   * Initiates the pen array and fills it with TrianglePen objects
   * @param drawTo PApplet object passed in order to forward it to the TrianglePen class to draw
   * points and thus, though that, draw triangles
   * @param numberOfTrianglePens number of TrianglePen objects needed to be created so that the
   * for-loop knows how long to run for 
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    pens = new TrianglePen[numberOfTrianglePens];
    pens[0] = new TrianglePen(drawTo, true);
    for(int i = 1; i < numberOfTrianglePens; i++) {
      pens[i] = new TrianglePen(drawTo, false);
    }
  }
  /**
   * Updates program in order to implement triangle rotation around the center of the screen,
   * allowing for the kaleidoscopic effect to be created
   * @param mouseX to get the x-axis position of the mouse
   * @param mouseY to get the y-axis position of the mouse
   * @param mousePressed condition that states whether the mouse was pressed at the given (x,y)
   * coordinate
   * @param keyPressed to be able to tell which key was pressed, if any
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    for(int i = 0; i < pens.length; i++) {
      int [] rotate;
      rotate = rotate(mouseX, mouseY, (double)i * (2.0 * Math.PI) / 5.0);
      pens[i].update(rotate[0], rotate[1], mousePressed, keyPressed);
    }
  }
  /**
   * Calculates the rotate angle needed for each triangle to be rotate properly to create the 
   * kaleidoscopic effect
   * @param x is the x-coordinate of the mouse/point that is part of the triangle that needs to be
   * rotated
   * @param y is the y-coordinate of the mouse/point that is part of the triangle that needs to be
   * rotated
   * @param angle is the angle that the trianges need to be roatetd to
   * @return an array of size 2 that is filled with the rotated position fo the x and y coordiantes 
   * the method was passed (x in index 0 and y in index 1)
   */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
    (int)(x * Math.cos(angle) - y * Math.sin(angle)),
    (int)(x * Math.sin(angle) + y * Math.cos(angle)) };
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
   }
}
