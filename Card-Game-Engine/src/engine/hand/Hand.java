package engine.hand;

import java.util.Iterator;

/**
 * 
 * @author Matthew Temniuk
 * Created March 19, 2019
 *
 */
public class Hand<T> extends ArrayList<T> implements OrderedListADT<T> {
	
	public Hand() {
		super();
		
	}
	
	public Hand(int initialCapacity) {
		super(initialCapacity);
	}


	/**
	 * Function to add a card in the correct order to the hand
	 */
	public void add(T element) {
		if (size() == list.length) {
			 expandCapacity();
		}
	        

	      Comparable<T> temp = (Comparable<T>)element;

	      int scan = 0;   
	      while (scan < rear && temp.compareTo(list[scan]) > 0) {
	    	  scan++;
	      }
	          

	      for (int scan2=rear; scan2 > scan; scan2--) {
	    	  list[scan2] = list[scan2-1];
	      }
	      
	      list[scan] = element;
	      rear++;
		
	}
	
}
