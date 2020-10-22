import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
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
 * Class goes through camp information file and runs each instruction in it
 */
public class CampEnrollmentApp {

  /**
   * Main method that reads each line of the file and runs the instruction that is written in it
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException{
    CampManager manager = new CampManager();
    List <String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
    for(int i = 0; i < fileLines.size(); i++) {
      try {
        String[] info = fileLines.get(i).split(" ");
        if(info[0].compareTo("E") == 0) {   //if the file line commands an enrollment/insertion
          manager.enrollCamper(new Camper(info[2], info[1], Integer.parseInt(info[3])));
          System.out.println("Enrollment of " + info[2] + " " + info[1] + " Succsessful!");
        }
        if(info[0].compareTo("R") == 0) {   //if the file line commands an camper removal
          manager.unenrollCamper(new Camper(info[2], info[1], 8));
          System.out.println("Unenrollment of " + info[2] + " " + info[1] + " Succsessful!");
        }
        if(info[0].compareTo("T") == 0) {    //if the file line commands a tree traversal
          System.out.println("--------" + info[1] + " " + "Traversal--------");
          Iterator<Camper> itr = manager.traverse(info[1]);
          while(itr.hasNext()) {
            Camper camper = itr.next();
            System.out.println(camper.toString());
          }
          System.out.println("-------------------------------");
        }
        if(info[0].compareTo("S") == 0) {    //if the file line commands a statistics print
          System.out.println("--------Camp Statistics--------");
          manager.printStatistics();
        }
      }
      catch(IllegalArgumentException e) {
        System.out.println(e);
      }
      catch(NoSuchElementException e) {
        System.out.println(e);
      }
    }
  }

}
