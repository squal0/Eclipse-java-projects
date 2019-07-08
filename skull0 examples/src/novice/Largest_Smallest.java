package novice;


//following number asks a user to input 5 numbers and then gets the largest and the smallest

import java.util.Scanner;

public class Largest_Smallest {

	public static void main(String[] args) {
		//declare a new scanner to read values entered
		@SuppressWarnings("resource")
		Scanner input  = new Scanner(System.in);
		//declare the variables to be used in the program.
		int a,b,c,d,e,largest;
		
		System.out.print("Enter the first number"); //prompt
		a  = input.nextInt(); //read values
		System.out.print("Enter the second number");
		b  = input.nextInt();
		System.out.print("Enter the third number");
		c  = input.nextInt();
		System.out.print("Enter the fourth number");
		d  = input.nextInt();
		System.out.print("Enter the fifth number");
		e  = input.nextInt();
		
		//assign the first variable as being the largest
		largest = a;
		
		if(a < b)
			largest = b;
			System.out.println(largest);
		if(b < c)
			largest = c;
			System.out.println(largest);
		if(c < d)
			largest = d;
			System.out.println(largest);
		if(d < e)
			largest = e;
			System.out.println(largest);

	}

}
