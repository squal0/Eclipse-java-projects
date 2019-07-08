/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *this program introduces the MAC class where the mac.getInstance() is used to generate a hMac(hash Mac) a message
 *authentication code based on a cryptographic hash
 */
import java.security.SecureRandom;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class HMACs {

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
		Mac hMac  = Mac.getInstance("HmacSHA512","BC");
		Key hMacKey = new SecretKeySpec(key.getEncoded(), "HmacSHA512");
		
System.out.println("Input: "+ input);
		
		//encryption step
		cipher.init(Cipher.ENCRYPT_MODE, key,ivSpec);
		
		byte[] cipherText  = new byte[cipher.getOutputSize(input.length() + hMac.getMacLength())];
		int ctLength = cipher.update(Utility2.toByteArray(input),0, input.length(),cipherText, 0 );
		
		Key hEMacKey = new SecretKeySpec(key.getEncoded(), "HmacSHA256");
		hMac.init(hEMacKey);
		hMac.update(Utility2.toByteArray(input));
		ctLength += cipher.doFinal(hMac.doFinal(), 0, hMac.getMacLength(), cipherText, ctLength);
		
		// Tampering text
		cipherText [9] ^= '4' ^ '5';
		
		//decryption step
				cipher.init(Cipher.DECRYPT_MODE, key,ivSpec);
				byte[] plainText = cipher.doFinal(cipherText,0 ,ctLength);
				int messageLength = plainText.length - hMac.getMacLength();
				hMac.init(hMacKey);
				hMac.update(plainText, 0, messageLength);
				
				byte[] messageHash  = new byte[hMac.getMacLength()];
				System.arraycopy(plainText, messageLength, messageHash, 0, messageHash.length);
				System.out.println("Plain: " + Utility2.toString(plainText, messageLength)+ " Verified: "+ java.util.Arrays.equals(hMac.doFinal(), messageHash));

	}

}
