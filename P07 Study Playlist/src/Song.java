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
 * This class declares a Song object and has methods to return a string representation of the 
 * details of the songs and an equals method that checks wether two songs have the same details
 * @author ishaanbackliwal
 */
public class Song {
  
  private String songTitle;
  private String songArtist;
  /**
   * This is the 2 argument constructor that sets the song object's details to that of what it is 
   * passed
   * @param title is a string representing the title of the song
   * @param artist is a string representing the artist of the song
   */
  public Song(String title, String artist){
    songTitle = title;
    songArtist = artist;
  }
  /**
   * This method checks whether the current song and the song it is passed have the same details
   * (if they are equal)
   * @param other is the other song that this method compares to the current song
   * @return true if the two songs have the same details, false otherwise
   */
  public boolean equals(Object other) {
    if(other.getClass().equals(Song.class)) {
      if(this.toString().compareTo(other.toString()) == 0) {
        return true;
      }
    }
    return false;
  }
  /**
   * Gets a string representation of the current song's details (title and artist)
   * @return the song title and artist in the form "TITLE by ARTIST"
   */
  public String toString() {
    return songTitle + " by " + songArtist;
  }
}
