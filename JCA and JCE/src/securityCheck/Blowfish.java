/**
 * 
 */
package securityCheck;

/**
 * @author Squalo
 *checks to see if the blowfish provider is installed
 */
import java.security.Security;
public class Blowfish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String providerName = "Blowfish";
if (Security.getProvider(providerName) == null){
	System.out.println(providerName + " exists in the installation");
}
else{
	System.out.println(providerName + " does not exist in the installation");
}
	}

}
