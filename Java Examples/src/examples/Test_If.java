package examples;

/*java program to illustrate the use of decision making constructs
*that is the if and the switch statements
*/
//get the code that will allow us to call the scanner class utilities

import java.util.Scanner;

public class Test_If
{
	//create a member variable that can be inherited
	protected static Scanner userInput;
	//main method begins the execution of the program
	public static void main(String[] args)
	{
		//variables to be used in the program
		byte mathScore, engScore, swaScore, scieScore;
		//instantiate the  userInput object
		userInput  = new Scanner(System.in);
		
		//prompt the user for scores in various subjects
		System.out.println("Please enter the score in Math");
		//read in the score in math
		mathScore = userInput.nextByte();
		System.out.println("Please enter the score in English");
		//read in the score in English
		engScore = userInput.nextByte();
		System.out.println("Please enter the score in Kiswahili");
		//read in the score in Kiswahili
		swaScore = userInput.nextByte();
		System.out.println("Please enter the score in Science");
		//read in the score in Science
		scieScore = userInput.nextByte();
		
		//variables to find the average, grade and the total score
		int totalScore  = mathScore + engScore + swaScore + scieScore;
		float meanScore = totalScore / 4;
		char grade;
		
		if ( meanScore >= 80){
			grade  = 'A';
		}
		else if ( meanScore >= 70){
			grade = 'B';
		}
		else if ( meanScore  >= 60){
			grade = 'C';
		}
		else if ( meanScore >= 50){
			grade = 'D';
		}
		else
			grade = 'E';
		 // give a comment based on the grade
			String comment; //string variable to hold the comment
			
			switch(grade){
			
			case 'A':
				comment = "Excellent";
				break;
			case 'B':
				comment = "Very Good";
				break;
			case 'C':
				comment = "Good";
				break;
			case 'D':
				comment = "Fair";
				break;
			default:
				comment = "Try harder next time.";
				break;
			}
			
			//display the output
			System.out.println("Math    \t-> " + mathScore);
			System.out.println("English \t-> " + engScore);
			System.out.println("Kiswahili \t-> " + swaScore);
			System.out.println("Science \t-> " + scieScore);
			System.out.println("Total Score \t-> " + totalScore);
			System.out.println("Mean Score \t-> " + meanScore);
			System.out.println("Grade   \t-> " + grade);
			System.out.println("Comment \t-> " + comment);
		

		

	}

}
