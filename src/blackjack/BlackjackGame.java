package blackjack;
import engine.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Matthew Temniuk
 *
 * A demonstration of the card game engine with a text based Blackjack game
 */
public class BlackjackGame {

	
	private ArrayList<Hand<BasicCard>> handList;
	
	private Deck<BasicCard> dealerDeck;
	
	public static void main(String[] args) {
		new BlackjackGame();

	}
	
	
	public BlackjackGame(){
		
		handList = new ArrayList<Hand<BasicCard>>();
		Scanner in = new Scanner(System.in); 
		  
        String input;
         
		
		boolean quit = false;
		
		while(quit!=true) {
			
			Hand<BasicCard> playerHand = new Hand<BasicCard>();
			Hand<BasicCard> dealerHand = new Hand<BasicCard>();
			while(!playerHand.isEmpty()) {
				playerHand.removeFirst();
			}
			while(!dealerHand.isEmpty()) {
				dealerHand.removeFirst();
			}
			handList.remove(playerHand);
			handList.remove(dealerHand);
			handList.add(playerHand);
			
			
			dealerDeck = engine.BasicDeckInteractions.createShuffledDeck();
			
			engine.BasicDeckInteractions.deal(dealerDeck, handList, 2);
			handList.remove(playerHand);
			handList.remove(dealerHand);
			handList.add(dealerHand);
			engine.BasicDeckInteractions.deal(dealerDeck, handList, 2);
			
			
			if (addValues(playerHand) == 21) {
				System.out.println("Player: \n" + playerHand.toString());
				System.out.println("Dealer: \n" + dealerHand.toString());
				System.out.println("Player win!");
				System.out.println("Would you like to quit?\ny. Yes \nn. No");
				input = in.nextLine();
				if(input.equals("y")) {
					quit = true;
				}
				
				continue;
			}else if (addValues(dealerHand) == 21) {
				System.out.println("Player: \n" + playerHand.toString());
				System.out.println("Dealer: \n" + dealerHand.toString());
				System.out.println("Player loses!");
				System.out.println("Would you like to quit?\ny. Yes \nn. No");
				input = in.nextLine();
				if(input.equals("y")) {
					quit = true;
				}
				continue;
			}
			
			boolean stand = false;
			while(stand != true && addValues(playerHand) < 21) {
				System.out.println("Player: \n" + playerHand.toString());
				System.out.println("Dealer: \n" + dealerHand.toString());
				
				if(playerHand.size() == 2) {
					System.out.println("What would you like to do?\nh. Hit \ns. Stand \nd. Double Down \nq. Quit");
				}else {
					System.out.println("What would you like to do?\nh. Hit \ns. Stand \nq. Quit");
				}
				
				input = in.nextLine();
				
				boolean valid = false;
				
				while(valid != true) {
					if(input.equals("h")) {
						valid = true;
						hit(playerHand,dealerHand);
						
					}else if(input.equals("s")) {
						valid = true;
						stand = true;
						stand(playerHand,dealerHand);
						
					}else if(input.equals("d")) {
						valid = true;
						doubleDown(playerHand,dealerHand);
						stand = true;
						
					}else if(input.equals("q")) {
						valid = true;
						quit = true;
						break;
						
					}else {
						System.out.println("Invalid input type proper input");
						if(playerHand.size() == 2) {
							System.out.println("What would you like to do?\nh. Hit \ns. Stand \nd. Double Down \nq. Quit");
						}else {
							System.out.println("What would you like to do?\nh. Hit \ns. Stand \nq. Quit");
						}
						input = in.nextLine();
						valid = false;
						
					}
				}
				if (quit == true) {
					break;
				}
			}
			if(stand != true) {
				findWinner(playerHand,dealerHand);
			}
				
			
			
			System.out.println("Would you like to quit?\ny. Yes \nn. No");
			input = in.nextLine();
			if(input.equals("y")) {
				quit = true;
			}
			
		}
	}
		
	private void doubleDown(Hand<BasicCard> playerHand, Hand<BasicCard> dealerHand) {
		handList.remove(playerHand);
		handList.remove(dealerHand);
		handList.add(playerHand);
		engine.BasicDeckInteractions.deal(dealerDeck, handList, 1);
		findWinner(playerHand,dealerHand);
		
	}

	private void stand(Hand<BasicCard> playerHand, Hand<BasicCard> dealerHand) {
		findWinner(playerHand,dealerHand);
		
	}

	private void hit(Hand<BasicCard> playerHand, Hand<BasicCard> dealerHand) {
		handList.remove(playerHand);
		handList.remove(dealerHand);
		handList.add(playerHand);
		engine.BasicDeckInteractions.deal(dealerDeck, handList, 1);
		
	}
	
	private void findWinner(Hand<BasicCard> playerHand, Hand<BasicCard> dealerHand){
		System.out.println("Player: \n" + playerHand.toString());
		System.out.println("Dealer: \n" + dealerHand.toString());
		
		if(addValues(playerHand) > 21) {
			System.out.println("Player loses!");
			
		}
		/*else if(addValues(playerHand) == 21 && addValues(dealerHand) == 21) {
			System.out.println("Player loses!");
			
		}else if(addValues(playerHand) == 21){
			System.out.println("Player Wins!");
			
		}*/else if(addValues(dealerHand) == 21) {
			System.out.println("Player Loses!");
			
		}else {
			while(addValues(playerHand) > addValues(dealerHand)) {
				handList.remove(playerHand);
				handList.remove(dealerHand);
				handList.add(dealerHand);
				engine.BasicDeckInteractions.deal(dealerDeck, handList, 1);
				System.out.println("Dealer: \n" + dealerHand.toString());
				
				if(addValues(playerHand) == 21 && addValues(dealerHand) == 21) {
					System.out.println("Player loses!");
					break;
					
				}else if(addValues(playerHand) < addValues(dealerHand) && addValues(dealerHand) <= 21) {
					System.out.println("Player loses!");
					break;
					
				} 
				
			}if(addValues(dealerHand) > 21 && addValues(playerHand) <= 21) {
				// Case where dealer busts but Player did not
				System.out.println("Player Wins!");
			}
			if (addValues(playerHand) == addValues(dealerHand)) {
				System.out.println("Player loses!");
			
			}
		}
	}
	
	private int addValues(Hand<BasicCard> theHand) {
		int sum = 0;
		int add;
		boolean ace = false;
		int numAces = 0;
		
		Iterator<BasicCard> hand = theHand.iterator();
		
		while (hand.hasNext()) {
			
			add = hand.next().getValue();
			
			//Add is representing the number of a Jack, Queen or King
			if (add == 11 || add == 12 || add == 13 ) {
				sum += 10;
			}else if(add == 14) {
				numAces++;
				ace = true;
			}else {
				sum += add;
			}
		}
		//Add best hand with each ace either 11 or 1
		if(ace) {
			if (numAces == 1) {
				if (sum + 11 > sum + 1 && sum + 11 <= 21) {
					sum += 11;
				}else {
					sum += 1;
				}
			}else if (numAces == 2){
				if(sum + 11 + 1 > sum + 1 + 1 && sum + 11 + 1 <= 21) {
					sum += 11 + 1;
				}else {
					sum += 2;
				}
			}else if (numAces == 3) {
				if(sum + 11 + 1 + 1 > sum + 1 + 1 + 1 && sum + 11 + 1 + 1 <= 21) {
					sum += 11 + 1 + 1;
				}else {
					sum += 3;
				}
			}else {
				if(sum + 11 + 1 + 1 + 1 > sum + 1 + 1 + 1 + 1 && sum + 11 + 1 + 1 + 1 <= 21) {
					sum += 11 + 1 + 1 +1;
				}else {
					sum += 4;
				}
			}
		}
		
		return sum;
	}
}
