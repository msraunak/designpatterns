package checker;

import java.awt.Color;
/**
 * A model of a 2-D grid-based game board.
 * @author Jim Glenn
 * @author Mohammad Raunak
 * @version 1.0 09/11/2012
 */
public abstract class GameBoardModel
{
    /**
     * Stores what game piece is at each position.
     */
    protected GamePiece[][] pieces;

    /**
     * Creates an empty board of the given size.
     *
     * @param width the width, in squares, of this new board
     * @param height the height, in squares, of this new board
     */
    public GameBoardModel(int width, int height)
    {
	pieces = new GamePiece[height][width];
    }

    /**
     * Returns the color of the board at the specified position.
     *
     * @param row the row
     * @param col the column
     * @return the color of the board at row <CODE>row</CODE>, column
     * <CODE>col</CODE>
     */
    public Color getBoardAt(int row, int col)
    {
	if (row % 2 == col % 2)
	    return Color.RED.darker();
	else
	    return Color.BLACK;
    }

    /**
     * Returns the piece at the specified position, or <CODE>null</CODE>
     * if that position is empty.
     *
     * @param row the row
     * @param col the column
     * @return the piece at row <CODE>row</CODE>, column <CODE>col</CODE>
     */
    public GamePiece getPieceAt(int row, int col)
    {
	return pieces[row][col];
    }
 
    /**
     * Returns the width of this board.
     *
     * @return the width
     */
    public int getWidth()
    {
	return pieces[0].length;
    }

    /**
     * Returns the height of this board.
     *
     * @return the height
     */
    public int getHeight()
    {
	return pieces.length;
    }

    /**
     * Determines if the given position is on this board.
     *
     * @param r the row
     * @param c the column
     * @return true iff that row and column is on the board
     */
    protected boolean inBounds(int r, int c)
    {
	return (r >= 0 && c >= 0 && r < getHeight() && c < getWidth());
    }

    /**
     * Determines if the given move is legal.
     * A move is legal is both spaces are within the bounds of the
     * board, there is a piece at the starting position and
     * there is no piece at the ending position.  Subclasses should
     * override this method to add any other rules.
     *
     * @param fromR the starting row of the checker to be moved
     * @param fromC the starting column of the checker to be moved
     * @param toR the ending row
     * @param toC the ending column
     * @return true iff the move is legal
     */
    public boolean isLegalMove(int fromR, int fromC, int toR, int toC)
    {
	// check if all spaces are on the board

	if (!inBounds(fromR, fromC) || !inBounds(toR, toC))
            {
                return false;
            }

	// check that there is a piece at the starting position

	GamePiece piece = getPieceAt(fromR, fromC);
	if (piece == null)
            {
                return false;
            }

	return true;
    }

    /**
     * Determines if the given move is legal.
     * All moves from a square to the same square are considered illegal.
     * Subclasses should override this method to implement
     * their rules.
     *
     * @param fromR the starting row of the checker to be moved
     * @param fromC the starting column of the checker to be moved
     * @param toR the ending row
     * @param toC the ending column
     * @return true iff the move is legal
     */
    public boolean isLegalMove(int r, int c)
    {
	return false;
    }

    /**
     * Updates the board to reflect the results of the given move.
     * The move must be legal.  This version of the method simply moves
     * the piece from one square to another.  Subclasses should override
     * this method to change or augment this behavior.
     *
     * @param fromR the row to move from
     * @param fromC the column to move from
     * @param toR the row to move to
     * @param toC the column to move to
     */
    public void makeMove(int fromR, int fromC, int toR, int toC)
    {
	movePiece(fromR, fromC, toR, toC);
    }

    /**
     * Updates the board to reflect the results of the given move.
     * The move must be legal.  This version of the method does
     * nothing; subclasses must override this if single-square
     * moves are meaningful.
     *
     * @param r the row
     * @param c the column
     */
    public void makeMove(int r, int c)
    {
    }

    /**
     * Moves the piece at the first position to the second position,
     * leaving the first empty.  Both positions must be valid.
     *
     * @param fromR the row to move from
     * @param fromC the column to move from
     * @param toR the row to move to
     * @param toC the column to move to
     */
    public void movePiece(int fromR, int fromC, int toR, int toC)
    {
	pieces[toR][toC] = pieces[fromR][fromC];
	pieces[fromR][fromC] = null;
    }

    /**
     * Removes the piece at the given position, leaving that position empty.
     * The position must be valid.
     *
     * @param row the row
     * @param col the column
     */
    public void removePiece(int row, int col)
    {
	pieces[row][col] = null;
    }

    /**
     * Places the given piece at the given position on this board.
     *
     * @param row the row
     * @param col the column
     * @param piece the piece to put there
     */
    public void placePiece(int row, int col, GamePiece piece)
    {
	pieces[row][col] = piece;
    }
}
