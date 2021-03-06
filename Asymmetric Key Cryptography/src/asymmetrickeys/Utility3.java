package asymmetrickeys;

import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @author Squalo
 *
 */
public class Utility3 extends macs_hmacs.Utility2{

	   @SuppressWarnings("serial")
	private static class FixedRand extends SecureRandom
	     {
	         MessageDigest   sha;
	         byte[]           state;

	         FixedRand()
	         {
	             try
	             {
	                 this.sha = MessageDigest.getInstance("SHA-1", "BC");
	                 this.state = sha.digest();
	             }
	             catch (Exception e)
	             {
	                 throw new RuntimeException("can't find SHA-1!");
	             }
	         }

	         public void nextBytes(
	             byte[] bytes)
	         {
	             int off = 0;

	             sha.update(state);

	             while (off < bytes.length)
	             {
	                 state = sha.digest();

	                 if (bytes.length - off > state.length)
	                 {
	                     System.arraycopy(state, 0, bytes, off, state.length);
	                 }
	                 else
	                 {

	                     System.arraycopy(state, 0, bytes, off, bytes.length - off);
	                 }

	                 off += state.length;

	                 sha.update(state);
	             }
	         }
	     }

	     /**
	      * Return a SecureRandom which produces the same value.
	      * <b>This is for testing only!</b>
	      * @return a fixed random
	      */
	     public static SecureRandom createFixedRandom()
	     {
	         return new FixedRand();
	}

		/*public static String toHex(byte[] cipherText) {
			// TODO Auto-generated method stub
			return null;
		}*/

}
