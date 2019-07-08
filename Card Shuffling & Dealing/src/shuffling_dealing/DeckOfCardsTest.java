/**
 * Calls the methods from DeckOFCards class and uses them
 * to simulate card shuffling and dealing
 */
package shuffling_dealing;

/**
 * @author Home
 *
 */
public class DeckOfCardsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards myDeck = new DeckOfCards();
		myDeck.shuffle(); //shuffle the cards in random order
		for(int i = 1; i <= 52; i++){ //print all 52 cards in the order they are dealt
			System.out.printf("%-19s", myDeck.dealCard()); // deal and display cards
			if ( i % 4 == 0) //output a new line after every fourth card
				System.out.println();
		}
	}

}
