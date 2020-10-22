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
import java.util.ArrayList;
import processing.core.PApplet;

public class TrianglePen {
  
  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private PApplet processing;
  private boolean showPoints;
  private ArrayList<Point> points;
  private ArrayList<Triangle> triangles;
  private Point drag;
  /**
   * Constructor that initializes the instance fields declared in this class
   * @param processing is the PApplet object
   * @param showPoints is a boolean that states whether or not to display each Point object that is
   * created
   */
  public TrianglePen(PApplet processing, boolean showPoints){
    mouseWasPressed = false;
    keyWasPressed = '0';
    this.processing = processing;
    this.showPoints = showPoints;
    points = new ArrayList<Point>();
    triangles = new ArrayList<Triangle>();
    drag = null;
  }
  /**
   * updates program in order to implement the creation of Triangle and Point objects
   * @param mouseX is the x coordinate of the mouse position
   * @param mouseY is the y coordinate of the mouse position
   * @param mousePressed states whether or not the mouse was pressed
   * @param keyPressed states which key was pressed, if any
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input
    if(mousePressed != mouseWasPressed) {
     if(mousePressed) handleMousePress(mouseX, mouseY);
     else handleMouseRelease(mouseX, mouseY);
    }
    if(mousePressed) handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if(keyPressed != keyWasPressed) handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();
  }
  /**
   * Runs when mouse is clicked in display window and decides whether a point is being dragged by 
   * the mouse; if so, then calls handeMouseDrag, otherwise adds a new point at the position the 
   * mouse was clicked and then possible creates a triangle depending on the number of points not 
   * associated with an already existing Triangle object
   * @param mouseX is the x coordinate of the mouse position
   * @param mouseY is the y coordinate of the mouse position
   */
  private void handleMousePress(int mouseX, int mouseY) {
    boolean dragCondition = false;
    for(int i = 0; i < points.size(); i++) {
      if(points.get(i).isOver(mouseX, mouseY)) {
        drag = points.get(i);
        dragCondition = true;
      }
    }
    if(dragCondition == true) {
      handleMouseDrag(drag.getX(), drag.getY());
    }
    else {
      points.add(new Point(mouseX, mouseY));
      if (points.size() % 3 == 0) {
        triangles.add(new Triangle(points.get(points.size() - 3), points.get(points.size() - 2), points.get(points.size() - 1), -1));
      }
    }
  }
  /**
   * re-sets the position of the point supposedly being dragged
   * @param mouseX is the x-coordinate of the mouse position that the point is being dragged with
   * @param mouseY is the y-coordinate of the mouse position that the point is being dragged with
   */
  private void handleMouseDrag(int mouseX, int mouseY) {
    if(drag != null) {
      drag.setPosition(mouseX, mouseY);
    }
  }
  /**
   * When mouse is released after dragging, new position is set
   * @param mouseX new x position of the dragged point/where the mouse landed after release
   * @param mouseY new y position of the dragged point/where the mouse landed after release
   */
  private void handleMouseRelease(int mouseX, int mouseY) {
    drag = new Point(mouseX, mouseY);
  }
  /**
   * when a key is pressed, this method tests for whether it was a number [0,7] and if it was, it 
   * tests for whether it was over a triangle; if so, the color of the triangle is set to the 
   * keyPressed's corresponding color index
   * @param mouseX is the x position for the mouse at the time of the key press
   * @param mouseY is the y position for the mouse at the time of the key press
   * @param keyPressed is the key that was pressed
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    for(int i = triangles.size() - 1; i >= 0; i--) {
      if(triangles.get(i).isOver(mouseX, mouseY)) {
        for (int j = 0; j < 8; j ++) {
          if((int)keyPressed - 48 == j) {
            triangles.get(i).setColor(j);
          } 
        }
      }
    }
  }
  /**
   * draw the points if showPoints is equal to true and draws triangles if called upon while the 
   * conditions are correct
   */
  private void draw() {
    if(showPoints == true) {
      for(int i = 0; i < points.size(); i++){
        points.get(i).draw(processing);
      }
    }
    for(int j = 0; j < triangles.size(); j++){
      triangles.get(j).draw(processing);
    }
  }
}
