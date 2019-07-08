/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *
 */
import java.security.SecureRandom;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class MACsBasedOnCiphers {

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
		Mac mac  = Mac.getInstance("DES","BC");
		byte [] mackeyBytes = new byte[]{
				0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08
		};
		Key MacKey = new SecretKeySpec(mackeyBytes,"DES");
		
System.out.println("Input: "+ input);
		
		//encryption step
		cipher.init(Cipher.ENCRYPT_MODE, key,ivSpec);
		
		byte[] cipherText  = new byte[cipher.getOutputSize(input.length() + mac.getMacLength())];
		int ctLength = cipher.update(Utility2.toByteArray(input),0, input.length(),cipherText, 0 );
		
		Key EMacKey = new SecretKeySpec(mackeyBytes, "DES");
		mac.init(EMacKey);
		mac.update(Utility2.toByteArray(input));
		ctLength += cipher.doFinal(mac.doFinal(), 0, mac.getMacLength(), cipherText, ctLength);
		
		
		
		//decryption step
				cipher.init(Cipher.DECRYPT_MODE, key,ivSpec);
				byte[] plainText = cipher.doFinal(cipherText,0 ,ctLength);
				int messageLength = plainText.length - mac.getMacLength();
				mac.init(MacKey);
				mac.update(plainText, 0, messageLength);
				
				byte[] messageHash  = new byte[mac.getMacLength()];
				System.arraycopy(plainText, messageLength, messageHash, 0, messageHash.length);
				System.out.println("Plain: " + Utility2.toString(plainText, messageLength)+ " Verified: "+ java.util.Arrays.equals(mac.doFinal(), messageHash));

	}
}
