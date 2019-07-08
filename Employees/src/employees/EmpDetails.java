/**
 * following class displays the employees first and last names
 * it also displays their monthly salary
 * methods will be created to give the employee a 10% pay rise
 * together with the displaying of the employee's yearly salary.
 */
package employees;

/**
 * @author squal0
 *
 */
public class EmpDetails {
	
	//declaring the instance variables
	String firstName;
	String secondName;
	double salary;
	double yrSalary;
	
	//constructor that initializes the above instance variables
	public EmpDetails(String firstName, String secondName, double salary){
		this.firstName = firstName;
		this.secondName = secondName;
		this.salary = salary;
	}
	//get method for firstName
	public String getFirst(){
		return firstName;
	}
	//set method for firstName
	public void setFirst(String firstName){
		this.firstName = firstName;
	}
	//get method for secondName
	public String getSecond(){
		return secondName;
	}
	//set method for secondName
	public void setSecond(String secondName){
		this.secondName = secondName;
	}
	//get method for salary
	public double getSalary(){
	   yrSalary = salary * 12;
		return yrSalary;
	}
	//set method for salary
	public void setSalary(double salary){
		//validate that the inputed salary is greater than 0.0
		if (salary > 0.0)
			this.salary = salary;
	}
	//method to get the increase in salary
	public double getIncrease(){
		double increase = yrSalary * 10/100;
		double total = yrSalary + increase;
		return total;
		
	}

}
