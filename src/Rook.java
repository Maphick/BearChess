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

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        check = false;
        boolean horizontalMove  = (toLine == line) && (toColumn!= column);
        boolean verticalMove = (toColumn == column) && (toLine != line);
        return (horizontalMove || verticalMove) && checkPos(toLine) && checkPos(toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}