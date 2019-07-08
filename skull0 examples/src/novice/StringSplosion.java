/**
 * 
 */
package novice;

/**
 * @author Home
 *
 */
public class StringSplosion {
	
	private String text;
	
	public StringSplosion(String text){
		this.text = text;
	}
	
	public String manipulate(){
		StringBuffer word = new StringBuffer();
		for (int s = 0; s <= (this.text).length(); s++){
			String s1 = this.text.substring(0, s);
			word.append(s1);
		}
		return word.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringSplosion splosion = new StringSplosion("hello");
		System.out.print(splosion.manipulate());
	}

}
