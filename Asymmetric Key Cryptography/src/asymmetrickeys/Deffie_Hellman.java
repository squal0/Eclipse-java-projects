/**
 * 
 */
package asymmetrickeys;

/**
 * @author Squalo
 *the following program simulates key agreement using the Deffie-Hellman algorithm
 *the algorithm uses modulus arithmetic and relies on the solving of the discrete logarithm
 *of the deffie hellman problem
 */
import java.math.BigInteger;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;
public class Deffie_Hellman {

	/**
	 * @param args
	 */
	private static BigInteger g1024 = new BigInteger("153d5d6172adb43045b68ae8e1de1070b6137005686d29d3d73a7"
	          + "749199681ee5b212c9b96bfdcfa5b20cd5e3fd2044895d609cf9b"
	          + "410b7a0f12ca1cb9a428cc", 16);
	private static BigInteger p1024 = new BigInteger("9494fec095f3b85ee286542b3836fc81a5dd0a0349b4c239dd387"
	          + "44d488cf8e31db8bcb7d33b41abb9e5a33cca9144b1cef332c94b"
	          + "f0573bf047a3aca98cdf3b", 16);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
DHParameterSpec dh = new DHParameterSpec(g1024, p1024,512);
KeyPairGenerator keygen  = KeyPairGenerator.getInstance("DH","BC");
keygen.initialize(dh, Utility3.createFixedRandom());

// setup
KeyAgreement akey = KeyAgreement.getInstance("DH", "BC");
KeyPair apair = keygen.generateKeyPair();
KeyAgreement bkey = KeyAgreement.getInstance("DH", "BC");
KeyPair bpair = keygen.generateKeyPair();
KeyAgreement ckey = KeyAgreement.getInstance("DH", "BC");
KeyPair cpair  = keygen.generateKeyPair();

// two party agreement
akey.init(apair.getPrivate());
bkey.init(bpair.getPrivate());
ckey.init(cpair.getPrivate());

Key ac= akey.doPhase(cpair.getPublic(), false);
Key ba= bkey.doPhase(apair.getPublic(), false);
Key cb= ckey.doPhase(bpair.getPublic(), false);

//keys
akey.doPhase(cb, true);
bkey.doPhase(ac, true);
ckey.doPhase(ba, true);

// generate the key bytes
MessageDigest hash = MessageDigest.getInstance("SHA-512", "BC");
byte [] aShared = hash.digest(akey.generateSecret());
byte [] bShared = hash.digest(bkey.generateSecret());
byte [] cShared = hash.digest(ckey.generateSecret());

System.out.println(Utility3.toHex(aShared));
System.out.println(Utility3.toHex(bShared));
System.out.println(Utility3.toHex(cShared));
	}

}
