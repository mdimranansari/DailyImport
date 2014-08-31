import java.util.ArrayList;

public class ArrayList_example {
	/**
	 * @author Mohammad Imran
	 * @param Class to demonstrate Array List's flexibility.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an array list
	      ArrayList al = new ArrayList();
	      System.out.println("Initial size of al: " + al.size());
	      // Adding elements to the array list.
	      al.add("C");
	      al.add("A");
	      al.add("E");
	      al.add("B");
	      al.add("D");
	      al.add("F");
	      al.add(1, "A2");
	      System.out.println("Size of al after additions: " + al.size());

	      //Display the array list
	      System.out.println("Contents of al: " + al);
	      
	      // Now Removing elements from the array list
	      al.remove("F");
	      al.remove(2);
	      System.out.println("Size of al after deletions: " + al.size());
	      System.out.println("Contents of al: " + al);
	}
}
