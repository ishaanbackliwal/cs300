//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P05 Memeage 5000
// Files:           Memeage.java
//                  Color.java
//                  ColorPlusChar.java
//                  MemeageTests.java
//                  FourBytes.java
//                  Image.java
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
 * Class that sets/gets the color components of a Color object
 * @author ishaanbackliwal
 *
 */
public class Color extends FourBytes {
  /**
   * Constructor that runs the super class and then runs setBits using the color value it is passed
   * @param argb
   */
  public Color(int argb) {
    super(0);
    super.setBits(32, 0, argb);
  }
  /**
   * Constructor that sets each components of a 32 bit color to the values it is passed using the 
   * FourBytes class
   * @param alpha is value of the most significant 8 bits of the 32 bit color
   * @param red is the value of the second most significant 8 bits of the 32 bit color
   * @param green is the value of the second least significant 8 bits of the 32 bit color
   * @param blue is the value of the least significant 8 bits of the 32 bit color
   */
  public Color(int alpha, int red, int green, int blue) {
    super(0);
    super.setBits(8, 24, alpha);
    super.setBits(8, 16, red);
    super.setBits(8, 8, green);
    super.setBits(8, 0, blue);
  }
  /**
   * Sets the current Color object equal to the components of a different Color object that it is
   * passed
   * @param other is the other color object the method is passed
   */
  public Color(Color other) {
    this(other.getAlpha(), other.getRed(), other.getGreen(), other.getBlue());
  }
  /**
   * Gets the value of all 32 bits of the color
   * @return an int value of all 32 bits of the color
   */
  public int getARGB() {
    return getBits(32, 0);
  }
  /**
   * Gets the value of alpha, the most significant 8 bits of the 32 bit color
   * @return an int value of the most significant 8 bits of the 32 bit color
   */
  public int getAlpha() {
    return getBits(8, 24);
  }
  /**
   * Gets the value of red, the second most significant 8 bits of the 32 bit color
   * @return an int value of the second most significant 8 bits of the 32 bit color
   */
  public int getRed() {
    return getBits(8, 16);
  }
  /**
   * Gets the value of green, the second least significant 8 bits of the 32 bit color
   * @return an int value of the second least significant 8 bits of the 32 bit color
   */
  public int getGreen() {
    return getBits(8, 8);
  }
  /**
   * Gets the value of blue, the least significant 8 bits of the 32 bit color
   * @return an int value of the least significant 8 bits of the 32 bit color
   */
  public int getBlue() {
    return getBits(8, 0);
  }
  /**
   * Sets the value of all 32 bits of the color
   * @param argb is the int value of all 32 bits of the color
   */
  public void setARGB(int argb) {
    setBits(32, 0, argb);
  }
  /**
   * Sets the value of alpha, the most significant 8 bits of the 32 bit color
   * @param alpha is the int value of the most significant 8 bits of the 32 bit color
   */
  public void setAlpha(int alpha) {
    setBits(8, 24, alpha);
  }
  /**
   * Sets the value of red, the second most significant 8 bits of the 32 bit color
   * @param red is the int value of the second most significant 8 bits of the 32 bit color
   */
  public void setRed(int red) {
    setBits(8, 16, red);
  }
  /**
   * Sets the value of green, the second least significant 8 bits of the 32 bit color
   * @param green is the int value of the second least significant 8 bits of the 32 bit color
   */
  public void setGreen(int green) {
    setBits(8, 8, green);
  }
  /**
   * Gets the value of blue, the least significant 8 bits of the 32 bit color
   * @param blue is the int value of the least significant 8 bits of the 32 bit color
   */
  public void setBlue(int blue) {
    setBits(8, 0, blue);
  }
}
