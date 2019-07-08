/**
 * 
 */
package asymmetrickeys;

/**
 * @author Squalo
 * The following program demonstrates secret key exchange 
 * it somewhat solves the problem of the RSA being incapble of encrypting large 
 * blocks of data
 * 
 */
import java.security.*;
import java.security.spec.RSAKeyGenParameterSpec;
import java.io.*;

import javax.crypto.*;
import javax.crypto.spec.*;
public class SecretKeyExchange {

	/**
	 * @param args
	 */
	private static byte[] pacKeyandIv( Key key, IvParameterSpec ivSpec)throws Exception{
	ByteArrayOutputStream bout  = new ByteArrayOutputStream();
	bout.write(ivSpec.getIV());
	bout.write(key.getEncoded());
	
	return bout.toByteArray();
	}
	public static Object[] unpackKeyandIv (byte [] data){
		@SuppressWarnings("unused")
		byte[] keyD = new byte[16];
		@SuppressWarnings("unused")
		byte[] iv = new byte[data.length-16];
		return new Object[] {
				new SecretKeySpec(data,16,data.length-16, "AES"), new IvParameterSpec(data,0,16)
		};
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		byte[] input = new byte[] { (byte)0xde, (byte)0xca,(byte) 0xde};
		//generating the random RSA keys
				SecureRandom random = Utility3.createFixedRandom();
				KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA", "BC");
				gen.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4), random);
				KeyPair pair = gen.genKeyPair();
				Key pubKey = pair.getPublic();
				Key prKey = pair.getPrivate();
				
				System.out.println("Input:"+ Utility3.toHex(input));
				
				// create the symmetric key and the iv
				Key sKey = Utility3.createAESKey(512, random);
				IvParameterSpec sIvSpec = Utility3.CTRIvAES(0, random);
				
				// symmetric key and iv wrapping step
				Cipher xCipher  = Cipher.getInstance("RSA/None/OAEPWithSHA512AndMGF1Padding", "BC");
				xCipher.init(Cipher.ENCRYPT_MODE, pubKey,random);
				byte[] keyBlock = xCipher.doFinal(pacKeyandIv(sKey, sIvSpec));
				
				Cipher sCipher = Cipher.getInstance("AES/CTR/NoPadding", "BC");
				sCipher.init(Cipher.ENCRYPT_MODE, sKey, sIvSpec);
				byte[] cipherText = sCipher.doFinal(input);
				
				System.out.println("Key Block Length: "+ keyBlock.length);
				System.out.println("Cipher: "+ Utility3.toHex(cipherText));
				System.out.println("Cipher Text Length: " + cipherText.length );
				
				//Symmetric key and iv unwrapping step
				xCipher.init(Cipher.DECRYPT_MODE, prKey);
				Object[] keyIv = unpackKeyandIv(xCipher.doFinal(keyBlock));
				
				sCipher.init(Cipher.DECRYPT_MODE, (Key) keyIv[0], (IvParameterSpec)keyIv[1]);
				byte[] plainText = sCipher.doFinal(cipherText);
				System.out.println("Plain Text: "+ Utility3.toHex(plainText));
						
				
				

	}

}
