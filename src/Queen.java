public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }


    public boolean canMoveLikBishop(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return (Math.abs(toLine-line) == Math.abs(toColumn-column))
                &&(line!=toLine)
                &&(checkPos(toLine))
                &&(checkPos(toColumn));
    }

    public boolean canMoveLikeRook(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean horizontalMove  = (toLine == line) && (toColumn!= column);
        boolean verticalMove = (toColumn == column) && (toLine != line);
        return (horizontalMove || verticalMove) && checkPos(toLine) && checkPos(toColumn);
    }

    public boolean isBusySameColor(ChessBoard chessBoard, int toLine, int toColumn)
    {
        ChessPiece piece  =   chessBoard.board[toLine][toColumn];
        if (piece!=null) {
            return piece.getColor().equals(getColor());
        }
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canMoveLikeRook =  canMoveLikeRook(chessBoard, line, column, toLine, toColumn);
        boolean canMoveLikBishop =  canMoveLikBishop(chessBoard, line, column, toLine, toColumn);
        boolean canMoveToPosition = canMoveLikeRook || canMoveLikBishop;
        return  canMoveToPosition && !(isBusySameColor(chessBoard,toLine, toColumn));
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
