package novice;

//the following program does some simple arithmetic computations.


import javax.swing.JOptionPane; //imports the JOptionPane

public class Mathematicals {

	//main method of the program
	public static void main(String[] args) {

		//declare the variables to be used in the program.
		int num1,num2;
		//variables for the calculation to be done
		int sum,multiplication,subtraction;
		float division,average;
		
		
		//get the input for the first number from a user
		num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number"));
		
		//get input for the second number
		num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter another number"));
		
		
		sum = num1 + num2; //adds the numbers
		multiplication = num1 * num2; //multiplies the numbers
		subtraction = num1 - num2; //subtracts the numbers
		division = num1 / num2; // divides the numbers
		average  = (num1 + num2 ) / 2;
		
		//displays the results of the computation
		JOptionPane.showMessageDialog(null,sum);
		JOptionPane.showMessageDialog(null, multiplication);
		JOptionPane.showMessageDialog(null, subtraction);
		JOptionPane.showMessageDialog(null, division);
		JOptionPane.showMessageDialog(null, average);
		
		
	}

}
