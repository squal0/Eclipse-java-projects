/**
 * 
 */
package ciphers;

/**
 * @author Squalo
 *
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
// Symmetric encryption with padding and CBC using DES 
// with the initialization vector inline
public class InlineIVs {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		byte[] input= new byte[]{
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,
				0x0a,0x0b,0x0c,0x0d,0x0e,0x0f,
				0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07	
		};
		byte[] keyBytes  = new byte[]{
				0x01, 0x23,0x45,0x67,
				(byte)0x89,(byte)0xab, (byte)0xcd,(byte)0xef
		};
		byte[] ivBytes = new byte[] {
				0x07,0x06,0x05,0x04,0x03,0x02,0x01,0x00};
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding","BC");
		System.out.println("Input Text: "+ Utility.toHex(input));
		
		//encryption pass
		cipher.init(Cipher.ENCRYPT_MODE, key);
		IvParameterSpec ivSpec = new IvParameterSpec(cipher.getIV());
		byte[] cipherText = new byte[cipher.getOutputSize(ivBytes.length + input.length)];
		int ctLength = cipher.update(ivBytes, 0, ivBytes.length, cipherText, 0);
		ctLength += cipher.update(input, 0, input.length, cipherText, ctLength);
		ctLength += cipher.doFinal(cipherText, ctLength);
		
		System.out.println("Cipher: "+ Utility.toHex(cipherText,ctLength)+" Bytes: "+ctLength);
		
		// decryption pass
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		byte[] buf  = new byte[cipher.getOutputSize(ctLength)];
		int bufLength = cipher.update(cipherText, 0, ctLength, buf, 0);
		bufLength += cipher.doFinal(buf, bufLength);
		
		// remove the iv from the start of the message
		byte[] plainText = new byte[bufLength - ivBytes.length];
		System.arraycopy(buf, ivBytes.length,plainText, 0, plainText.length );
		System.out.println("Plain: " + Utility.toHex(plainText,plainText.length) + "Bytes: " + plainText.length);
	}

} 
