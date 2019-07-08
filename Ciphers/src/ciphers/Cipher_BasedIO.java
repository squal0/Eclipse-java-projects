/**
 * 
 */
package ciphers;

/**
 * @author Squalo
 *cipher based is used where the normal factory pattern used in JCE is not seen
 *it uses the inputStream and outputStream classes found in the javax.crypto to wrapping while
 *a cipher does the processing
 *basic example with CTR using AES
 */
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Cipher_BasedIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		byte [] input  = new byte[]{
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09, 0x0a
				,0x0b,0x0c,0x0d,0x0e,0x0f,
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07
		};
		byte [] keyBytes = new byte[]{
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09, 0x0a
				,0x0b,0x0c,0x0d,0x0e,0x0f,
				0x10, 0x00,0x00,0x00,0x00,0x00,0x00,0x01
		};
		byte[] ivBytes = new byte[]{
		0x00,0x01,0x02,0x03,0x00,0x01,0x02,0x03,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x01		
		};
		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		Cipher cipher  = Cipher.getInstance("AES/CTR/NoPadding", "BC");
		System.out.println("Input: "+ Utility.toHex(input));
		
		//encryption pass
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		ByteArrayInputStream bin = new ByteArrayInputStream(input);
		CipherInputStream cin = new CipherInputStream(bin, cipher);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		int ch;
		while ((ch = cin.read())>= 0){
			bout.write(ch);
		}
		byte[] cipherText= bout.toByteArray();
		cin.close();
		System.out.println("Cipher: "+ Utility.toHex(cipherText));
		
		//decryption pass
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		bout = new ByteArrayOutputStream();
		CipherOutputStream cout = new CipherOutputStream(bout,cipher);
		cout.write(cipherText);
		cout.close();
		System.out.println("Plain Text: "+ Utility.toHex(bout.toByteArray()));
	}

}
