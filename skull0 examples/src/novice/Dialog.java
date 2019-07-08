/**
 * program introduces the use of Java GUI
 * the following program displays a message in a dialog box
 */
package novice;

/**
 * @author Home
 *
 */
import javax.swing.JOptionPane; //imports the JOptionPane class
public class Dialog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//prompt user to enter a name
		String name = JOptionPane.showInputDialog("Enter your name");
		
		//create the message
		String message = String.format("Hi %s, welcome to Oracion Seis", name);
		//display a message in a dialog box to welcome the user
		JOptionPane.showMessageDialog(null, message);
		
	}

}
