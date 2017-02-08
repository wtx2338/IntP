import java.util.*;

/**
 * Created by swu on 08/02/2017.
 */
public class DataStructure {
  private static class LinkedListNode<E> {
    E value;
    LinkedListNode<E> next;
    LinkedListNode<E> previous;
  }

  private static class LinkedList<E> {
    LinkedListNode<E> head;
    LinkedListNode<E> tail;
  }

  /**
   * Array: Ordered collection of element, index
   *
   */
  public void array() {
    // Array, fixed size
    int[] elements1 = new int[10];

    // Dynamic array, double size
    List elements2 = new ArrayList<Integer>(10);

    // Linked list: easy insertion deletions, constant time, easy expand
    // Costly access


    // Queue: FIFO, ArrayBlockingQueue
    // Stack: LIFO
    Stack<Integer> stack = new Stack<Integer>();
  }

  public void hashTable() {
    Map<String, Integer> map = new HashMap<String, Integer>();
    Map<String, Integer> table = new Hashtable<String, Integer>();
    // Hashtable is synchronized
  }


  public void main() {

  }
}
