import java.util.LinkedList;

public class LinkedList_example {
	/**
	 * @author Mohammad Imran
	 * @param Class to demonstrate Linked List's constant-time insertions/removals.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a linked list.
	      LinkedList ll = new LinkedList();
	      // Adding elements to the linked list.
	      ll.add("F");
	      ll.add("B");
	      ll.add("D");
	      ll.add("E");
	      ll.add("C");
	      ll.addLast("Z");
	      ll.addFirst("A");
	      ll.add(1, "A2");
	      System.out.println("Original contents of Linked List: " + ll);

	      // Removing elements from the linked list.
	      ll.remove("F");
	      ll.remove(2);
	      System.out.println("Contents of Linked List after deletion: "+ ll);
	      
	      // Removing first and last elements.
	      ll.removeFirst();
	      ll.removeLast();
	      System.out.println("Linked List after deleting first and last: "+ ll);

	      // Get and set a value.
	      Object val = ll.get(2);
	      ll.set(2, (String) val + " Changed");
	      System.out.println("Linked List after change: "+ ll);
	}
}