/**
 * 
 */
package novice;

/**
 * @author Home
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "radar";
		System.out.print(reverseString(str));

	}
	
	public static String reverseString(String string){
		StringBuffer buffer = new StringBuffer(string);
		String r_string = buffer.reverse().toString();
		
		if(string.length() == 0){
			return null;
		}
		else if(r_string.equals(string)){
			return "true";
		}
		else{
			return r_string;
		}
		
	}

}
