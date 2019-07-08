/**
 * The following class is used to maintain grades of students
 * and display a grade report: i.e, grades, class average, lowest grade,
 * highest grade and a grade distribution bar chart
 */
package gradeBook;

/**
 * @author Home
 *
 */
public class GradeBook {
	private String courseName; //name of the course
	private int [][] grades; // 2D array of student grades

	public GradeBook(String courseName, int [][] grades){
		this.courseName = courseName;
		this.grades = grades;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	public String getCourseName(){
		return courseName;
	}
	public void processGrades(){ // perform various operations on the data
		outputGrades(); //output the grades array
		// call methods getMinimum and getMaximum
		System.out.printf("%n%s %d%n%s %d%n%n",
		"Lowest grade in the grade book is", getMin(),
		"Highest grade in the grade book is", getMax());
		outputBarChart();
	}
	public int getMin(){
		int lowGrade = grades[0][0]; // assume grade[0][0] is the lowest
		for (int studGrades[] : grades){
			for (int grade : studGrades){
				if(grade < lowGrade)
					lowGrade = grade;
			}
		}
		return lowGrade;
	}
	public int getMax(){
		int highGrade = grades[0][0]; // assume grade[0][0] is the lowest
		for (int studGrades[] : grades){
			for (int grade : studGrades){
				if(grade > highGrade)
					highGrade = grade;
			}
		}
		return highGrade;
	}
	public double getAverage(int [] setOfGrades){ //method to get the average
		int total = 0;
		for(int grade: setOfGrades)
			total += grade;
		return (double) total / setOfGrades.length;
	}
	public void outputBarChart(){
		System.out.println("Overall grade distribution :-");
		int [] freq = new int[11]; //stores frequency of grades in each range of 10 grades
		for(int[] studGrades : grades){
			for(int grade : studGrades)
				++freq[grade / 10]; //for each grade, increment the appropriate frequency
		}
			for(int count = 0; count < freq.length; count++){
				if(count  == 10)
					System.out.printf("%5d: ", 100);
				else
					System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
				
			for (int stars = 0; stars < freq[count]; stars++)
				System.out.print("*");
			System.out.println();
			}
		}
	//output the contents of the grades array
	public void outputGrades(){
		System.out.printf("The Grades are:%n%n");
		System.out.print("               "); //align column heads
		for (int test = 0; test < grades[0].length; test++) //create a column heading for each of the tests
			System.out.printf("Test %d ", test + 1);
		System.out.println("  Average"); //average column heading
		for (int stud  = 0; stud < grades.length; stud++){
			System.out.printf("Student %2d", stud + 1);
			for (int test : grades[stud])
				System.out.printf("%8d", test);
			double average = getAverage(grades[stud]);
			System.out.printf("%9.2f%n", average);
		}
	}
}
