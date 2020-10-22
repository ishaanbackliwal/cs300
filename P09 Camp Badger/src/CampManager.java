import java.util.Iterator;
import java.util.NoSuchElementException;
////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           P09 Camp Badger
//Files:           CampManager.java
//                 CamperBST.java
//                 CampEnrollmentApp.java
//                 CampTreeNode.java
//                 Camper.java
//Course:          CS 300, Fall 2019
//
//Author:          Ishaan Backliwal
//Email:           backliwal@wisc.edu
//Lecturer's Name: Gary Dahl
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    Sabrina Huang
//Partner Email:   shuang377@wisc.edu
//Partner Lecturer's Name: Gary Dahl
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_x_ Write-up states that pair programming is allowed for this assignment.
//_x_ We have both read and understand the course Pair Programming Policy.
//_x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons:         N/A
//Online Sources:  The Java API and Javadocs
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class that acts as a middle man to handle the camp's binary search
 */
public class CampManager extends CamperBST {
  
  private CamperBST campers;
  private final static String [] CABIN_NAMES = new String[]{
  "Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};
  
  /**
   * No argument constructor that initializes the campers binary search tree
   */
  public CampManager() {
    campers = new CamperBST();
  }
  /**
   * Assigns a cabin to the camper being enrolled to the camp and then runs the insert method
   * in CamperBST to enroll the camper
   * @param newCamper is the camper being enrolled
   */
  public void enrollCamper(Camper newCamper) {
    int age = newCamper.getAge();
    if(age >= 8 && age <= 9)
      newCamper.assignCabin(CABIN_NAMES[0]);
    if(age >= 10 && age <= 12)
      newCamper.assignCabin(CABIN_NAMES[1]);
    if(age >= 13 && age <= 14)
      newCamper.assignCabin(CABIN_NAMES[2]);
    campers.insert(newCamper);
  }
  /**
   * Prints the size of the camper binary search tree (the number of nodes)
   */
  public void printStatistics() {
    System.out.println("Number of campers: " + campers.size() + "\n-------------------------------");
  }
  /**
   * This method runs the traverse method in CamperBST based on the specific order it is passed
   * @param order is the order the tree should be traversed in
   * @return iterator of campers
   */
  public Iterator<Camper> traverse(String order) {
    return campers.traverse(order);
  }
  /**
   * Removes the specified camper by running the delete method in CamperBST
   * @param delCamper is the specific camper to be removed from the binary search tree
   */
  public void unenrollCamper(Camper delCamper) {
    campers.delete(delCamper);
  }
}
