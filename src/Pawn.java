public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean isWhite()
    {
        return getColor().equals("White");
    }

    public boolean isFirstWhiteStep(int line)
    {
        return (line == 1)&&isWhite();
    }

    public boolean isFirstBlackStep(int line)
    {
        return (line == 6)&&!(isWhite());
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // for whites
        //
        // any step
        boolean white_step = (toLine == (line+1)) && (toColumn == column) && checkPos(toLine) && checkPos(toColumn);
        if (isWhite() && white_step)
            return true;
        // first step
        boolean first_white_step = isFirstWhiteStep(line) &&  (toLine == (line+2)) && (toColumn == column);
        if (first_white_step)
            return true;
        // for blacks
        //
        // any step
        boolean black_step = (toLine == (line-1)) && (toColumn == column) && checkPos(toLine) && checkPos(toColumn);
        if (!isWhite() && black_step)
            return true;
        // first step
        boolean first_black_step = isFirstBlackStep(line) &&  (toLine == (line-2)) && (toColumn == column);
        if (first_black_step)
            return true;
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
