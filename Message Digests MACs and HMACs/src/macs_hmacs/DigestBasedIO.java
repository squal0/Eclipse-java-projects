/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *program implements basic I/O using message digests
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
public class DigestBasedIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		byte [] input  = new byte[]{
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09, 0x0a
				,0x0b,0x0c,0x0d,0x0e,0x0f,
				0x00, 0x01 ,0x02,0x03,0x04,0x05,0x06
		};
		MessageDigest hash  = MessageDigest.getInstance("SHA512");
		System.out.println("Input: "+ Utility2.toHex(input));
		
		//input pass
		ByteArrayInputStream bin = new ByteArrayInputStream(input);
		DigestInputStream din  = new DigestInputStream(bin , hash);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		int ch;
		while ((ch = din.read())>= 0){
			bout.write(ch);
		}
		byte[] newInput= bout.toByteArray();
		
		System.out.println("In digest: "+ Utility2.toHex(din.getMessageDigest().digest()));
		
		//output pass
		bout = new ByteArrayOutputStream();
		DigestOutputStream dout  = new DigestOutputStream(bout,hash);
		dout.write(newInput);
		System.out.println("Out digest: "+ Utility2.toHex(din.getMessageDigest().digest()));
	}

}
