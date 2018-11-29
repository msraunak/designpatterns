package checker;

import java.awt.*;

/**
 * A colored game piece.
 */
public class GamePiece implements Cloneable
{
    /**
     * The color of this piece.
     */
    private Color color;

    /**
     * Constants for colors.
     */
    public static final Color RED = Color.red;
    public static final Color BLACK = Color.black;
    public static final Color BLUE = Color.blue;
    public static final Color WHITE = Color.white;
    public static final Color GREEN = Color.green;
    public static final Color YELLOW = Color.yellow;
    public static final Color ORANGE = Color.orange;
    public static final Color PURPLE = Color.magenta;
    public static final Color BROWN = Color.yellow.darker();

    /**
     * Creates a new piece of the given color.
     *
     * @param c the color of the new piece
     */
    public GamePiece(Color c)
    {
        color = c;
    }

    /**
     * Returns the color of this piece.
     *
     * @return the color of this piece
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Returns a copy of this piece.  This is implemented here just to change
     * the visibility from protected to public.
     *
     * @return a copy of this piece
     */
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
