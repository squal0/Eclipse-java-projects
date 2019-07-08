/**
 * 
 */
package asymmetrickeys;

/**
 * @author HP
 *the following uses the AlgorithmParameterGenerator class
 *together with the ElGamal Algorithm
 */
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.*;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
public class AlgorithmParameterElGamal {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		byte [] input = new byte[] {(byte)0xde, (byte)0xca, (byte)0xde};
		Cipher cipher = Cipher.getInstance("ElGamal/None/NoPadding", "BC");
		SecureRandom random = Utility3.createFixedRandom();
		
		//create the parameters
		AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("ElGamal","BC");
		apg.init(new DHGenParameterSpec(256, 30), random);
		AlgorithmParameters params = apg.generateParameters();
		AlgorithmParameterSpec dhSpec = params.getParameterSpec(DHParameterSpec.class);
		
		//create keys
		KeyPairGenerator gen = KeyPairGenerator.getInstance("ElGamal", "BC");
		gen.initialize(dhSpec, random);
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
