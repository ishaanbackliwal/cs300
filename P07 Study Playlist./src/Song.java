
public class Song {
  
  private String songTitle;
  private String songArtist;
  
  public Song(String title, String artist){
    songTitle = title;
    songArtist = artist;
  }
  
  public boolean equals(Object other) {
    if(other.getClass().equals(Song.class)) {
      if(this.toString().compareTo(other.toString()) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public String toString() {
    return songTitle + " by " + songArtist;
  }
}
