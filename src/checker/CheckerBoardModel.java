package checker;

/**
 * A model of a standard 8x8 checkerboard.
 * @author Jim Glenn
 * @author Mohammad S. Raunak
 * @version 1.0
 * @since 09/11/2014
 */

public class CheckerBoardModel extends GameBoardModel
{
    /**
     * The standard size of a checkerboard.
     */
    public static int DEFAULT_SIZE = 8;

    /**
     * The number of rows of checkers in the starting setup.
     */
    protected static int STARTING_ROWS = 3;

    /**
     * Initializes a standard 8x8 checkerboard with 3 rows of black checkers
     * on the red squares at the top and red checkers at the bottom.
     */
    public CheckerBoardModel()
    {
        this(DEFAULT_SIZE, DEFAULT_SIZE);
    }

    /**
     * Initializes a checkerboard of the given size, with 3 rows of
     * black checkers at the top and red checkers at the bottom.
     *
     * @param height the height, in squares, of the new checkerboard
     * @param width the width, in squares, of the new checkerboard
     */

    public CheckerBoardModel(int height, int width)
    {
        super(width, height);

        setupBoard();
    }

    /**
     * Creates checkers at their initial positions on the board.  This
     * method is called by the constrcutor and can be overridden to
     * allow for alternate setups.
     */
    public void setupBoard()
    {
        for (int r = 0; r < STARTING_ROWS; r++)
            for (int c = 0; c < getWidth(); c += 2)
                {
                    pieces[r][c + (r % 2)] = new Checker(Checker.BLACK);
                    
                    int redRow = getHeight() - r - 1;

                    pieces[redRow][c + (redRow % 2)] = new Checker(Checker.RED);
                }
    }

    /**
     * Returns the checker at the given location on the board.  Returns
     * <CODE>null</CODE> if the square is empty.
     *
     * @param row a row on the board
     * @param col a column on the board
     * @return the checker object in that row and column
     */

    public Checker getChecker(int row, int col)
    {
        return (Checker)getPieceAt(row, col);
    }

    /**
     * Determines if the given move is legal.
     * A checker move is legal if both squares are on the board
     * and the piece being moved deems the move legal, as determined
     * by its <CODE>isLegalMove</CODE> method.
     *
     * @param fromRow the starting row of the checker to be moved
     * @param fromCol the starting column of the checker to be moved
     * @param toRow the ending row
     * @param toCol the ending column
     * @return true iff the move is legal
     */

    public boolean isLegalMove(int fromRow, int fromCol, int toRow, int toCol)
    {
        return (super.isLegalMove(fromRow, fromCol, toRow, toCol)
                && getChecker(fromRow, fromCol).isLegalMove(this, fromRow, fromCol, toRow, toCol));
    }

    /**
     * Updates the board to reflect the results of the given move.
     * The move must be legal.  The checker is moved, and jumped checker
     * is removed, and if promoted (according to its <CODE>checkPromotion</CODE>
     * method, the moved checker is replaced with a <CODE>King</CODE>
     *
     * @param fromR the row to move from
     * @param fromC the column to move from
     * @param toR the row to move to
     * @param toC the column to move to
     */

    public void makeMove(int fromR, int fromC, int toR, int toC)
    {
        Checker moving = getChecker(fromR, fromC);
        
        moving.updateBoard(this, fromR, fromC, toR, toC);
    }
}

