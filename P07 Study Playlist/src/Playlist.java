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
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class acts as the iterator for a playlist playing in the forward direction
 * @author ishaanbackliwal
 */
public class Playlist implements Iterator<Song> {
  
  private DoublyLinkedNode<Song> currentNode;
  
  /**
   * The one argument constructor that initializes a playlist with a doubly linked node
   * @param node is the current node
   */
  public Playlist(DoublyLinkedNode<Song> node) {
    currentNode = node;
  }
  @Override
  /**
   * Tests if the there is a next song
   * @return false if currentSong is null and true otherwise
   */
  public boolean hasNext() {
    if(currentNode == null) {
      return false;
    }
    return true;
  }
  @Override
  /**
   * This method skips to the next song and returns the current song
   * @return the current song
   * @throws NoSuchElementExepction if there is no next song
   */
  public Song next() {
    if(!hasNext()) {
      throw new NoSuchElementException("There is no next song");
    }
    DoublyLinkedNode<Song> current = new DoublyLinkedNode<Song>(currentNode.getData()); //shallow copy
    currentNode = currentNode.getNext();
    return current.getData();
  }
}
