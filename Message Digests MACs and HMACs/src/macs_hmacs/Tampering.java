/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *the following program shows a tampering example where the cipher  is tammpered with to 
 *produce a different output
 */
import java.security.SecureRandom;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
public class Tampering {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
SecureRandom random = new SecureRandom();
IvParameterSpec ivSpec  = Utility2.CTRIvAES(1, random);
Key key = Utility2.createAESKey(256, random);
Cipher cipher  = Cipher.getInstance("AES/CTR/NoPadding", "BC");
String input  = "Transfer 00010040 to AC 1234-5678";
System.out.println("Input: "+ input);

//encryption step
cipher.init(Cipher.ENCRYPT_MODE, key,ivSpec);
byte[] cipherText = cipher.doFinal(Utility2.toByteArray(input));

// Tampering text
cipherText [9] ^= '4' ^ '5';

//decryption step
cipher.init(Cipher.DECRYPT_MODE, key,ivSpec);
byte[] plainText = cipher.doFinal(cipherText);
System.out.println("Plain Text: " + Utility2.toString(plainText));
	}

}
