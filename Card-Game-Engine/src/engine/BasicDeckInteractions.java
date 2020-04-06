package engine;

import java.util.ArrayList;
import java.util.Iterator;

import engine.BasicCard.Suit;
/**
 * 
 * @author Matthew Temniuk
 * Created March 19, 2019
 * 
 * A class of deck interactions that are common with BasicCards in a deck
 */
public class BasicDeckInteractions {
	
	/**
	 * Creates a deck with all numbers of a normal set of cards for each Suit
	 * 
	 * @return a deck with all cards of a normal deck except jokers.
	 */
	public static Deck<BasicCard> createDeck(){
		Suit suit =  Suit.DIAMONDS;
		BasicCard card;
		int NUMBER_OF_CARDS_PER_SUIT = 13;
		Deck<BasicCard> deck = new Deck<BasicCard>();
		
		for(int count = 0; count < 4; count++) {
			if (count == 1) {
				suit = Suit.HEARTS;
			}else if (count == 2) {
				suit = Suit.SPADES;
			}else {
				suit = Suit.CLUBS;
			}
			
			for(int value = 2; value <= 14; value++) {
				if (value <= 10) {
					card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit);
					
				}else {
					if (value == 11) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Jack of " + suit.getValue(),"Jack_of_" + suit.getValue());
					}else if (value == 12) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Queen of " + suit.getValue(),"Queen_of_" + suit.getValue());
					}else if (value == 13){
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "King of " + suit.getValue(),"King_of_" + suit.getValue());
					}else {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Ace of " + suit.getValue(),"Ace_of_" + suit.getValue());
					}
				}
				deck.insert(card, value);
			}
		}
		return deck;
	}
	/**
	 * Creates a shuffled Deck without Jokers
	 * @return A shuffled Deck without Jokers
	 */
	public static Deck<BasicCard> createShuffledDeck(){
		Deck<BasicCard> deck = createDeck();
		deck.shuffle();
		return deck;
	}
	/**
	 * 
	 * @return A shuffled Deck with Jokers
	 */
	public static Deck<BasicCard> createDeckWithJokers(){
		Deck<BasicCard> deck = createDeck();
		deck.insert(new BasicCard(20 * 4, 20 * 4, Suit.JOKER), 20 * 4);//Joker 1
		deck.insert(new BasicCard(20 * 4, 20 * 4 + 1, Suit.JOKER), 20 * 4);//Joker 2
		deck.shuffle();
		return deck;
	}
	/**
	 * 
	 * @return A shuffled Deck with Jokers and the Ace as the lowest value card
	 */
	public static Deck<BasicCard> createDeckWithJokersAndAceLowest(){
		Deck<BasicCard> deck = createDeckWithAceAsLowest();
		deck.insert(new BasicCard(20 * 4, 20 * 4, Suit.JOKER), 20 * 4);//Joker 1
		deck.insert(new BasicCard(20 * 4, 20 * 4 + 1, Suit.JOKER), 20 * 4);//Joker 2
		deck.shuffle();
		return deck;
	}
	/**
	 * 
	 * @return A shuffled Deck with Jokers and the 3 as the lowest value card and the 2 as the highest
	 */
	public static Deck<BasicCard> createDeckWithJokersAndThreeAsLowest(){
		Deck<BasicCard> deck = createDeckWithThreeAsLowest();
		deck.insert(new BasicCard(20 * 4, 20 * 4, Suit.JOKER), 20 * 4);//Joker 1
		deck.insert(new BasicCard(20 * 4, 20 * 4 + 1, Suit.JOKER), 20 * 4);//Joker 2
		deck.shuffle();
		return deck;
	}
	/**
	 * Deck with 3 as lowest, 2 as 2nd highest after jokers
	 * @return
	 */
	public static Deck<BasicCard> createDeckWithThreeAsLowest(){
		Suit suit =  Suit.DIAMONDS;
		BasicCard card;
		int NUMBER_OF_CARDS_PER_SUIT = 13;
		Deck<BasicCard> deck = new Deck<BasicCard>();
		
		for(int count = 0; count < 4; count++) {
			if (count == 1) {
				suit = Suit.HEARTS;
			}else if (count == 2) {
				suit = Suit.SPADES;
			}else {
				suit = Suit.CLUBS;
			}
			
			for(int value = 3; value <= 15; value++) {
				if (value <= 10) {
					card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit);
					
				}else {
					if (value == 11) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Jack of " + suit.getValue(),"Jack_of_" + suit.getValue());
					}else if (value == 12) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Queen of " + suit.getValue(),"Queen_of_" + suit.getValue());
					}else if (value == 13) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "King of " + suit.getValue(), "King_of_" + suit.getValue());
					}else if (value == 14) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Ace of " + suit.getValue(),"Ace_of_" + suit.getValue());
					}else {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "2 of " + suit.getValue(),"2_of_" + suit.getValue());
					}
				}
				deck.insert(card, value);
			}
		}
		return deck;
	}
	/**
	 * Deck with Ace as lowest
	 * @return Deck with Ace as lowest
	 */
	public static Deck<BasicCard> createDeckWithAceAsLowest(){
		Suit suit =  Suit.DIAMONDS;
		BasicCard card;
		int NUMBER_OF_CARDS_PER_SUIT = 13;
		Deck<BasicCard> deck = new Deck<BasicCard>();
		
		for(int count = 0; count < 4; count++) {
			if (count == 1) {
				suit = Suit.HEARTS;
			}else if (count == 2) {
				suit = Suit.SPADES;
			}else {
				suit = Suit.CLUBS;
			}
			
			for(int value = 1; value <= 13; value++) {
				if (value == 1) {
					card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Ace of " + suit.getValue(),"Ace_of_" + suit.getValue());
				}else if (value <= 10) {
					card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit);
					
				}else {
					if (value == 11) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Jack of " + suit.getValue(),"Jack_of_" + suit.getValue());
					}else if (value == 12) {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "Queen of " + suit.getValue(),"Queen_of_" + suit.getValue());
					}else {
						card = new BasicCard(value, count * NUMBER_OF_CARDS_PER_SUIT + value, suit, "King of " + suit.getValue(), "King_of_" + suit.getValue());
					}
				}
				deck.insert(card, value);
			}
		}
		return deck;
	}
	/**
	 * Deals the deck until no cards are left in the deck.
	 * 
	 * @param deck The deck used to deal to the hands
	 * @param hands An ArrayList of hands that the deck will add to
	 */
	public static void deal(Deck<BasicCard> deck, ArrayList<Hand<BasicCard>> hands) {
		while(!deck.isEmpty()) {
			Iterator<Hand<BasicCard>> iterator = hands.iterator();
			while (iterator.hasNext()) {
				if(!deck.isEmpty()) {
					iterator.next().add(deck.draw());
				}else {
					iterator.next();
				}
				
			}
		}
	}
	/**
	 * Deals cards to the hands of players until each hand has numberToGive cards in hand.
	 * 
	 * @param deck The deck used to deal to the hands
	 * @param hands An ArrayList of hands that the deck will add to
	 * @param numberToGive Total number of cards to give to each player as long as the deck does not run out of cards
	 */
	public static void deal(Deck<BasicCard> deck,ArrayList<Hand<BasicCard>> hands, int numberToGive) {
		for(int count = 0; (count < numberToGive) && (!deck.isEmpty());count++) {
			Iterator<Hand<BasicCard>> iterator = hands.iterator();
			while (iterator.hasNext()) {
				if(!deck.isEmpty()) {
					iterator.next().add(deck.draw());
				}else {
					iterator.next();
				}
			}
			
		}
	}
	
}