package engine.card;

/**
 * 
 * @author Matthew Temniuk
 * Created March 19, 2019
 *
 * A standard card to be used in a basic card game.
 */
public class BasicCard implements CardADT,Comparable<BasicCard> {
	/**
	 * Enumeration to represent the Suit of a standard card
	 * 
	 * @author Matthew Temniuk
	 *
	 */
	public static enum Suit{
		DIAMONDS("Diamonds"), 
		HEARTS("Hearts"),
		SPADES("Spades"), 
		CLUBS("Clubs"),
		JOKER("Joker");
		
		
		private String value;
		/**
		 * Constructor for the Suit to set the value.
		 * @param value value to set as the Suit
		 */
		private Suit(String value) {
			this.value = value;
		}
		/**
		 * Returns the string value of the Suit.
		 * @return The string representation of the Suit
		 */
		public String getValue() {
			return value;
		}
	}
	
	private String name;
	
	private int cardValue;

	private int cardID;
	
	private Suit cardSuit;
	
	private String imageFileName;
	/**
	 * Constructor to create a BasicCard, takes value, ID, and suit to create the card and generate the base image file name
	 * 
	 * @param value Number value of the card.
	 * @param ID  User given int to differentiate cards from one another.
	 * @param suit Suit of the Card.
	 */
	public BasicCard(int value, int ID, Suit suit) {
		cardValue = value;
		cardID = ID;
		cardSuit = suit;
		if (!suit.equals(Suit.JOKER)) {
			name = cardValue + " of " + suit.getValue();
			imageFileName = cardValue + "_of_" + suit.getValue();
		}else {
			name = "Joker"; 
			if (ID == 20*4) {
				imageFileName = "Red_Joker";
			}else {
				imageFileName = "Black_Joker";
			}
			
		}
		
		
	}
	/**
	 * Initializes a card with a value that can be different than the one in the card name. Also gives option to have a different image file
	 * 
	 * @param value
	 * @param ID
	 * @param suit
	 * @param cardName
	 * @param imageFile Image file to use to represent the card
	 */
	public BasicCard(int value, int ID,Suit suit, String cardName, String imageFile) {
		cardValue = value;
		cardID = ID;
		cardSuit = suit;
		name = cardName;
		imageFileName = imageFile;
	}
	
	public int getValue() {
		return cardValue;
	}
	
	public int getID() {
		return cardID;
	}
	
	public Suit getSuit() {
		return cardSuit;
	}
	/**
	 * Returns the image filename
	 */
	public String getImage() {
		return imageFileName;
	}
	
	public Boolean isJoker() {
		return name.equals("Joker");
	}
	
	public Boolean equalValues(BasicCard otherCard) {
		boolean result = false;
		if(getValue() == otherCard.getValue()) {
			result = true;
		}
		return result;
	}
	public String toString() {
		return name;	
	}
	
	public int compareValue(BasicCard obj) {
		return getValue() - obj.getValue();
	}
	
	private int suitWeight() {
		final int SEPERATION_BASE = 20;
		if(getSuit().equals(Suit.HEARTS)) {
			return 0;
		}else if (getSuit().equals(Suit.DIAMONDS)) {
			return SEPERATION_BASE;
		}else if (getSuit().equals(Suit.SPADES)) {
			return SEPERATION_BASE * 2;
		}else if (getSuit().equals(Suit.CLUBS)) {
			return SEPERATION_BASE * 3;
		}else {
			return SEPERATION_BASE * 4;
		}
	}
	
	public int compareTo(BasicCard obj) {
		int valueLeft = getValue() + suitWeight();
		int valueRight = obj.getValue() + obj.suitWeight();
		
		return valueLeft - valueRight;
	}
	public boolean equals(BasicCard obj) {
		if (getValue() == obj.getValue() && getSuit().equals(obj.getSuit())) {
			return true;
		}else {
			return false;
		}
	}
	
}
