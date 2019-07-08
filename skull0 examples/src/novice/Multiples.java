package novice;
//program checks whether one number is a multiple of the other

import java.util.Scanner;

public class Multiples {

	public static void main(String[] args) {
		// Create a new scanner to read the data
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num1, num2;
		
		//prompt the user to enter the numbers
		System.out.println("Please enter a number");
		num1 = input.nextInt(); //read the values
		System.out.println("Please enter another number");
		num2 = input.nextInt();
		
		//check whether the numbers are multiples of each other
		if( num2 % num1 == 0)
			System.out.println("numbers are multiples");
		else
			System.out.println("numbers are not multiples");

	}

}
