package checker;

import java.awt.Graphics;

/**
 * A view of a checker board.
 *
 * @author Jim Glenn
 * @version 1.0 9/19/2010
 */

public class CheckerBoardView extends GameBoardView
{
    /**
     * Creates a view of the given board.
     *
     * @param m a checker board
     */
    
    public CheckerBoardView(CheckerBoardModel m)
    {
        super(m);
    }

    /**
     * Draws the given piece at the given location.
     *
     * @param g the context to draw in
     * @param piece the piece to draw
     * @param x the upper left x coordinate to draw at
     * @param y the upper left y coordinate to draw at
     * @param size the width of the bounding square to draw in
     */

    protected void drawPiece(Graphics g, GamePiece piece, int x, int y, int size)
    {
        /* if (piece instanceof Superking)
            {
                g.setColor(piece.getColor());

                // draw outermost ring
                g.drawOval(x + 1, y + 1, size - 2, size - 2);
                g.drawOval(x + 2, y + 2, size - 4, size - 4);

                // draw another ring
                g.drawOval(x + 4, y + 4, size - 8, size - 8);
                g.drawOval(x + 5, y + 5, size - 10, size - 10);
                
                // draw filled middle
                g.fillOval(x + 8, y + 8, size - 16, size - 16);
            }
            else*/
    	if (piece instanceof King)
            {
                g.setColor(piece.getColor());

                // draw outer ring
                g.drawOval(x + 1, y + 1, size - 2, size - 2);
                g.drawOval(x + 2, y + 2, size - 4, size - 4);
                
                // draw filled middle
                g.fillOval(x + 4, y + 4, size - 8, size - 8);
            }
        else
            {
                super.drawPiece(g, piece, x, y, size);
            }
    }

}
