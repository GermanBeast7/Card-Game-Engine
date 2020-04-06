package game;
import game.blackjack.*;
/**
 * Factory to create the game object to be played
 * @author Matthew Temniuk
 *
 */
public class GameFactory {
	public static Game createGame(String gameName) {
		switch(gameName) {
		case "Blackjack":
			return new BlackjackGame();
		default:
			return null;
		}
	}
}
