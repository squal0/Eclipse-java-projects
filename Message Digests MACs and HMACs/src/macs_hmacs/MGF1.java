/**
 * 
 */
package macs_hmacs;

/**
 * @author Squalo
 *the following program implements a mask generating function that is found in PKCS #1 V2.1
 */
import java.security.MessageDigest;
public class MGF1 {

	/**
	 * @param args
	 */
	private MessageDigest digest;
	public MGF1(MessageDigest digest){
		/*
		 * create a version of MGF1 for the given digest
		 * 
		 * @param digest digest to use as the basis of the function
		 */
		this.digest = digest;
	}
	/*
	 * int to octet string 
	 */
	private void ItoOSP(int i, byte[]sp){
		sp[0]= (byte)(i>>>24);
		sp[1]= (byte)(i>>>16);
		sp[2]= (byte)(i>>>8);
		sp[3]= (byte)(i>>>0);
	}
	/*
	 * Generate the mask
	 * 
	 * @param seed source of the input bytes for the intital digest state
	 * @param lenght length of the mask  to generate
	 * 
	 * @return a byte array containing the MGF1 generated mask
	 */
	public byte[]generateMask(byte[]seed, int length){
		byte[] mask= new byte[length];
		byte[]C = new byte[4];
		int counter = 0;
		int hLen = digest.getDigestLength();
		while(counter< (length/hLen)){
			ItoOSP(counter,C);
			digest.update(seed);
			digest.update(C);
			
			System.arraycopy(digest.digest(), 0, mask, counter*hLen, hLen);
			counter++;
		}
		if((counter*hLen)< length){
			ItoOSP(counter,C);
			digest.update(seed);
			digest.update(C);
			
			System.arraycopy(digest.digest(), 0, mask, counter*hLen, mask.length-(counter*hLen));
		}
		return mask;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
MGF1 mg = new MGF1(MessageDigest.getInstance("SHA-512", "BC"));
byte[] source = new byte[]{
		1,2,3,4,5,6,7,8,9,10
};
System.out.println(Utility2.toHex(mg.generateMask(source, 20)));
	}
}
