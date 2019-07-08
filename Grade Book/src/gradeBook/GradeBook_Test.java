/**
 * 
 */
package gradeBook;

/**
 * @author Home
 *
 */
public class GradeBook_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] gradesArray = {{34,67,88},
								{78,92,12},
								{67,23,100},
								{45,32,90},
								{89,64,78},
								{100,95,20},
								{26,61,29},
								{55,97,100},
								{50,91,80},
								{65,77,20}
								};
		GradeBook book = new GradeBook("Advanced Software Development", gradesArray);
		System.out.printf("Welcome to the student Grade Book for: %n%s%n%n", 
				book.getCourseName());
		book.processGrades();
	}

}
