public class Horse extends ChessPiece{
    public Horse(String color) {
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
        // I
        // i -> (i-2) or (i+2)
        // j -> (j-1) or (j+1)
        boolean first_var_i = (toLine == (line-2) || toLine == (line+2));
        boolean first_var_j = (toColumn == (column-1) || toColumn == (column+1));
        boolean first_var_i_j = first_var_i && first_var_j;
        // II
        // i -> (i-1) or (i+1)
        // j -> (j-2) or (j+2)
        boolean second_var_i = (toLine == (line-1) || toLine == (line+1));
        boolean second_var_j = (toColumn == (column-2) || toColumn == (column+2));
        boolean second_var_i_j = second_var_i && second_var_j;

        return (checkPos(toLine) && checkPos(toColumn) && ((first_var_i_j) || (second_var_i_j)) );
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
