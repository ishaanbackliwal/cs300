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
 * This class is passed a color and will can either hide a given character into the given 
 * pixel/color or can reveal the character hidden in that pixel
 * 
 * @author ishaan backliwal
 *
 */
public class ColorPlusChar extends Color {
  /**
   * the first constructor that declares the color and runs the one param constructor of the Color
   * class and then hides the character passed to this constructor 
   * @param color is the color code that is passed to the super class's constructor
   * @param character is the character that is being hidden in the given color/pixel
   */
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }
  /**
   * Second constructor that declares the color and runs the one param constructor of the Color
   * class
   * @param color is the color code that is passed to the super class's constructor
   */
  public ColorPlusChar(Color color) {
    super(color);
  }
  /**
   * Stores 8-bit character within the least significant bits of color components by splitting the 8
   * bits into 4 sets of 2 bit binary and then storing them in the color
   * @param character is the char being stored in the 32 bit color
   */
  public void hideChar(char character) {
    FourBytes num = new FourBytes(character);
    super.setBits(2, 0, num.getBits(2, 0));
    super.setBits(2, 8, num.getBits(2, 2));
    super.setBits(2, 16, num.getBits(2, 4));
    super.setBits(2, 24, num.getBits(2, 6));
  }
  /**
   * Retrieves 8-bit character from the least significant bits of color components
   * @return an 8 bit character that is a combination of the 2 bit components retrieved from the 
   * color component
   */
  public char revealChar() {
    FourBytes num = new FourBytes(0);
    num.setBits(2, 0, super.getBits(2, 0));
    num.setBits(2, 2, super.getBits(2, 8));
    num.setBits(2, 4, super.getBits(2, 16));
    num.setBits(2, 6, super.getBits(2, 24));
    return num.getChar();
  }
}
