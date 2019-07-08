/**
 * class that represents an auto insurance policy
 */
package insurance;

/**
 * @author Home
 *
 */
public class AutoPolicy {
	private int accNo; //policy account number
	private String makeAndModel; //car that the policy applies to
	private String state; //2-letter state abbreviation
	
	//constructor
	public AutoPolicy(int accNo, String makeAndModel, String state){
		this.setAccNo(accNo);
		this.setMakeAndModel(makeAndModel);
		this.setState(state);
	}

		//getter and setter methods for the instance variables used
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getMakeAndModel() {
		return makeAndModel;
	}

	public void setMakeAndModel(String makeAndModel) {
		this.makeAndModel = makeAndModel;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//predicate method that returns whether a state has no fault insurance
	public boolean isNoFaultState(){
		boolean noFaultState;
		
		//determine whether the state has no fault insurance
		switch(getState()){ //get AutoPolicy object's state abbreviation
		case "MA": case "NJ": case "NY": case "PA":
			noFaultState = true;
			break;
			default:
				noFaultState = false;
				break;
		}
		return noFaultState;
	}
}
