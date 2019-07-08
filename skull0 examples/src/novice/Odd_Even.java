package novice;

//asks the user to input a number and then checks if that number is odd or even

import java.util.Scanner;

public class Odd_Even {

	public static void main(String[] args) {
		// Create a new scanner for the input of data
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//variable to be used
		int num;
		
		//prompt for the number
		System.out.println("Please enter a number");
		num  = input.nextInt();
		
		if (num % 2 == 0)
			System.out.println("The number is even");
		else
			System.out.println("The number is odd");
		
		

	}

}
