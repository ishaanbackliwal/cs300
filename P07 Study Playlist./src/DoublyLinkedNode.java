
public class DoublyLinkedNode <T> {
  
  private DoublyLinkedNode<T> previousNode;
  private T nodeData;
  private DoublyLinkedNode<T> nextNode;
  
  public DoublyLinkedNode(T data){
    previousNode = null;
    nodeData = data;
    nextNode = null;
  }
  
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next){
    previousNode = previous;
    nodeData = data;
    nextNode = next;
  }
  
  public T getData() {
    return nodeData;
  }
  
  public DoublyLinkedNode<T> getNext(){
    return nextNode;
  }
  
  public DoublyLinkedNode<T> getPrevious(){
    return previousNode;
  }
  
  public void setNext(DoublyLinkedNode<T> next) {
    nextNode = next;
  }
  
  public void setPrevious(DoublyLinkedNode<T> previous) {
    previousNode = previous;
  }
  
}
