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

public class Triangle {
  
  private Point p1;
  private Point p2;
  private Point p3;
  private int colorIndex;
  private static final int[] COLORS = new int[] {-1, -766643, -752563, -723891, -11668348, 
                                                 -11696908, -8106508, -766476 };
  //int packed w/8 bits of ARGB WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
  
  /**
   * Constructor that initializes instance fields declared in this class 
   * @param point1 the first Point object associated with the prospective triangle
   * @param point2 the second Point object associated with the prospective triangle
   * @param point3 the third Point object associated with the prospective triangle
   * @param index of the color the color that the triangle needs to be
   */
  public Triangle(Point point1, Point point2, Point point3, int color) {
    p1 = point1;
    p2 = point2;
    p3 = point3;
    colorIndex = color;
  }
  /**
   * Sets the color of an already created Triangle object
   * @param newColor the index of the new color the triangle needs to be set to
   */
  public void setColor(int newColor) {
    colorIndex = COLORS[newColor];
  }
  /**
   * draws a triangle at this object's position using the three points that come along with the 
   * PApplet object and fills it with a color that has been previously set
   * @param drawTo the PApplet object that has the information about the three points the triangle 
   * uses to be drawn
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(colorIndex);
    drawTo.triangle(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
  }
  /**
   * decides, using the isPointInTriangle method, whether or not the mouse is over a certain 
   * triangle object
   * @param x is the x-coordinate of the mouse position
   * @param y is the y-coordinate of the mouse position
   * @return boolean that is set as true when the position x, y is within the triangle object drawn 
   * to visualize this point, otherwise set to false
   */
  public boolean isOver(int x, int y) {
    if(isPointInTriangle(x, y, p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY())) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Calculates whether or not the mouse is over a triangle object
   * @param px is the x-coordinate of the mouse position
   * @param py is the y-coordinate of the mouse position
   * @param t1x is the x coordinate of the first point in the specified triangle object
   * @param t1y is the y coordinate of the first point in the specified triangle object
   * @param t2x is the x coordinate of the second point in the specified triangle object
   * @param t2y is the y coordinate of the second point in the specified triangle object
   * @param t3x is the x coordinate of the third point in the specified triangle object
   * @param t3y is the y coordinate of the third point in the specified triangle object
   * @return boolean that is set as true when the position x, y is within the triangle object drawn 
   * to visualize this triangle, otherwise set to false
   */
  private static boolean isPointInTriangle(int px, int py, int t1x, int t1y, int t2x, int t2y, 
                                           int t3x, int t3y) {
      px -= t1x;
      py -= t1y;
      t2x -= t1x;
      t2y -= t1y;
      t3x -= t1x;
      t3y -= t1y;
      double dotp2 = px*t2x+py*t2y;
      double dotp3 = px*t3x+py*t3y;
      double dot22 = t2x*t2x+t2y*t2y;
      double dot23 = t2x*t3x+t2y*t3y;
      double dot33 = t3x*t3x+t3y*t3y;
      double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
      double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
      double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
      return (a >= 0) && (b >= 0) && (a + b < 1);
     }
}
