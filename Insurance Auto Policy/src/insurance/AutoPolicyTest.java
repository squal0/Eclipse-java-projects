/**
 * class calls the methods from AutoPolicy and determine whether 
 * the Auto Policy for the state is no fault
 */
package insurance;

/**
 * @author Home
 *
 */
public class AutoPolicyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create 2 AutoPolicy objects
		AutoPolicy policy1 = new AutoPolicy(211, "Mercedes CLS 350", "MA");
		AutoPolicy policy2 = new AutoPolicy (212, "BMW 320i", "RI");
		
		//display whether each policy is in a no-fault state
		policyInNoFaultSate(policy1);
		policyInNoFaultSate(policy2);
	}
	//method that displays whether an AutoPolicy
	//is in a state with no-fault auto insurance
	public static void policyInNoFaultSate(AutoPolicy policy) {
		System.out.println("The auto policy:");
		System.out.printf("Account #: %d: Car: %s: State %s %s a no-fault state%n%n"
				, policy.getAccNo(), policy.getMakeAndModel(), policy.getState(),
				(policy.isNoFaultState() ? "is" : "is not"));
		
	}

}
