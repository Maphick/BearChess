// абстрактный класс ChessPiece (шахматная фигура)
abstract public class ChessPiece {
    // строковая переменная color — цвет
    String color;
    // логическая переменная check, по умолчанию true, она понадобится нам сильно позже;
    boolean check = true;

    // конструктор, принимающий в себя строковую переменную color.
    public ChessPiece(String color) {
        this.color = color;
    }

    // абстрактный метод getColor(), возвращающий строку — должен вернуть цвет фигуры;
    public abstract  String  getColor();

    // абстрактный метод canMoveToPosition(), возвращающий логическое (boolean) значение
    // и паринимающий в себя параметры ChessBoard chessBoard, int line, int column, int toLine, int toColumn;
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    // абстрактный метод getSymbol(), возвращающий строку — тип фигуры.
    public abstract String getSymbol();
}
