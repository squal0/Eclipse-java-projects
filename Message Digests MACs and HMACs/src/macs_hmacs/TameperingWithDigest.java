/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 * the program uses a message digest to verify if the message has been tampered with
 * also uses the encryption AES in CTR mode 
 */
import java.security.SecureRandom;
import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
public class TameperingWithDigest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		SecureRandom random = new SecureRandom();
		IvParameterSpec ivSpec  = Utility2.CTRIvAES(1, random);
		Key key = Utility2.createAESKey(256, random);
		Cipher cipher  = Cipher.getInstance("AES/CTR/NoPadding", "BC");
		String input  = "Transfer 00010040 to AC 1234-5678";
		MessageDigest hash  = MessageDigest.getInstance("SHA-512WithDSA", "BC");
		
		System.out.println("Input: "+ input);
		
		//encryption step
		cipher.init(Cipher.ENCRYPT_MODE, key,ivSpec);
		byte[] cipherText  = new byte[cipher.getOutputSize(input.length() + hash.getDigestLength())];
		int ctLength = cipher.update(Utility2.toByteArray(input),0, input.length(),cipherText, 0 );
		hash.update(Utility2.toByteArray(input));
		ctLength += cipher.doFinal(hash.digest(),0 , hash.getDigestLength(), cipherText, ctLength);
		
		// Tampering text
				cipherText [9] ^= '4' ^ '5';

		//decryption step
		cipher.init(Cipher.DECRYPT_MODE, key,ivSpec);
		byte[] plainText = cipher.doFinal(cipherText,0 ,ctLength);
		int messageLength = plainText.length - hash.getDigestLength();
		
		hash.update(plainText,0, messageLength);
		byte[] messageHash = new byte[hash.getDigestLength()];
		System.arraycopy(plainText, messageLength, messageHash, 0, messageHash.length);
		System.out.println("Plain: " + Utility2.toString(plainText, messageLength)+ " Verified: "+ MessageDigest.isEqual(hash.digest(), messageHash));
	}

}
