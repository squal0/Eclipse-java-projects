/**
 * The following program simulates the game of chance(craps)
 * It uses the enum types to give the status of the game.
 * It also uses the SecureRandom class to simulate random
 * throwing of the dice.
 */
package chanceGames;

/**
 * @author Home
 *
 */
import java.security.SecureRandom;
public class Casino_Craps {

	/**
	 * @param args
	 */
	//create a secure random generator to be used in the method rollDice()
	private static final SecureRandom randNums = new SecureRandom();
	//enum types with constants that represent the game status
	private enum Status { CONTINUE, WON, LOST};
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_ELEVEN = 11;
	private static final int BOX_CARS = 12;
	
	//play the game of craps
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myPoint = 0; //stores the point if a player does not win or loose on first roll
		Status gameStat; //keeps track of the status of the game
		
		int sumOfDice = rollDice(); // first roll of the dice
		
		//determine the game status and the points based on the first die roll
		switch(sumOfDice){
		case SEVEN: //win with 7 on first roll
		case YO_ELEVEN: //win with 11 on first roll
			gameStat = Status.WON; //update the game status
			break;
		case SNAKE_EYES: //loose with 2 on first roll
		case TREY: //loose with 3 on first roll
		case BOX_CARS: //loose with 12 on first roll
			gameStat = Status.LOST; //update the game status
			break;
			default: // did not win or loose so remember point
				gameStat = Status.CONTINUE; //continue the game
				myPoint = sumOfDice; //remember the point
				System.out.printf("The point is: %d%n", myPoint);
				break;
		}
		//while the game is not complete
		while( gameStat == Status.CONTINUE){
			sumOfDice = rollDice();
			//determine the status of the game
			//display the winning or loosing messages
			if(sumOfDice == myPoint){
				gameStat = Status.WON;
				System.out.println("Congratulations!!!... You won the game!");
			}
			else if(sumOfDice == 7){
				gameStat = Status.LOST;
				System.out.println("Sorry you lost..... Better luck next time.");
			}
		}
	}
	//method to roll the dice, calculate the sum and display the result
	public static int rollDice() {
		int die1 = 1 + randNums.nextInt(6); //roll the dice for the first time
		int die2 = 1 + randNums.nextInt(6); //roll the dice a second time
		int sum = die1 + die2; //sum of both rolls of the dice
		
		//display the results of the die roll
		System.out.printf("The player rolled %d + %d = %d%n", die1, die2, sum);
		return sum;
	}

}
