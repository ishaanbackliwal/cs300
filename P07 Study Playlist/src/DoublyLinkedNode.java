//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P07 Study Playlist
// Files:           Song.java
//                  DoublyLinkedNode.java
//                  Playlist.java
//                  ReversePlaylist.java
//                  SongCollection.java
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
 * This class has getter and setter methods that establish double linked nodes
 * @author ishaanbackliwal
 * @param <T>
 */
public class DoublyLinkedNode <T> {
  
  private DoublyLinkedNode<T> previousNode;
  private T nodeData;
  private DoublyLinkedNode<T> nextNode;
  /**
   * The one argument constructor that sets the previous and next nodes to null and sets the current
   * node's data to what it's passed
   * @param data is the data of the current node
   */
  public DoublyLinkedNode(T data){
    previousNode = null;
    nodeData = data;
    nextNode = null;
  }
  /**
   * The three argument constructor that set the previous node, next node, and the current node's 
   * data
   * @param previous is the previous node to be added to the list
   * @param data is the data of the current node
   * @param next is the next node to be added to the list
   */
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next){
    previousNode = previous;
    nodeData = data;
    nextNode = next;
  }
  /**
   * Gets the data (song) of the doubly linked node it is being used on
   * @return the data of the node
   */
  public T getData() {
    return nodeData;
  }
  /**
   * Gets the next node in the list of linked nodes
   * @return the next node in the list
   */
  public DoublyLinkedNode<T> getNext(){
    return nextNode;
  }
  /**
   * Gets the previous node in the list of linked nodes
   * @return the previous node in the list
   */
  public DoublyLinkedNode<T> getPrevious(){
    return previousNode;
  }
  /**
   * Sets the next node in the list of linked nodes
   * @param next is the node to be added in the next position in the list
   */
  public void setNext(DoublyLinkedNode<T> next) {
    nextNode = next;
  }
  /**
   * Sets the previous node in the list of linked nodes
   * @param next is the node to be added in the previous position in the list
   */
  public void setPrevious(DoublyLinkedNode<T> previous) {
    previousNode = previous;
  }
  
}
