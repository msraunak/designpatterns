package checker;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


/**
 * A Swing window that displays a game of checkers.
 */
public class GameWindow extends JFrame
{
	public GameWindow()
	{
		// set the layout for this window
		getContentPane().setLayout(new BorderLayout());

		// add the view to fill the window
		getContentPane().add(new CheckerBoardView(new CheckerBoardModel()),
				BorderLayout.CENTER);

		setSize(400, 400);
		setVisible(true);

		// was DISPOSE_ON_CLOSE not available when I first wrote this?
		addWindowListener(new CloseListener());
	}

	public static void main(String[] args)
	{
		new GameWindow();
	}

	/*
	 * A private inner class
	 */
	private class CloseListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			dispose();
		}
	}
}
