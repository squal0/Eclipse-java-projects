/**
 * 
 */
package asymmetrickeys;

/**
 * @author Squalo
 *similar to the way of wrapping symmetric keys it is also possible to wrap and unwrap
 *asymmetric keys
 */
import java.security.*;
import javax.crypto.*;
public class RSAWrapping {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
Cipher cipher  = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
SecureRandom random = new SecureRandom();
KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA", "BC");
gen.initialize(2048, random);

KeyPair pair  = gen.genKeyPair();
Key wrapKey = Utility3.createAESKey(512, random);

//wrap the RSA private key
cipher.init(Cipher.WRAP_MODE, wrapKey);
byte[] wrappedkey = cipher.wrap(pair.getPrivate());

//unwrap the RSA private key
cipher.init(Cipher.UNWRAP_MODE, wrapKey);
Key key = cipher.unwrap(wrappedkey, "RSA", Cipher.PRIVATE_KEY);

if(pair.getPrivate().equals(key)){
	System.out.println("Key recovered.");
}
else{
	System.out.println("Key recovery failed");
}
	}

}
