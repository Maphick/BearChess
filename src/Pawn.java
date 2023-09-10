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


    public boolean isBusy(ChessBoard chessBoard, int toLine, int toColumn)
    {
        ChessPiece piece  =   chessBoard.board[toLine][toColumn];
        return  (piece==null);
    }

    public boolean isBusySameColor(ChessBoard chessBoard, int toLine, int toColumn)
    {
        ChessPiece piece  =   chessBoard.board[toLine][toColumn];
        if (piece!=null) {
            return piece.getColor().equals(getColor());
        }
        else return false;
    }

    public boolean canMoveForEating(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        boolean isObliquelyWhite = getColor().equals("White") && (toLine == line + 1) && (Math.abs(toColumn-column)==1);
        boolean isObliquelyBlack = getColor().equals("Black") && (toLine == line - 1) && (Math.abs(toColumn-column)==1);
        return !(isBusySameColor(chessBoard,toLine, toColumn)) && (isObliquelyWhite || isObliquelyBlack);
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // MOOVING FOR MOVE
        boolean canMoveToPosition = false;
        // for whites
        //
        // any step
        boolean white_step = (toLine == (line+1)) && (toColumn == column) && checkPos(toLine) && checkPos(toColumn);
        if (isWhite() && white_step) {
            canMoveToPosition = true;
            return  canMoveToPosition && !(isBusy(chessBoard,toLine, toColumn));
        }
        // first step
        boolean first_white_step = isFirstWhiteStep(line) &&  (toLine == (line+2)) && (toColumn == column);
        if (first_white_step)
        {
            canMoveToPosition = true;
            return  canMoveToPosition && !(isBusy(chessBoard,toLine, toColumn));
        }
        // for blacks
        //
        // any step
        boolean black_step = (toLine == (line-1)) && (toColumn == column) && checkPos(toLine) && checkPos(toColumn);
        if (!isWhite() && black_step)
        {
            canMoveToPosition = true;
            return  canMoveToPosition && !(isBusy(chessBoard,toLine, toColumn));
        }
        // first step
        boolean first_black_step = isFirstBlackStep(line) &&  (toLine == (line-2)) && (toColumn == column);
        if (first_black_step)
        {
            canMoveToPosition = true;
            return  canMoveToPosition && !(isBusy(chessBoard,toLine, toColumn));
        }

        // MOOVING FOR EAT
        if (
                canMoveForEating(chessBoard, line, column, toLine, toColumn)
        )
            return true;

        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}
