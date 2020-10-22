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
 * This class acts as a steganography system by hiding characters from a given string into a given
 * image and at the same time, being able to retrieve these hidden characters and combine them into
 * the initial passed string from the image
 * @author Ishaan Backliwal
 *
 */
public class Memeage extends Image {
  
  /**
   * First constructor
   * @param file is the image file passed in order to be used to hide characters within its pixels
   * @throws IOException
   */
  public Memeage(File file) throws IOException {
    super(file);
  }
  /**
   * Second constructor that hides the characters passed into the image passed to it
   * @param file is the image file passed in order to be used to hide characters within its pixels
   * @param meme is the string of characters needed to be hidden in pixels of the image provided
   * @throws IOException
   * @throws IllegalArgumentException if the string is longer than the number of pixels in the image
   * or if one of the characters in the string has a character code greater than 127
   */
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    this.setMeme(meme);
  }
  /**
   * Hides the string is is passed in the image of the Memeage object this method is 
   * being invoked on
   * @param meme is the string of characters needed to be hidden in pixels of the image provided
   * @throws IllegalArgumentException if the string is longer than the number of pixels in the image
   * or if one of the characters in the string has a character code greater than 127
   */
  public void setMeme(String meme) throws IllegalArgumentException {
    if(meme.length() >= super.getWidth() * super.getHeight()) {
      throw new IllegalArgumentException("Meme length is longer than color/pixel locations "
          + "within the image ");
    }
    int count = 0;
    for(int y = 0; y < super.getHeight(); y++) {
      for(int x = 0; x < super.getWidth(); x++) {
          try {
            FourBytes nums = new FourBytes(meme.charAt(count));
            if(nums.getInt() > 127) {
              throw new IllegalArgumentException("Character within the meme message has a "
                  + "character code that is greater than 127");
            }
            else {
              super.setColor(x, y, new ColorPlusChar(super.getColor(x, y), nums.getChar()));
              count++;
            }
          }
          catch(StringIndexOutOfBoundsException e) {
            super.setColor(x, y, new ColorPlusChar(super.getColor(x, y), '\0'));
          }
      }
    }
  }
  /**
   * Takes the image on which this method is being invoked upon and extracts the characters hidden
   * in each of the pixels of the image and combines them into one string and returns it
   * @return a string of characters that were hidden in the image
   * @throws IllegalStateException if a character found in the image has a character code that is 
   * greater than 127 or if none of the characters found resemble the end of string character '\0'
   */
  public String getMeme() throws IllegalStateException {
    ColorPlusChar reveal;
    String meme = "";
    for(int y = 0; y < super.getHeight(); y++) {
      for(int x = 0; x < super.getWidth(); x++) {
        reveal = new ColorPlusChar(super.getColor(x, y));
      if(reveal.revealChar() > 127) {
        throw new IllegalStateException("Character retrieved has a value of greater than 127");
      }
      if(x * y == super.getWidth() * super.getHeight() - 1 && reveal.revealChar() != '\0') {
        throw new IllegalStateException("None of the characters retrived from the image resemble "
            + "the end of the meme message");
      }
      if(reveal.revealChar() == '\0') {
        x = super.getWidth();
      }
      else {
        meme = meme.concat(Character.toString(reveal.revealChar())); 
      }
      }
    }
    return meme;
  }
}