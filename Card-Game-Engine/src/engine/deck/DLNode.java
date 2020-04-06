package engine.deck;

/**
 * A class that represents a node that is doubly linked one link to previous node and one to the next node.
 * 
 * @author Matthew Temniuk 
 * Date: March 18, 2019
 * 
 */
public class DLNode<T> {
	/**
	 * Reference to the data item of the node.
	 */
	private T dataItem;
	
	/**
	 * Reference to the next node.
	 */
	private DLNode<T> next;
	
	/**
	 * Reference to the previous node.
	 */
	private DLNode<T> previous;
	
	/**
	 * Value of the data item stored in the node.
	 */
	private int value;
	
	/**
	 * Constructor for the class that gets the data and value the node will initially have.
	 * 
	 * @param data Initializes the data of the node.
	 * @param data Initializes the value of the node.
	 */
	public DLNode(T data, int value){
		dataItem = data;
		this.value = value;
		
	}
	
	/**
	 * Getter method for the value.
	 * 
	 * @return The value of the node, returns the value of the node.
	 */
	public int getValue() {
		return value;
		
	}
	
	/**
	 * Getter method for the data, returns the data of the node.
	 * 
	 * @return The data item of the node.
	 */
	public T getData() {
		return dataItem;
		
	}
	
	/**
	 * Getter method for the next node, returns the next node.
	 * 
	 * @return The next node.
	 */
	public DLNode<T> getNext() {
		return next;
		
	}
	
	/**
	 * Getter method for the previous node, returns the previous node.
	 * 
	 * @return The previous node.
	 */
	public DLNode<T> getPrevious() {
		return previous;
		
	}
	
	/**
	 * Sets the value of the node to the new value.
	 * 
	 * @param newValue The new value of the node.
	 */
	public void setValue(int newValue) {
		value = newValue;
		
	}
	
	/**
	 * Sets the data of the node to the new data.
	 * 
	 * @param newData The new data value for the node.
	 */
	public void setData(T newData) {
		dataItem = newData;
		
	}
	
	/**
	 * Sets the next node to the new address.
	 * 
	 * @param newNext The new address of the node next node.
	 */
	public void setNext(DLNode<T> newNext) {
		next = newNext;
		
	}
	
	/**
	 * Sets the previous node to the new previous.
	 * 
	 * @param newPrevious The new address of the node previous node.
	 */
	public void setPrevious(DLNode<T> newPrevious) {
		previous = newPrevious;
		
	}
}
