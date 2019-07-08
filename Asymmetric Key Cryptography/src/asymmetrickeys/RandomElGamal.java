/**
 * 
 */
package asymmetrickeys;

/**
 * @author HP
 *example using the the ElGamal algorithm using random keys
 *the algorithm is a variant of the Diffie-Hellman algorithm and uses the same security measures
 *mostly used in OpenPGP
 */
import java.security.*;
import javax.crypto.*;
public class RandomElGamal {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
byte [] input = new byte[] {(byte)0xde, (byte)0xca, (byte)0xde};
Cipher cipher = Cipher.getInstance("ElGamal/None/NoPadding", "BC");
KeyPairGenerator gen = KeyPairGenerator.getInstance("ElGamal", "BC");
SecureRandom random = Utility3.createFixedRandom();

//create the Keys
gen.initialize(512, random);
KeyPair pair = gen.genKeyPair();
Key pubKey = pair.getPublic();
Key privKey = pair.getPrivate();
System.out.println("Input: "+ Utility3.toHex(input));

//Encryption step
cipher.init(Cipher.ENCRYPT_MODE, pubKey, random);
byte[] cipherText = cipher.doFinal(input);
System.out.println("CipherText: "+ Utility3.toHex(cipherText));

//Decryption step
cipher.init(Cipher.DECRYPT_MODE, privKey);
byte[] plainText = cipher.doFinal(cipherText);
System.out.println("PlainText: "+ Utility3.toHex(plainText));
	} 

}
