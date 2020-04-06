package game.UI;
import java.util.Scanner;
import game.*;
/**
 * Class that has the main for the game menu to run and start. If added would create graphic menus by calling and give control to UI responses.
 * This class currently acts as a driver for user to select what games to play and a text menu
 * @author Matthew Temniuk
 *
 */
public class PlayGames {

	public static void main(String[] args) {
		String input;
		Scanner in = new Scanner(System.in); 
		Game game = null;
		String menu = "Welcome what game would you like to play? \n\t1.BlackJack \n\t2.Quit";
		String invalid = "\n--------------------------------------------------------\n"
					   + "Invalid input try inputting integer for a game or option" 
				       + "\n--------------------------------------------------------\n";
		
		while(true) {
			System.out.println(menu);
			input = in.next();
			game = null;
			
			switch(input) {
			case "1":
				game = GameFactory.createGame("Blackjack");
				break;
			case "2":
				in.close();
				System.out.println("Thanks for playing!");
				System.exit(0);
				break;
			default:
				System.out.println(invalid);
			}
			
			if(game != null) {
				game.play();
			}
			
		}

	}

}
