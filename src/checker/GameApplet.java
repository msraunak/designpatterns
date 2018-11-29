/*<APPLET WIDTH=400 HEIGHT=400 CODE="GameApplet.class"></APPLET> */
package checker;
/**
 * An applet representation of the checker board game
 */
		
import javax.swing.*;
import java.awt.*;

public class GameApplet extends JApplet
{
	public void init()
	{
		getContentPane().setLayout(new BorderLayout());

		CheckerBoardModel model = new CheckerBoardModel();
		GameBoardView view = new CheckerBoardView(model);

		getContentPane().add(view, BorderLayout.CENTER);
	}
}
