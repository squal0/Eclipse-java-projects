package novice;

//the below program is used to demonstrate the use of the equality and relational operators

import java.util.Scanner; //import the scanner class

public class Comparison {

	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a scanner to read input from a user
		@SuppressWarnings("resource")
		Scanner cmp = new Scanner(System.in);
		
		//declare the variables to be used in the application
		int number1,number2;
		
		System.out.print("Enter a number: "); //prompt
		number1 = cmp.nextInt(); //read the number from the user
		
		System.out.print("Enter another number: "); //prompt
		number2 = cmp.nextInt();
		
		//do the compare using the if control statement
		if (number1 == number2)
			//System.out.printf(" %d == %d%n", number1, number2);
			System.out.println(" are equal");
		if (number1 != number2)
			//System.out.printf(" %d != %d%n", number1, number2);
			System.out.println(" are not equal");
		if (number1 < number2)
			//System.out.printf(" %d < %d%n", number1, number2);
			System.out.println(" number1 is less than number2");
		if (number1 > number2)
			//System.out.printf(" %d > %d%n", number1, number2);
			System.out.println(" number1 is greater than number2");
		if (number1 <= number2)
			//System.out.printf(" %d <= %d%n", number1, number2);
			System.out.println(" number1 is less than or equal to number2");
		if (number1 >= number2)
			//System.out.printf(" %d >= %d%n", number1, number2);
			System.out.println(" number1 is greater than or equal to number2");
	}

}
