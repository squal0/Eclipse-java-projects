/**
 * class that contains the dealing and shuffling methods
 */
package shuffling_dealing;

/**
 * @author Home
 *
 */
import java.security.SecureRandom;
public class DeckOfCards {
	private Card[] deck; //array of card objects
	private int currentCard; // index of next card to be dealt (0 - 51)
	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom randNums = new SecureRandom();
	
	//constructor fills the deck of cards
	public DeckOfCards(){
		String [] faces = {"ACE", "DEUCE", "THREE", "FOUR", "FIVE", "SIX", "SEVEN",
							"EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
		String [] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
		deck = new Card[NUMBER_OF_CARDS]; //array of card objects
		currentCard = 0; //first card dealt will deck[0]
		
		//populate deck with card objects
		for (int count = 0; count < deck.length; count++){
			deck[count] = new Card (faces[count % 13], suits[count / 13]);
		}
		}
	//shuffle the deck of cards with one pass algorithm
	public void shuffle(){
		currentCard = 0; //next call method dealCard should start at deck[0] again
		
		//for each card pick another random card (0 - 51) and swap them		
		for(int first = 0; first < deck.length; first++){
			int second = randNums.nextInt(NUMBER_OF_CARDS);
			//swap current card with randomly selected card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	public Card dealCard(){
		if(currentCard < deck.length){ // determine whether there are cards left to be dealt
			return deck[currentCard++]; //return current card in array
		}
		else{
			return null;//return null to indicate that all cards were dealt
		}
	}
	}
