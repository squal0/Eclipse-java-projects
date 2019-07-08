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
/*
 * using DES with an IV based on a nonce in this case a hypothetical message number
 */
public class PseudoRandomIVs {

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
		byte[] msgNumber = new byte[] {
				0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
		IvParameterSpec zeroIV = new IvParameterSpec(new byte[8]);
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding","BC");
		System.out.println("Input Text: "+ Utility.toHex(input));
		
		// encryption pass
		// generate IV
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIV);
		IvParameterSpec encryptionIV = new IvParameterSpec(cipher.doFinal(msgNumber),0,8);
		
		//encrypt message
		cipher.init(Cipher.ENCRYPT_MODE, key, encryptionIV);
		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		int ctLength = cipher.update(input, 0, input.length, cipherText,0);
		ctLength += cipher.doFinal(cipherText, ctLength);
		System.out.println("Cipher: "+ Utility.toHex(cipherText,ctLength)+" Bytes: "+ctLength);
		
		//decryption pass
		//generate IV
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIV);
		IvParameterSpec decryptionIV = new IvParameterSpec(cipher.doFinal(msgNumber),0,8);
		
		// decrypt message
		cipher.init(Cipher.DECRYPT_MODE, key, decryptionIV);
		byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
		int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
		ptLength += cipher.doFinal(plainText, ptLength);
		System.out.println("Plain Text: "+ Utility.toHex(plainText,ptLength)+ "Bytes: "+ ptLength);
	}

}
