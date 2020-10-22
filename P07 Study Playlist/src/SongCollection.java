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
 * This class established a collection of songs
 * @author ishaanbackliwal
 */
public class SongCollection implements Iterable<Song> {
  
  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;
  
  /**
   * The no argument constructor that sets the head and tail of this song collection to null and 
   * the direction to be played as forward (true)
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }
  /**
   * Adds the song it is passed to the end/tail of this doubly linked list
   * @param song is the song to be added to the end/tail of this doubly linked list
   */
  public void add(Song song) {
    if(song == null) {
      throw new NullPointerException();         // when song is null, throws a NullPointerException
    }
    DoublyLinkedNode<Song> add = new DoublyLinkedNode<Song>(song);
    if(head == null) {
      head = add;
      tail = add;
    }
    tail.setPrevious(tail);
    tail.setNext(add);
    tail = add;
  }
  /**
   * Removes and returns the song in the front/head position of this doubly linked list
   * @return the song that was removed from the front/head position of the list
   */
  public Song remove() {
    if(head == null) {
      throw new NoSuchElementException();   // when list is empty, throws a NoSuchElementException
    }
    Song get = head.getData();
    head = head.getNext();
    return get;
  }
  /**
   * Sets the direction that the song collection is to be played
   * @param isForward is true if the direction is forward and false if backwards
   */
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }
  @Override
  /**
   * The iterator method that goes through and created either a playlist or a reverse playlist
   * depending on the state of the playDirectionForward field
   * @return a Playlist object if playDirectionForward is true or ReversePlaylist object if 
   * it is false 
   */
  public Iterator<Song> iterator() {
    if(playDirectionForward) {
      return new Playlist(head);
    }
    return new ReversePlaylist(tail);
  }

////////////////////////////////////These are the tester methods////////////////////////////////////
  
  public static void analysisMethodA(SongCollection songs) {
    songs.add(new Song("C is for Cookie.", "Cookie Monster"));
    songs.add(new Song("Rubber Duckie.", "Ernie"));
    songs.add(new Song("Elmo's Song.", "Elmo"));
   }
   public static void analysisMethodB(SongCollection songs) {
    SongCollection copy = new SongCollection();
    for(Song song: songs)
    copy.add(song);
    for(Song song: copy)
    System.out.println(song);
   }
   public static void analysisMethodC(SongCollection songs) {
    Iterator<Song> playlist = songs.iterator();
    for(int i=0;i<1000;i++)
    if(playlist.hasNext())
    System.out.println( playlist.next() );
   }
   public static void main(String[] args) {
     SongCollection song = new SongCollection();
     analysisMethodA(song);
     analysisMethodB(song);
     analysisMethodC(song);
   }
   
////////////////////////////////////////////////////////////////////////////////////////////////////
//For each of the following big-O time complexity analysis, consider the problem
//size to be the number of Songs that are stored within the argument songs, when
//the method is first called.
//
//For analysisMethodA, the big-O time complexity is O(1).
//
//For analysisMethodB, the big-O time complexity is O(n).
//
//For analysisMethodC, the big-O time complexity is O(1).
//
////////////////////////////////////////////////////////////////////////////////////////////////////
}