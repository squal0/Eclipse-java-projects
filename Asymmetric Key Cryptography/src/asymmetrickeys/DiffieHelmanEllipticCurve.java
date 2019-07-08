/**
 * 
 */
package asymmetrickeys;

/**
 * @author HP
 *the following program uses elliptic curve cryptography together with the diffie hellman algorithm
 *This curve derives its security from the difficulty of the eliptic curve discrete algorithm problem
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.spec.ECGenParameterSpec;

import javax.crypto.KeyAgreement;
public class DiffieHelmanEllipticCurve {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
KeyPairGenerator keygen = KeyPairGenerator.getInstance("ECDH", "BC");
ECGenParameterSpec espec = new ECGenParameterSpec("prime192v1");
keygen.initialize(espec, Utility3.createFixedRandom());

//set up
KeyAgreement akey = KeyAgreement.getInstance("ECDH", "BC");
KeyPair apair = keygen.generateKeyPair();
KeyAgreement bkey = KeyAgreement.getInstance("ECDH", "BC");
KeyPair bpair = keygen.generateKeyPair();

//two party agreement
akey.init(apair.getPrivate());
bkey.init(bpair.getPrivate());

akey.doPhase(bpair.getPublic(), true);
bkey.doPhase(apair.getPublic(), true);

// generate the key bytes
MessageDigest hash = MessageDigest.getInstance("SHA-512", "BC");
byte [] aShared = hash.digest(akey.generateSecret());
byte [] bShared = hash.digest(bkey.generateSecret());

System.out.println(Utility3.toHex(aShared));
System.out.println(Utility3.toHex(bShared));
	}

}
