public class Bishop extends ChessPiece{

    public Bishop(String color) {
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
        return (Math.abs(toLine-line) == Math.abs(toColumn-column))
                &&(line!=toLine)
                &&(checkPos(toLine))
                &&(checkPos(toColumn));
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
