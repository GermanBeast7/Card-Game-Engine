package engine;
/**
 * 
 * @author Matthew Temniuk
 * Created March 19, 2019
 *
 */
public interface CardADT {
	
	public int getValue();
	
	public int getID();
	/**
	 * 
	 * @return String of the image file to represent a card
	 */
	public String getImage();
	
	public String toString();
	
}
