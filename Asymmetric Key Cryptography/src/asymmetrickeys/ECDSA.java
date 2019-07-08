/**
 * 
 */
package asymmetrickeys;

/**
 * @author HP
 *The following program simulates the use of an elliptic curve in the DSA algoithm in the creation of
 *digital signatures
 *The algorithm for this program is the ECDSA algorithm
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import javax.swing.JOptionPane;
import java.security.spec.ECGenParameterSpec;
public class ECDSA {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
ECGenParameterSpec ecspec = new ECGenParameterSpec("prime239v1");
keyGen.initialize(ecspec, new SecureRandom());
KeyPair key = keyGen.genKeyPair();
Signature sign = Signature.getInstance("ECDSA", "BC");

//generate sign
sign.initSign(key.getPrivate(), Utility3.createFixedRandom());
byte[] message = new byte[]{ (byte)'d', (byte)'e', (byte)'c', (byte)'a', (byte)'d', (byte)'e'};
sign.update(message);
byte[] sigBytes= sign.sign();

//verify the sign 
sign.initVerify(key.getPublic());
sign.update(message);
if(sign.verify(sigBytes)){
	JOptionPane.showMessageDialog(null, "Signature verification succeeded");
}
else{
	JOptionPane.showMessageDialog(null, "Signature verification failed");
}
	}

}
