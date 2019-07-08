/**
 * 
 */
package ip_Address;

/**
 * @author Squalo
 *finding the ip address
 */
import java.io.*;
import java.net.InetAddress;
import javax.swing.JOptionPane;
public class Ip {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
JOptionPane.showMessageDialog(null,InetAddress.getLocalHost());
	}

}
