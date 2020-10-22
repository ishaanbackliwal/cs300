//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P06 Mega Blocks Builder
// Files:           MegaBlock.java
//                  MegaBlockBuilderTester.java
//                  LinkedMegaBlock.java
//                  LinkedListMegaBlock.java
//                  Color.java
// Course:          CS 300, fall 2019
//
// Author:          Malcolm Balles
// Email:           mballes@wisc.edu
// Lecturer's Name: Mouna
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ishaan Backliwal
// Partner Email:   backliwal@wisc.edu
// Partner Lecturer's Name: Gary
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
// Persons:         none
// Online Sources:  http://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2019/10/p6javadocs/index.html
//                  gave javadocs as instructions on what methods to code
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.NoSuchElementException;

public class MegaBlockBuilderTester {
  /**
   * Runs all tests to make sure LinkedMegaBlock, MegaBlock, and LinkedListMegaBlock are working
   * properly
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testMegaBlockEquals());
    System.out.println(testMegaBlockToString());
    System.out.println(testLinkedMegaBlock());
    System.out.println(testLinkedListMegaBlockAddRed());
    System.out.println(testLinkedListMegaBlockRemoveBlue());
  }

  /**
   * Tests to see if MegaBlock.equals works
   * 
   * @return true if working properly, false if not
   */
  public static boolean testMegaBlockEquals() {
    MegaBlock test1 = new MegaBlock(Color.RED, 'h');
    MegaBlock test2 = new MegaBlock(Color.RED, 't');
    MegaBlock test3 = new MegaBlock(Color.BLUE, 'h');
    if (test1.equals(test2) == false)
      return false;
    if (test1.equals(test3) == true)
      return false;
    return true;
  }

  /**
   * Tests to see if MegaBlock.toString works
   * 
   * @return true if working properly, false if not
   */
  public static boolean testMegaBlockToString() {
    MegaBlock test1 = new MegaBlock(Color.RED, 'h');
    if (test1.toString().compareTo("RED h") != 0)
      return false;
    return true;
  }

  /**
   * Tests to see if LinkedMegaBlock works
   * 
   * @return true if working properly, false if not
   */
  public static boolean testLinkedMegaBlock() {
    LinkedMegaBlock test1 = new LinkedMegaBlock(new MegaBlock(Color.YELLOW, 'y'));
    test1.setNext(new LinkedMegaBlock(new MegaBlock(Color.BLUE, 'r')));
    if (test1.getBlock().toString().compareTo("YELLOW y") != 0)
      return false;
    if (test1.getNext().toString().compareTo("BLUE r -> END") != 0)
      return false;
    return true;
  }

  /**
   * Tests to see if LinkedListMegaBlock.addRed works
   * 
   * @return true if working properly, false if not
   */
  public static boolean testLinkedListMegaBlockAddRed() {
    LinkedListMegaBlock test1 = new LinkedListMegaBlock();
    test1.addRed(new MegaBlock(Color.RED, 'r'));
    if (test1.toString().compareTo("RED r -> END") != 0)
      return false;
    return true;
  }

  /**
   * Tests to see if LinkedListMegaBlock.removeBlue works
   * 
   * @return true if working properly, false if not
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    LinkedListMegaBlock test1 = new LinkedListMegaBlock();
    test1.addBlue(new MegaBlock(Color.BLUE, 'r'));
    try {
      if (test1.removeBlue().toString().compareTo("BLUE r") != 0)
        return false;
      test1.removeBlue(); // this should throw exception
      return false;
    } catch (NoSuchElementException e) {
      return true;
    }
  }
}
