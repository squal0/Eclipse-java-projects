/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 * basic class to implement the PKCS #5 scheme1 one class this is a scheme that provides a simple method of
 * generating keys of up to 160 bits and its algorithm is 
 * hash(password||salt)iterationCount 
 */
import java.security.MessageDigest;
public class PKCS5Scheme1 {
private MessageDigest digest;
public PKCS5Scheme1(MessageDigest digest){
	this.digest = digest;
}
public byte[] generateDerivedKey(char[]password, byte[]salt, int iterationCount){
	for(int i=0; i!=password.length; i++){
		digest.update((byte)password[i]);
	}
	digest.update(salt);
	byte[]digestBytes = digest.digest();
	for(int i=1; i< iterationCount; i++){
		digest.update(digestBytes);
		digestBytes = digest.digest();
	}
	return digestBytes;
}
}
