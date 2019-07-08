/**
 * 
 */
package ciphers;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * @author Squalo
 *the following example uses a regular cipher to encrypt the input data and then uses a PBE cipher to
 *decrypt it. In this case the password is used to create a javax.crypto.spec.PBEKeySpec which is then
 *converted to key material by a javax.crypto.spec.SecretKeyFactory. The salt and the iteration count are
 *then passed to in with the processed key using a javax.crypto.spec.PBEParameterSpec
 */
public class PasswordBasedEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
byte [] input  = new byte[]{
		0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09, 0x0a
		,0x0b,0x0c,0x0d,0x0e,0x0f,
		0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07
};
byte[] keyBytes = new byte[]{
		0x73,0x2f,0x2d, 0x33, (byte)0xc8, 0x01,0x73,
		0x2b,0x72,0x06,0x75,0x6c,(byte)0xbd,0x44,(byte)0xf9,(byte)0xc1,
		(byte)0xc1,0x03, (byte)0xdd,(byte)0xd9,0x7c,0x7c,(byte)0xbe,
		(byte)0x8e
};
byte[] ivBytes = new byte[]{
		(byte)0xb0, 0x7b,(byte)0xf5,0x22,
		(byte)0xc8,(byte)0xd6, 0x08, (byte)0xb8
};
// encrypt the data using pre calculated keys
Cipher cEncrypt  = Cipher.getInstance("DESede/CBC/PKCS7Padding","BC");
cEncrypt.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes,"DESede"), new IvParameterSpec(ivBytes));
byte[] out  = cEncrypt.doFinal(input);

// decrypt the data using PBE
char[] password = "password".toCharArray();
byte[] salt = new byte[]{
		0x7d,0x60,0x43,0x5f,0x02,
		(byte)0xe9,(byte)0xe0,(byte)0xae
};
int iteratorCount  = 2048;
PBEKeySpec pbs = new PBEKeySpec(password,salt,iteratorCount);
SecretKeyFactory keyFact = SecretKeyFactory.getInstance("PBEWithSHAAnd3KeyTripleDES", "BC");
Cipher cDecrypt = Cipher.getInstance("PBEWithSHAAnd3KeyTripleDES", "BC");
Key sKey = keyFact.generateSecret(pbs);
cDecrypt.init(Cipher.DECRYPT_MODE, sKey);
System.out.println("Cipher: "+ Utility.toHex(out));
System.out.println("Generated Key: "+ Utility.toHex(sKey.getEncoded()));
System.out.println("Generated IV: "+ Utility.toHex(cDecrypt.getIV()));
System.out.println("Plain Text: "+ Utility.toHex(cDecrypt.doFinal(out)));
	} 

}
