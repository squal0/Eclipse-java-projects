/**
 * 
 */
package ciphers;

/**
 * @author Squalo
 *basic symmetric encryption that uses DES with the CTR mode 
 *CTR is a streaming symmetric block cipher mode where a stream of bits is produced then
 *XORed with the input data to produce the encrypted data
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
public class CTRMode {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		byte[] input= new byte[]{
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,
				0x0a,0x0b,0x0c,0x0d,0x0e,0x0f,
				0x00,0x01,0x02,0x03,0x04,0x05,0x06
		};
		byte[] keyBytes  = new byte[]{
				0x01, 0x23,0x45,0x67,
				(byte)0x89,(byte)0xab, (byte)0xcd,(byte)0xef
		};
		byte[] ivBytes = new byte[]{
				0x00,0x01,0x02,0x03,0x00,0x00,0x00,0x01
		};
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		Cipher cipher = Cipher.getInstance("DES/CFB/NoPadding","BC");
		
		System.out.println("Input Text: "+ Utility.toHex(input));
		// encryption pass
		cipher.init(Cipher.ENCRYPT_MODE, key,ivSpec);
		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		ctLength += cipher.doFinal(cipherText, ctLength);
		System.out.println("Cipher text: "+ Utility.toHex(cipherText,ctLength)+ "Bytes: "+ ctLength);

		// decryption pass
		byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
		ptLength += cipher.doFinal(plainText, ptLength);
		System.out.println("Plain Text: "+ Utility.toHex(plainText,ptLength)+ "Bytes: "+ ptLength);
			}

		}

