/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *
 */
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * 
 * @author Squalo
 *general utility class for the chapter on Message Digests MACs and HMACs
 */
public class Utility2 extends ciphers.Utility{
/**
 * create a key for use with AES
 * 
 * @param bitLength
 * @param random
 * @return a secretKey of requested bit length
 * @throws NoSuchAlgorithmException
 * @throws NoSuchProviderException
 */
	public static SecretKey createAESKey(int bitLength, SecureRandom random)throws NoSuchAlgorithmException,NoSuchProviderException{
	KeyGenerator gen = KeyGenerator.getInstance("AES", "BC");
	gen.init(256, random);
	return gen.generateKey();
	}
	/**
	 * create an IV suitable for using with AES in CTR mode
	 * <p>
	 * The IV will be composed of 4 bytes of message number,
	 * 4 bytes of random data and a counter of 8 bytes.
	 * 
	 * @param messageNumber the number of the message 
	 * @param random a source of randomness
	 * @return an initialised IvParameterSpec
	 */
	public static IvParameterSpec CTRIvAES(int messageNumber, SecureRandom random){
		byte[] ivBytes = new byte[16];
		//initialize randomize
		random.nextBytes(ivBytes);
		//set the message number bytes
		ivBytes[0] = (byte)(messageNumber >>24);
		ivBytes[1] = (byte)(messageNumber >>16);
		ivBytes[2] = (byte)(messageNumber >>8);
		ivBytes[3] = (byte)(messageNumber >>0);
		
		// set the counter bytes to 1
		for(int i =0; i!=7; i++){
			ivBytes[8 + i]= 0 ;
		}
		ivBytes[15] = 1;
		return new IvParameterSpec(ivBytes);
	}
	/**
	 * convert byte array of a 8 bit characters into a string 
	 * 
	 *  @param bytes the array containing the characters
	 *  @param length the number of bytes to process
	 *  @return a string represantation of bytes
	 */
	public static String toString (byte[] bytes, int length){
		char [] chars = new char[length];
		for (int i= 0; i != chars.length; i++){
			chars[i]= (char)(bytes[i]& 0xff);
		}
		return new String(chars);
	}
	/**
	 * convert a byte array of 8 bit characters into a string 
	 * 
	 * @param bytes the array containing the characters
	 * @param length the number of bytes to process
	 * @return a string represantation of bytes
	 */
	public static String toString(byte[] bytes){
		return toString(bytes, bytes.length);
	}
	/**
     * Convert the passed in String to a byte array by
     * taking the bottom 8 bits of each character it contains.
     *
     * @param string the string to be converted
     * @return a byte array representation
     */
	public static byte[] toByteArray(String string){
		byte[] bytes  = new byte[string.length()];
		char[] chars = string.toCharArray();
		for(int i =0; i!=chars.length; i++){
			bytes[i] = (byte)chars[i];
		}
		return bytes;
	}
}
