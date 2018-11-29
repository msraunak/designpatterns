package checker;

import java.awt.*;

/**
 * This is a checker class that holds the logic of the Checker Game
 * @author Jim Glenn
 * @author Mohammad S. Raunak
 * @version 1.0
 * @since 09/18/2012
 */

public class Checker extends GamePiece
{
    /**
     * Creates a checker of the given color.
     *
     * @param color the color of the new checker
     */

    public Checker(Color color)
    { 	// delegating the con
        super(color);
    }

    /**
     * Determines if this checker can make the given move on the given board.
     *
     * @param board the checkerboard this checker is on
     * @param fromRow the starting row
     * @param fromCol the starting column
     * @param toRow the ending row
     * @param toCol the ending column
     * @return true if and only if the move is legal, false otherwise
     */
    public boolean isLegalMove(CheckerBoardModel board,
                               int fromRow, int fromCol, int toRow, int toCol)
    {
        // non-diagonal moves are always illegal
        if (!isDiagonal(fromRow, fromCol, toRow, toCol))
            {
                return false;
            }

        // check forwards/backwards
        if (!directionValid(fromRow, fromCol, toRow, toCol))
            {
                return false;
            }

        // calculate whether move is a jump or not
        int distance = calcDistance(fromRow, fromCol, toRow, toCol);

        // check positions of other pieces on the board
        if (!checkBoard(board, fromRow, fromCol, toRow, toCol, distance))
            {
                return false;
            }

        return true;
    }
    
    /**
     * Checks the pieces on the board to determine if the given move is
     * legal for this piece given the locations of other pieces on the
     * board.
     *
     * @param board the checkerboard this checker is on
     * @param fromRow the starting row
     * @param fromCol the starting column
     * @param toRow the ending row
     * @param toCol the ending column
     * @param distance the distance between the two positions
     * @return true if the move does not violate location rules, false otherwise
     */
    protected boolean checkBoard(CheckerBoardModel board,
                                 int fromRow, int fromCol, int toRow, int toCol,
                                 int distance)
    {
        if (!checkDestination(board, toRow, toCol, distance))
            {
                // space was occupied; return false
                return false;
            }
        
        if (distance == 1)
            {
                // one-space move, all checks already done
                return true;
            }
        else if (distance == 2)
            {
                // two-space move, so must be a jump...

                // compute midpoint of jump
                int midR = (fromRow + toRow) / 2;
                int midC = (fromCol + toCol) / 2;

                // make sure there's a checker of opposite color in middle
                Checker jumped = board.getChecker(midR, midC);
                
                return (jumped != null
                        && !jumped.getColor().equals(getColor()));
            }
        else
            {
                // moving more than 2 spaces, so illegal
                return false;
            }
    }

    /**
     * Determines if it is legal to move to the given location.
     *
     * @param board to board this piece is on
     * @param toRow the row to move to
     * @param toCol the column to move to
     * @param distance the distance this piece is moving
     */
    protected boolean checkDestination(CheckerBoardModel model, int toRow, int toCol, int distance)
    {
        return (model.getChecker(toRow, toCol) == null);
    }

    /**
     * Determines if the given move is diagonal.
     *
     * @param fromRow the row to move from
     * @param fromCol the column to move from
     * @param toRow the row to move to
     * @param toCol the column to move to
     * @return true iff the coordinates are on 45 degree diagonals from each, false otherwise
     * other
     */
    protected static boolean isDiagonal(int fromRow, int fromCol, int toRow, int toCol)
    {
        return (Math.abs(fromRow - toRow) == Math.abs(fromCol - toCol));
    }

    /**
     * Determines if the given move is a valid direction for this checker.
     * Black checkers must move down; reds up.
     *
     * @param fromRow the row to move from
     * @param fromCol the column to move from
     * @param toRow the row to move to
     * @param toCol the column to move to
     * @return true iff the direction is a valid move for this piece
     */
    protected boolean directionValid(int fromRow, int fromCol, int toRow, int toCol)
    {
        if (getColor().equals(Color.black))
            {
                // black can only move down
                return toRow > fromRow;
            }
        else
            {
                // red can only move up
                return toRow < fromRow;
            }
    }

    /**
     * Calculates the distance between the given locations.  The distance
     * is defined as the maximum of the absolute values of the coordinates.
     *
     * @param fromRow the row to move from
     * @param fromCol the column to move from
     * @param toRow the row to move to
     * @param toCol the column to move to
     *
     * @return the distance between those positions
     */
    protected int calcDistance(int fromRow, int fromCol, int toRow, int toCol)
    {
        return Math.max(Math.abs(fromRow - toRow), Math.abs(fromCol - toCol));
    }

    /**
     * Updates the board for side-effects of moving this checker
     * between the given location.  "Side-effects" here means that any
     * jumped checker is removed.  This checker itself is not moved; rather
     * the checker that will take its place (possibly itself) is returned.
     * This can be null in case this checker should itself be removed.
     * 
     * @param board the checker board
     * @param fromRow the row to move from
     * @param fromCol the col to move from
     * @param toRow the row to move to
     * @param toCol the col to move to
     */
    public void updateBoard(CheckerBoardModel board,
                               int fromRow, int fromCol, int toRow, int toCol)
    {
        // remove this checker from starting position

        board.removePiece(fromRow, fromCol);

        // removed jumped piece, if any

        if (calcDistance(fromRow, fromCol, toRow, toCol) == 2)
            board.removePiece((fromRow + toRow) / 2, (fromCol + toCol) / 2);

        // return the piece to place at the ending position, which
        // is this piece unless it gets promoted to King

        if (checkPromotion(board, toRow, toCol))
            board.placePiece(toRow, toCol, promote());
        else
            board.placePiece(toRow, toCol, this);
    }

    /**
     * Determines if this checker should be promoted if it moves to the
     * given location on the given board.  Black checkers are promoted
     * when they move to the bottom; reds when they move to the top.
     *
     * @param board the board this checker is moving on
     * @param toRow the row it is moving to
     * @param toCol the column it is moving to
     * @return true iff this checker should be promoted
     */
    protected boolean checkPromotion(CheckerBoardModel board, int toRow, int toCol)
    {
        if (getColor() == Color.BLACK)
            {
                return (toRow == board.getHeight() - 1);
            }
        else
            {
                return (toRow == 0);
            }
    }

    /**
     * Returns the piece this checker gets promoted to.  Checkers are
     * promoted to kings of the same color.
     *
     * @return the new piece that this checker is promoted to
     */
    protected Checker promote()
    {
        return new King(this.getColor());
    }
}
