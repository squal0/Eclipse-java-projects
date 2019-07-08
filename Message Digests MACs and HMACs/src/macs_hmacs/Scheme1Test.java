/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *this program test the PKCS5 scheme1 
 */
import java.security.MessageDigest;

import javax.crypto.*;
import javax.crypto.spec.*;
public class Scheme1Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
char[] password = "Hello".toCharArray();
byte[] salt  = new byte[]{1,2,3,4,5,6,7,8,9,0};
byte[]input = new byte[]{0x0a,0x0b,0x0c,0x0d,0x0e,0x0e,0x0f};
int iterationCount = 1000;

System.out.println("Input: "+ Utility2.toHex(input));

//encryption step using a regular PBE
Cipher cipher = Cipher.getInstance("PBEWithSHA1AndDES", "BC");
SecretKeyFactory fact = SecretKeyFactory.getInstance("PBEWithSHA1AndDES", "BC");
PBEKeySpec spec = new PBEKeySpec(password,salt, iterationCount);

cipher.init(Cipher.ENCRYPT_MODE,fact.generateSecret(spec));
byte[] enc = cipher.doFinal(input);

System.out.println("Encrypt: "+ Utility2.toHex(enc));

//decryption step using local implementation
cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
PKCS5Scheme1 scheme1 = new PKCS5Scheme1(MessageDigest.getInstance("SHA-1", "BC"));
byte[] derivedKey = scheme1.generateDerivedKey(password, salt, iterationCount);

cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(derivedKey,0,8,"AES"),new IvParameterSpec(derivedKey ,8,8));
byte[]dec = cipher.doFinal(enc);
System.out.println("Decrypt: "+ Utility2.toHex(dec));
	}

}
