/**
 * 
 */
package securityCheck;

/**
 * @author Squalo
 * checks to see if bouncy castle has been installed correctly
 */
import java.security.Security;
public class BouncyCastle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String providerName = "BC";
if(Security.getProvider(providerName) == null){
	System.out.println(providerName + " has not been installed");
}
else {
	System.out.println(providerName+ " has been installed");
}
	}

}
