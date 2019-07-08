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
public class SymmetricEncryption {

	/**
	 * @param args
	 * this is a basic Symmetric encryption example
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
byte[] input = new byte[]{
		0x00, 0x11,0x22,0x33,0x44,0x55,0x66,0x77, (byte)0x88,(byte)0x99,
		(byte)0xaa,(byte)0xbb,(byte)0xcc,(byte)0xdd,(byte)0xee,(byte)0xff,
};
byte[] keyBytes = new byte[]{
		0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09, 0x0a
		,0x0b,0x0c,0x0d,0x0e,0x0f,0x10,0x11,0x12,0x13,0x14,0x15,0x16,0x17	
};
SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
System.out.println("Input Text: "+ Utility.toHex(input));
// encryption pass
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
ctLength += cipher.doFinal(cipherText, ctLength);
System.out.println("Cipher text: "+ Utility.toHex(cipherText,ctLength)+ "Bytes: "+ ctLength);

// decryption pass
byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
cipher.init(Cipher.DECRYPT_MODE, key);
int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
ptLength += cipher.doFinal(plainText, ptLength);
System.out.println("Plain Text: "+ Utility.toHex(plainText,ptLength)+ "Bytes: "+ ptLength);
	}

}