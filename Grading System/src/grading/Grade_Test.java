/**
 * Driver class that calls the Student's class methods
 * used to create and test Student objects
 */
package grading;

/**
 * @author squal0
 *
 */
public class Grade_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stud1 = new Student ("Reina Smith", 59.3);
		Student stud2 = new Student ("Maria Hill", 89.9);
		
		//output the students names plus the grades they achieved
		System.out.printf("%s's letter grade is: %s%n", stud1.getName(), stud1.getLetterGrade());
		System.out.printf("%s's letter grade is: %s%n", stud2.getName(), stud2.getLetterGrade());
	}

}
