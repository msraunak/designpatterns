package checker;

import java.awt.*;

public class King extends Checker
{
    public King(Color c)
    {
        super(c);
    }

    public boolean directionValid(int fromR, int fromC, int toR, int toC)
    {
        return true;
    }

    public boolean checkPromotion(CheckerBoardModel board, int toR, int toC)
    {
        return false;
    }
}
