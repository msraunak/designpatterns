package checker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Swing components that display <CODE>GameBoardModel</CODE>s.
 * These components respond to mouse clicks by sending a
 * <CODE>GameBoardEvent</CODE> to their listeners.
 *
 */

public class GameBoardView extends JComponent
{
    /**
     * The game board this component displays.
     */
    private GameBoardModel model;

    /**
     * Creates a new view that displays the given game board.
     *
     * @param m the game board this new view will display
     */
    public GameBoardView(GameBoardModel m)
    {
        model = m;

        // set up listeners...
        addMouseListener(new GBMouseListener());
        addMouseMotionListener(new GBMouseMotionListener());

        // ...and auxilliary data for them
        dragging = false;
    }

    /**
     * Computes the size of each grid square in the current view.
     *
     * @return the size of each grid square in the current view.
     */

    private int getSquareSize()
    {
        int squareW = getWidth() / model.getWidth();
        int squareH = getHeight() / model.getHeight();

        return Math.min(squareW, squareH);
    }

    /**
     * Paints the view of the model.
     *
     * @param g the graphics context to draw on
     */
    public void paint(Graphics g)
    {
        // figure out the size (pixels) of each square in the grid

        int squareSize = getSquareSize();
        
        // paint the board

        for (int r = 0; r < model.getHeight(); r++)
            for (int c = 0; c < model.getWidth(); c++)
                {
                    Color board = model.getBoardAt(r, c);
                    
                    g.setColor((Color)board);
                    g.fillRect(c * squareSize, r * squareSize,
                               squareSize, squareSize);
                    
                    GamePiece piece = model.getPieceAt(r, c);
                    if (piece != null)
                        {
                            drawPiece(g, piece, c * squareSize, r * squareSize, squareSize);
                        }
                }

        if (dragging)
            displayDragStatus(g);
    }

    /**
     * Paints the given piece at the given position.
     *
     * @param g the graphics contect to draw on
     * @param piece the piece to draw
     * @param x the x-position to draw at
     * @param y the y-position to draw at
     * @param size the size of the square to draw in
     */
    protected void drawPiece(Graphics g, GamePiece piece, int x, int y, int size)
    {
        g.setColor(piece.getColor());
        g.fillOval(x + 1, y + 1, size - 2, size - 2);
    }

    /**
     * Paints something that reflacts the status of the current drag operation.
     * This is intended to give the user some visual feedback about what
     * will happen when the piece is dropped.
     *
     * @param g the graphics context to draw in
     */
    public void displayDragStatus(Graphics g)
    {
        if ((dragStartRow != dragCurrentRow || dragStartCol != dragCurrentCol)
            && model.isLegalMove(dragStartRow, dragStartCol, dragCurrentRow, dragCurrentCol))
            {
                GamePiece moving = model.getPieceAt(dragStartRow, dragStartCol);
                int size = getSquareSize();
                int x = dragCurrentCol * size;
                int y = dragCurrentRow * size;
        
                drawGhost(g, moving, x, y, size);
            }
    }

    /**
     * Draws the outline of the given piece at the given position in this
     * view.
     *
     * @param g the graphics context to draw on
     * @param x the x-coordinate of the left edge of the bounding box to draw in
     * @param y the y-coordinate of the top edge of the bounding box to draw in
     * @param size the size of the bounding box to draw in (width = height)
     */
    protected void drawGhost(Graphics g, GamePiece moving, int x, int y, int size)
    {
        g.setColor(moving.getColor().brighter());
        g.drawOval(x + 1, y + 1, size - 2, size - 2);
    }

    /**
     * A flag that is set (<CODE>true</CODE>) iff we are in the middle
     * of a drag event.
     */
    private boolean dragging;

    /**
     * Values that keep track of drag events before they are dropped.
     */
    protected int dragStartRow;
    protected int dragStartCol;
    protected int dragCurrentRow;
    protected int dragCurrentCol;

    /**
     * Handles mouse clicks and mouse releases.
     */
    public class GBMouseListener extends MouseAdapter
    {
        /**
         * Processes mouse clicks.
         *
         * @param e a mouse event representing a click
         */
        public void mouseClicked(MouseEvent e)
        {
            dragging = false;

            int squareSize = getSquareSize();
            int clickRow = e.getY() / squareSize;
            int clickCol = e.getX() / squareSize;

            if (model.isLegalMove(clickRow, clickCol))
                {
                    model.makeMove(clickRow, clickCol);
                    repaint();
                }
        }

        /**
         * Processes mouse releases.  Mouse releases are only handled if
         * they signal the end of a drag operation, not if they signal the
         * end of a click.
         *
         * @param e a mouse event representing a release
         */
        public void mouseReleased(MouseEvent e)
        {
            if (dragging)
                {
                    int squareSize = getSquareSize();
                    int dragEndRow = e.getY() / squareSize;
                    int dragEndCol = e.getX() / squareSize;

                    if (model.isLegalMove(dragStartRow, dragStartCol, dragEndRow, dragEndCol))
                        model.makeMove(dragStartRow, dragStartCol, dragEndRow, dragEndCol);
                    
                    repaint();
                }
            
            dragging = false;
        }
    }

    /**
     * Handles mouse drags.
     */
    public class GBMouseMotionListener extends MouseMotionAdapter
    {
        /**
         * Handles the beginning and middle of drag operations.  The
         * end of a drag is handled by the object that receives the final
         * mouse release event.
         *
         * @param e a mouse event representing a drag
         */
        public void mouseDragged(MouseEvent e)
        {
            if (!dragging)
                {
                    int squareSize = getSquareSize();
                    dragStartRow = e.getY() / squareSize;
                    dragStartCol = e.getX() / squareSize;
                    dragCurrentRow = dragStartRow;
                    dragCurrentCol = dragStartCol;

                    dragging = true;
                }
            else
                {
                    int squareSize = getSquareSize();
                    int newCurrentRow = e.getY() / squareSize;
                    int newCurrentCol = e.getX() / squareSize;

                    if (newCurrentRow != dragCurrentRow
                        || newCurrentCol != dragCurrentCol)
                        {
                            dragCurrentRow = newCurrentRow;
                            dragCurrentCol = newCurrentCol;

                            repaint();
                        }
                }
        }
    }
}
