/**
 * 
 */
package ciphers;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 * @author Squalo
 *the following program indicates basic key wrapping using the wrapping modes found
 *in the cipher class
 */
public class KeyWrapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
// create the key to be wrapped
		KeyGenerator gen = KeyGenerator.getInstance("AES", "BC");
		gen.init(128);
		Key ktw = gen.generateKey();
		System.out.println("Input: "+ Utility.toHex(ktw.getEncoded()));
		
		// create a wrapper and do the wrapping
		Cipher cipher  = Cipher.getInstance("AES/ECB/NoPadding", "BC");
		KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");
		keyGen.init(256);
		
		Key wrapKey = keyGen.generateKey();
		cipher.init(Cipher.ENCRYPT_MODE, wrapKey);
		byte[] wrappedKey = cipher.doFinal(ktw.getEncoded());
		System.out.println("Wrapped: "+ Utility.toHex(wrappedKey));
		
		// unwrap the wrapped key
		cipher.init(Cipher.DECRYPT_MODE, wrapKey);
		Key key = new SecretKeySpec(cipher.doFinal(wrappedKey),"AES");
		System.out.println("Unwrapped: "+ Utility.toHex(key.getEncoded()));
	}

}
