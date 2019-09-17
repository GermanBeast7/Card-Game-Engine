package engine;
/**
 * @author Matthew Temniuk
 * Created March 19, 2019
 * 
 * Exception thrown when the deck is empty and a card is attempted to be drawn.
 */
public class EmptyDeckException extends RuntimeException {
	/**
	   * Sets up this exception with an appropriate message.
	   * @param message String representing the error encountered
	   */
	  public EmptyDeckException (String message) {
		  super (message);
	  }
}
