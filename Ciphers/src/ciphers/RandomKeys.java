/**
 * 
 */
package ciphers;

/**
 * @author Squalo
 *the following program generates random bytes and then pass that to a secret keySpec
 *it also uses the key generator spec
 *showing how to create a secretKeySpec from an encoded key
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class RandomKeys {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
byte[] input = new byte[]{
		0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09, 0x0a
		,0x0b,0x0c,0x0d,0x0e,0x0f,
		0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07
}; 
byte[] ivBytes = new byte[]{
		0x00,0x00,0x00,0x01,0x04,0x05,0x06,0x07,
		0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x01
};
Cipher cipher  = Cipher.getInstance("AES/CTR/NoPadding","BC");
KeyGenerator generator = KeyGenerator.getInstance("AES","BC");
generator.init(256);

SecretKey encryptionKey = generator.generateKey();
System.out.println("Key: " + Utility.toHex(encryptionKey.getEncoded()));
System.out.println("Key: " + Utility.toHex(encryptionKey.getEncoded()));
System.out.println("Input: " + Utility.toHex(input));

// encryption pass
cipher.init(Cipher.ENCRYPT_MODE, encryptionKey, new IvParameterSpec(ivBytes));
byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
ctLength += cipher.doFinal(cipherText, ctLength);

// create the decryption key using the information extracted from the encryption key

SecretKey decryptionKey = new SecretKeySpec(encryptionKey.getEncoded(),encryptionKey.getAlgorithm() );
cipher.init(Cipher.DECRYPT_MODE, decryptionKey, new IvParameterSpec(ivBytes));
//decryption pass
byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
ptLength += cipher.doFinal(plainText, ptLength);
System.out.println("Plain Text: "+ Utility.toHex(plainText,ptLength)+ " Bytes: "+ ptLength);
	}

}
