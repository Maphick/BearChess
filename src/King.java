public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
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
        boolean canMoveToPosition = (Math.abs(toLine-line) <= 1) && (Math.abs(toColumn-column)<=1)
                && !((toLine==line)&&(toColumn==column))
                &&checkPos(toLine)
                &&checkPos(toColumn);
        return  canMoveToPosition && !(isBusySameColor(chessBoard,toLine, toColumn));
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
