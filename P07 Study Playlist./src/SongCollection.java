import java.util.NoSuchElementException;

public class SongCollection {
  
  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;
  
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }
  
  public void add(Song song) {  // adds song to the end/tail of this doubly linked list; when song is null, throws a NullPointerException
    if(song == null) {
      throw new NullPointerException();
    }
    tail.setNext(new DoublyLinkedNode<Song>(song));
    tail = tail.getNext();
  }
  
  public Song remove() {  // removes and returns song from the front/head of this list; when list is empty, throws a NoSuchElementException
    if(head == null) {
      throw new NoSuchElementException();
    }
    Song get = head.getData();
    head = head.getNext();
    return get;
  }

}
