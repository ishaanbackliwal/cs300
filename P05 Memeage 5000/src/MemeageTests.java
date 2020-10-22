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
import java.io.File;
import java.io.IOException;
/**
 * This class tests the other classes in this project including FourBytes, Color, Image, 
 * ColorPlusChar, and Memeage
 * @author ishaanbackliwal
 *
 */
public class MemeageTests {
  /**
   * Main method that runs each test method and prints out the result for each one
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }
  /**
   * Tests the getBits() method in the FourBytes class to see if the method correctly returns the
   * bit value of the binary number it is passed in its constructor
   * @return true if the offset value of the binary value is the same as the value that is 
   * returned
   */
  public static boolean testFourBytesGetBits() {
    FourBytes obj = new FourBytes(13312);
    if(obj.getBits(4, 10) == 13) {
      return true;
    }
    return false;
  }
  /**
   * Tests the setBits() method of the FourBytes class by setting a FourBytes objects' bits to a
   * certain state and then seeing if when compared to getBits, it returns the same value
   * @return true if the passed value is the same as the returned, and false otherwise
   */
  public static boolean testFourBytesSetBits() {
    FourBytes obj = new FourBytes(0);
    obj.setBits(32, 10, 1234);
    if(obj.getBits(32, 10) == 1234) {
      return true;
    }
    return false;
  }
  /**
   * Tests the color class to make sure at least one constructor, one getter, and one setter are 
   * functioning properly 
   * @return true if all the methods tested return the appropriate values and false otherwise 
   */
  public static boolean testColor() {
    Color color = new Color(13);
    boolean t1 = false;
    boolean t2 = false;
    if(color.getARGB() == 13) {
      t1 = true;
    }
    if(t1) {
      color.setARGB(10);
      if(color.getARGB() == 10) {
        t2 = true;
      }
      if(t1 && t2) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }
  /**
   * Tests the Image class by seeing if the image passed has to the class' constructor has the 
   * right dimensions and color values
   * @return true if the tests all return the appropriate values, and flase otherwise
   * @throws IOException
   */
  public static boolean testImage() throws IOException {
    File testFile = new File("/Users/ishaanbackliwal/Desktop/repositories/P05 Memeage "
        + "5000/src/testImage.png");
    boolean test = false;
    try {
      Image pic = new Image(testFile);
      if(pic.getWidth() == 3 && pic.getHeight() == 3) {
        if(pic.getColor(1, 1).getBlue() == 255 && pic.getColor(1, 1).getGreen() == 255 && 
            pic.getColor(1, 1).getRed() == 0) {
          test = true;
        }
      }
    }
    catch(IOException e) {
      test = false;
    }
    return test;
  }
  /**
   * Tests the ColorPlusChar class by testing at least one constructor and mutator and accessor
   * methods 
   * @return true if hideChar correctly hides a character into a color passed in the constructor
   * and revealChar returns the same value that was hidden, and false otherwise
   */
  public static boolean testColorPlusChar() {
    ColorPlusChar test = new ColorPlusChar(new Color(32));
    test.hideChar('Z');
    if(test.revealChar() == 'Z') {
      return true;
    }
    return false;
  }
  /**
   * Tests the Memeage class
   * @return true if all tests run appropriately, and false otherwise
   * @throws IOException
   */
  public static boolean testMemeage() throws IOException {
    File testFile = new File("/Users/ishaanbackliwal/Desktop/repositories/P05 Memeage "
        + "5000/src/testImage.png");
    Memeage memer = new Memeage(testFile, "ishaannn");
    boolean tester1 = false;
    boolean tester2 = false;
    if(memer.getMeme().compareTo("ishaannn") == 0) {
      tester1 = true;
    }
    memer.setMeme("neha");
    if(memer.getMeme().compareTo("neha") == 0) {
      tester2 = true;
    }
    if(tester1 == true && tester2 == true) {
      return true;
    }
    return false;
  }

}