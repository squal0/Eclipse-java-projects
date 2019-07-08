/**
 * 
 */
package securityCheck;

/**
 * @author Squalo
 *program shows a basic demonstration of precedence in action
 */
import javax.crypto.Cipher;
public class PrecedenceCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding");
System.out.println(cipher.getProvider());
cipher = Cipher.getInstance("Blowfish/ECB/NoPadding", "BC");
System.out.println(cipher.getProvider());
	}

}
