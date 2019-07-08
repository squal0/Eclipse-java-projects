/**
 *Student class that stores the Student's name and average 
 */
package grading;

/**
 * @author squal0
 *
 */
public class Student {

	//instance variables
	private String name;
	private double average;
	
	//constructor initializes the instance variables
	public Student(String name, double average) {
		this.name = name;
		//validate that the average is > 0.0 and < 100.0
		//instance variable average's default value (0.0)
		if ( average > 0.0)
			if (average <= 100.0)
				this.average = average; //assign it to the instance variable
	}
	//sets the student name
	public void setName(String name){
		this.name = name;
	}
	//retrieve the students name
	public String getName(){
		return name;
	}
	//sets the students average
	public void setAverage(double average){
		//validate that the average is > 0.0 and < 100.0
		//instance variable average's default value (0.0)
		if ( average > 0.0)
			if (average <= 100.0)
				this.average = average; //assign it to the instance variable
	}
	//retrieve the students average
	public double getAverage(){
		return average;
	}
	//determines and returns the students letter grade
	public String getLetterGrade(){
		String letterGrade = ""; //initialize it to an empty string
		
		if (average >= 90)
			letterGrade = "A";
		else if (average >= 80)
			letterGrade = "B";
		else if (average >= 70)
			letterGrade = "C";
		else if (average >= 60)
			letterGrade = "D";
		else
			letterGrade = "F";
		
		return letterGrade;
	}
	
}


