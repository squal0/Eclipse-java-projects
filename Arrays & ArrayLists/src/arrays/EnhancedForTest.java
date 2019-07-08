/**
 * The following program uses the enhanced for loop 
 * to sum the integers in array of student grades
 */
package arrays;

/**
 * @author Home
 *
 */
public class EnhancedForTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] studGrades = { 34,55,56,22,75,78,98,100,34,56,78,12,39,40,14,66};
		int total = 0;
		double average = 0;
		System.out.println("Grades");
		for(int grades : studGrades){
			System.out.printf("%n%d", grades);
			total += grades;
		}
		average = (double)total / studGrades.length;
		System.out.printf("%n%nThe total of the grades is %d%n", total);
		System.out.printf("The average of all the grades is %.2f", average);
	}

}
