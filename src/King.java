public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        check = false;
        return (Math.abs(toLine-line) <= 1) && (Math.abs(toColumn-column)<=1)
                && !((toLine==line)&&(toColumn==column))
                &&checkPos(toLine)
                &&checkPos(toColumn);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column)
    {
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
