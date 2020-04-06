package engine;
import java.util.Random;

/**
 * 
 * @author Matthew Temniuk
 * Created March 19, 2019
 *
 * A deck to store multiple cards of type T using a doubly linked list.
 */
public class Deck<T> {
		
	private int size;
	
	private DLNode<T> front;
	
	private DLNode<T> rear;
	
	public Deck() {
		size = 0;
		front = null;
		rear = null;
	}
	
	public T draw() throws EmptyDeckException {
		if(isEmpty()) {
			throw new EmptyDeckException("Cannot draw from an empty deck");
		}
		T result = front.getData();
		front = front.getNext();
		
		
		if(size == 1) {
			rear = null;
			front = null;
		}else {
			front.setPrevious(null);
		}
		
		size--;
		
		return result;
	}
	
	public void shuffle() throws EmptyDeckException{
		if(isEmpty()) {
			throw new EmptyDeckException("Cannot shuffle an empty deck");
		}
		
		T[] deck = (T[]) (new Object[size]);
		
		
		for(int index = 0; index < size; index++) {
			deck[index] = draw();
			
		}
		
		Random rand = new Random(System.currentTimeMillis()); 
        
        for (int index = 0; index < size; index++) 
        { 
            // Random for remaining positions. 
            int randomSwapIndex = index + rand.nextInt(size - index); 
              
             // Swapping the elements 
             T temp = deck[randomSwapIndex]; 
             deck[randomSwapIndex] = deck[index]; 
             deck[index] = temp; 
               
        } 
        
        Deck<T> shuffledDeck = new Deck<T>(); 
        
        for(int index = 0; index < size; index++) {
        	
        	shuffledDeck.insert(deck[index], index);
        }
        
       this.front = shuffledDeck.front;
       this.rear = shuffledDeck.rear;
	}
	
	/**
	 * Adds a new node with dataItem and value to the end of the list. 
	 * 
	 * @param dataItem The data that the new node will be set to.
	 * @param value The value that the new node will be set to.
	 */
	public void insert(T dataItem, int value) {
		DLNode<T> newNode = new DLNode<T>(dataItem,value);
		
		if (isEmpty()) {
			front = newNode;
			front.setNext(null);
			front.setPrevious(null);
			
		}else {
			rear.setNext(newNode);
			newNode.setPrevious(rear);
			newNode.setNext(null);
			
		}
		rear = newNode;
		size++;
		
	}
	
	/**
	 * Gets the value of the node that has a equal dataItem value to the dataItem parameter.
	 * 
	 * @return The value of the node with the dataItem value equal to the dataItem parameter.
	 * @throws InvalidDataItemException Throws when the dataItem is not found in the list.
	 */
	public int getDataValue(T dataItem) throws InvalidDataItemException {
		boolean found = false;
		DLNode<T> current = front;
		
		while((!found) && (current != null)) {
			if(current.getData().equals(dataItem)) {
				found = true;
				
			}
			current = current.getNext();
			
		}
		if(!found) {
			throw new InvalidDataItemException("Data item to retrieve the value of is not in the list");
			
		}
		return current.getValue();
		
	}

	/**
	 * Returns a boolean for if the list is empty or not.
	 * 
	 * @return True if the size of the list is zero and false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
		
	}

	/**
	 * Returns the size of the list.
	 * 
	 * @return The size of the list
	 */
	public int size() {
		return size;
		
	}
	
	/**
	 * Returns a string representation of the list.
	 * 
	 * @return The string representing the doubly linked list.
	 */
	public String toString() {
		String result = "Deck: ";
		DLNode<T> current = front;
		
		while(current != null) {
			result += current.getData().toString() + "\n";
			current = current.getNext();
			
		}
		return result;
		
	}
	
}
