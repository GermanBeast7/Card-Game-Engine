package engine.card;
/**
 * 
 * @author Matthew Temniuk
 * Created March 19, 2019
 *
 */
public interface CardADT {
	/** 
	 * @return Return the value of the card
	 */
	public int getValue();
	
	/**
	 * @return Id of the card
	 */
	public int getID();
	
	/**
	 * @return String of the image file to represent a card
	 */
	public String getImage();
	
	/**
	 * @return String representation of card
	 */
	public String toString();
	
}
