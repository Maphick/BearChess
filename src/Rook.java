// write your code here
public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
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
        check = false;
        boolean horizontalMove  = (toLine == line) && (toColumn!= column);
        boolean verticalMove = (toColumn == column) && (toLine != line);
        boolean canMoveToPosition = (horizontalMove || verticalMove) && checkPos(toLine) && checkPos(toColumn);
        return  canMoveToPosition && !(isBusySameColor(chessBoard,toLine, toColumn));
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}