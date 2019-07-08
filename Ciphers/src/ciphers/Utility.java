/**
 * 
 */
package ciphers;

/**
 * @author Squalo
 *generating utilities 
 */
public class Utility {
private static String digits = "0123456789abcdef";
/**
 * return length many bytes of the passed in the byte array as a hex string
 * @param data the bytes to be converted
 * @param length the number of bytes in the data block to be converted
 * @return a hex rep of the length bytes of data
 */
public static String toHex(byte[]data, int length){
	StringBuffer buffer = new StringBuffer();
	for(int i=0; i!= length ; i++){
		int v = data[i]& 0xff;
		buffer.append(digits.charAt(v >> 4));
		buffer.append(digits.charAt(v& 0xf));
	}
	return buffer.toString();
}
/**
 * return the passed byte array as a hex string
 * @param data the bytes to be connverted
 * @param a hex rep of data
 */
public static String toHex(byte[]data){
	return toHex(data, data.length);
}
}
