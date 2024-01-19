public class Skoczek extends Figura {
    public Skoczek(int row, int col, boolean biały, Chessboard chessboard) {
        super(row, col, biały, chessboard);
    }

    @Override
    public void wykonajRuch(int newRow, int newCol) {
        // Implementacja ruchu Skoczka
        this.row = newRow;
        this.col = newCol;
    }

    @Override
    public boolean czyPoprawnyRuch(int newRow, int newCol) {
        // Sprawdź czy ruch jest zgodny z ruchem skoczka
        int deltaX = Math.abs(newRow - row);
        int deltaY = Math.abs(newCol - col);

        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }

    @Override
    public char getSymbol() {
        return czyBiały() ? 'S' : 's';
    }
}
