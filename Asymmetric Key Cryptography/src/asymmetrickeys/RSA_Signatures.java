/**
 * 
 */
package asymmetrickeys;

/**
 * @author HP
 *The following program simulates the use of RSA based signature algorithms.This is whereby signatures are created
 *using the RSA algorithm  by applying the RSA Algorithm using the private key and then distributing the result as the 
 *signature
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import javax.swing.JOptionPane;
public class RSA_Signatures {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
		keyGen.initialize(512, new SecureRandom());
		KeyPair key = keyGen.genKeyPair();
		Signature sign = Signature.getInstance("SHA1withRSAandMGF1", "BC");

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