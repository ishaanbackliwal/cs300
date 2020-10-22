import java.util.Iterator;
import java.util.LinkedList;
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
 * Class that modifies the camp binary search tree with insertion, deletion, and traversal methods
 */
public class CamperBST {

  public CampTreeNode root;
  private int size;

  /**
   * No argument constructor that initializes the root and size of the binary search tree
   */
  public CamperBST() {
    root = null;
    size = 0;
  }

  /**
   * Getter method for the size of the binary search tree (number of nodes)
   * 
   * @return the size of the tree
   */
  public int size() {
    return size;
  }

  /**
   * Check whether the binary search tree is empty or not
   * 
   * @return true if tree is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  // starts tree insertion by calling insertHelp() on the root and
  // assigning root to be the subtree returned by that method
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current, The "root" of the subtree we are inserting into, ie the node we are currently
   *        at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {
    if (current == null) {
      current = new CampTreeNode();
      current.setData(newCamper);
      size++;
      return current;
    } else {
      if (current.getData().compareTo(newCamper) > 0) { // if current is greater than the new camper
        current.setLeftNode(insertHelp(current.getLeftNode(), newCamper)); // recurse using the left
                                                                           // node
        return current;
      } else { // if current is less than the new camper
        current.setRightNode(insertHelp(current.getRightNode(), newCamper)); // recurse using the
                                                                             // right node
        return current;
      }
    }

  }

  /**
   * Prints the contents of this tree in alphabetical order based on the string "lastName,
   * firstName"
   */
  public void print() {
    printHelp(root);
  }

  /**
   * Helper method for print()
   * 
   * @param current
   */
  private void printHelp(CampTreeNode current) {
    if (current == null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }


  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key, the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
    size--;
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current, The "root" of the subtree we are deleting from, ie the node we are currently
   *        at.
   * @param key, the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {
    if (current == null) {
      return current;
    }
    if (key.compareTo(current.getData()) < 0 || key.compareTo(current.getData()) > 0) {
      if (key.compareTo(current.getData()) > 0) { // if key is greater than current
        if (current.getRightNode() == null) {
          throw new NoSuchElementException("This camper was not found");
        }
        current.setRightNode(deleteHelp(current.getRightNode(), key)); // recurse using right node
      }
      if (key.compareTo(current.getData()) < 0) { // if key is less than current
        if (current.getLeftNode() == null) {
          throw new NoSuchElementException("This camper was not found");
        }
        current.setLeftNode(deleteHelp(current.getLeftNode(), key)); // recurse using left node
      }
    } else { // if key is found
      if (current.getLeftNode() == null) {//if left node is null, right node is returned
        return current.getRightNode();
      } else if (current.getRightNode() == null) {//if right node is null, left node is returned
        return current.getLeftNode();
      } else {//if two children, successor node is  found
        CampTreeNode succ = findSucc(current.getRightNode());
        current.setData(succ.getData());
        current.setRightNode(deleteHelp(current.getRightNode(), succ.getData()));
      }
    }
    return current;
  }

  /**
   * Helper method to find the successor node
   * @param remove - the node being removed
   * @return successor node
   */
  private CampTreeNode findSucc(CampTreeNode remove) {
    if (remove == null) {
      return remove;
    }
    while (remove.getLeftNode() != null) {
      remove = remove.getLeftNode();
    }
    return remove;
  }

  // LinkedList to maintain current traversal
  private LinkedList<Camper> traversedLList;

  // returns an iterator of camper in the correct order as designated
  public Iterator<Camper> traverse(String order) {
    // first time traversing need to initialize LinkedList
    if (traversedLList == null) {
      traversedLList = new LinkedList<Camper>();
    } else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /**
   * Recursive helper method to traverse. Will take the current CampTreeNode’s data and add it to
   * traversedLList based on the given order. Then continue to recurse on the correct subtree.
   * 
   * @param current, the root of the current subtree we are traversing
   * @param order, the type of traversal to perform
   */
  private void traverseHelp(CampTreeNode current, String order) {
    if (order.compareTo("PREORDER") == 0) { // if the order is PREORDER
      traversedLList.add(current.getData());
      if (current.getLeftNode() != null) {
        traverseHelp(current.getLeftNode(), order);
      }
      if (current.getRightNode() != null) {
        traverseHelp(current.getRightNode(), order);
      }
      traversedLList.add(current.getData());
    }
    if (order.compareTo("POSTORDER") == 0) { // if the order is POSTORDER
      if (current.getLeftNode() != null) {
        traverseHelp(current.getLeftNode(), order);
      }
      if (current.getRightNode() != null) {
        traverseHelp(current.getRightNode(), order);
      }
      traversedLList.add(current.getData());
    }
    if (order.compareTo("INORDER") == 0) { // if the order is INORDER
      if (current.getLeftNode() != null) {
        traverseHelp(current.getLeftNode(), order);
        traversedLList.add(current.getData());
      } else {
        traversedLList.add(current.getData());
      }
      if (current.getRightNode() != null) {
        traverseHelp(current.getRightNode(), order);
        traversedLList.add(current.getData());
      }
    }
  }
}
