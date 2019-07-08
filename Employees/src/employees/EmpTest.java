/**
 *Driver class that show cases the capabilities
 *of the EmpDetails class 
 */
package employees;

/**
 * @author squal0
 *
 */
public class EmpTest {

	/**
	 * @param args
	 */	
	public static void main(String[] args) {

		EmpDetails emp1 = new EmpDetails("Alex", "SilverFang", 349593.45);
		EmpDetails emp2 = new EmpDetails("Reina", "Smith", 56004.00);
		EmpDetails emp3 = new EmpDetails("Dwayne", "Johnson", 220442.03);
		
		//output the employee details before the 10% salary increase 
		System.out.println("THE EMPLOYEES SALARY BEFORE 10% INCREASE");
		System.out.printf("First Name: %s%nSecond Name: %s%nSalary: $%.2f%n", emp1.getFirst(), emp1.getSecond(), emp1.getSalary() );
		System.out.println("==========================================");
		System.out.printf("First Name: %s%nSecond Name: %s%nSalary: $%.2f%n", emp2.getFirst(), emp2.getSecond(), emp2.getSalary() );
		System.out.println("==========================================");
		System.out.printf("First Name: %s%nSecond Name: %s%nSalary: $%.2f%n", emp3.getFirst(), emp3.getSecond(), emp3.getSalary() );
		System.out.println("******************************************");
		//output the employee details after the 10% salary increase
		System.out.println("THE EMPLOYEES SALARY AFTER 10% INCREASE");
		System.out.printf("First Name: %s%nSecond Name: %s%nSalary: $%.2f%n", emp1.getFirst(), emp1.getSecond(), emp1.getIncrease() );
		System.out.println("==========================================");
		System.out.printf("First Name: %s%nSecond Name: %s%nSalary: $%.2f%n", emp2.getFirst(), emp2.getSecond(), emp2.getIncrease() );
		System.out.println("==========================================");
		System.out.printf("First Name: %s%nSecond Name: %s%nSalary: $%.2f%n", emp3.getFirst(), emp3.getSecond(), emp3.getIncrease() );
		

	}

}
