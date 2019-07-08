/**
 * 
 */
package asymmetrickeys;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.SecureRandom;

import javax.crypto.Cipher;
/**
 * @author Squalo
 *the following program introduces the keypair generator class that is used to enable 
 *the generating of random RSA keys
 */
public class RandomRSAKeys {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		byte[] input = new byte[] { 0x00,(byte)0xde, (byte)0xca,(byte) 0xde};
		Cipher cipher  = Cipher.getInstance("RSA/None/OAEPWithSHA512AndMGF1Padding", "BC");
		
		//generating the random RSA keys
		SecureRandom random = Utility3.createFixedRandom();
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA", "BC");
		gen.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4), random);
		KeyPair pair = gen.genKeyPair();
		Key pubKey = pair.getPublic();
		Key prKey = pair.getPrivate();
		
		System.out.println("Input:"+ Utility3.toHex(input));

		//Encryption step
		cipher.init(Cipher.ENCRYPT_MODE, pubKey,random);
		byte[] cipherText = cipher.doFinal(input);

		System.out.println("Cipher: "+ Utility3.toHex(cipherText));

		//Decryption step
		cipher.init(Cipher.DECRYPT_MODE, prKey);
		byte[] plainText = cipher.doFinal(cipherText);

		System.out.println("Plain Text: "+ Utility3.toHex(plainText));

			
			}
		}