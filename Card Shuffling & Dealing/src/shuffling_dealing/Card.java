/**
 * Class that declares the card face and the card suit
 */
package shuffling_dealing;

/**
 * @author Home
 *
 */
public class Card {
	private final String face; //face of the card (ACE, DEUCE  ....)
	private final String suit; //suit of the card (Hears, Clubs....)
	
	//constructor
	public Card(String cardFace, String cardSuit){
		this.face = cardFace;
		this.suit = cardSuit;
	}
	//returns the string representation of a card
	public String toString(){
		return face + " of " + suit;
	}
}
