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
 * This class acts as the iterator for a playlist playing in the reverse direction
 * @author ishaanbackliwal
 */
public class ReversePlaylist implements Iterator<Song> {
  
  private DoublyLinkedNode<Song> currentSong;
  
  /**
   * This is the one argument constructor initializes a reverse playlist with a doubly linked node
   * @param node is the current node
   */
  public ReversePlaylist(DoublyLinkedNode<Song> node) {
    currentSong = node;
  }
  @Override
  /**
   * Tests if the there is a previous song
   * @return false if currentSong is null and true otherwise
   */
  public boolean hasNext() {
    if(currentSong == null) {
      return false;
    }
    return true;
  }
  @Override
  /**
   * This method goes to the previous song and returns the current song
   * @return the current song
   * @throws NoSuchElementExepction if there is no previous song
   */
  public Song next() {
    if(!hasNext()) {
      throw new NoSuchElementException("There is no previous song");
    }
    DoublyLinkedNode<Song> current = new DoublyLinkedNode<Song>(currentSong.getData());
    currentSong = currentSong.getPrevious();
    return current.getData();
  }
}
