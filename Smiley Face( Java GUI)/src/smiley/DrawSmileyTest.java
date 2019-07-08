/**
 * Test application that displays the smiley face
 */
package smiley;

/**
 * @author Home
 *
 */
import javax.swing.JFrame;
public class DrawSmileyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DrawSmiley panel = new DrawSmiley();
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(250, 280);
		app.setVisible(true);

	}

}
