/**
 * 
 */
package asymmetrickeys;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
/**
 * @author Squalo
 *the folllowing program simulates basic RSA encryption
 *it also introduces the common classes used while trying to enrypt data using the 
 *RSA algorithm
 *
 */
public class RSAEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
byte[] input = new byte[] { 0x00,(byte)0xde, (byte)0xca,(byte) 0xde};
Cipher cipher  = Cipher.getInstance("RSA/None/NoPadding", "BC");

//create the new keys
KeyFactory fact = KeyFactory.getInstance("RSA", "BC");
RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(new BigInteger("d46f473a2d746537de2056ae3092c451", 16), new BigInteger("11",16));
RSAPrivateKeySpec prSpec = new RSAPrivateKeySpec(new BigInteger("d46f473a2d746537de2056ae3092c451",16), new BigInteger("57791d5430d593164082036ad8b29fb1", 16));

RSAPublicKey pubKey = (RSAPublicKey)fact.generatePublic(pubSpec);
RSAPrivateKey prKey = (RSAPrivateKey)fact.generatePrivate(prSpec);

System.out.println("Input:"+ Utility3.toHex(input));

//Encryption step
cipher.init(Cipher.ENCRYPT_MODE, pubKey);
byte[] cipherText = cipher.doFinal(input);

System.out.println("Cipher: "+ Utility3.toHex(cipherText));

//Decryption step
cipher.init(Cipher.DECRYPT_MODE, prKey);
byte[] plainText = cipher.doFinal(cipherText);

System.out.println("Plain Text: "+ Utility3.toHex(plainText));

	
	}
}
