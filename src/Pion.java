public class Pion extends Figura {
    private boolean pierwszyRuch;

    public Pion(int row, int col, boolean biały, Chessboard chessboard) {
        super(row, col, biały, chessboard);
        this.pierwszyRuch = true;
    }

    @Override
    public void wykonajRuch(int newRow, int newCol) {
        this.row = newRow;
        this.col = newCol;
        this.pierwszyRuch = false;
    }

    @Override
    public boolean czyPoprawnyRuch(int newRow, int newCol) {
        int kierunek = czyBiały() ? -1 : 1;

        if (!pierwszyRuch && newRow == row + kierunek && newCol == col && chessboard.plansza[newRow][newCol] == null) {
            return true;
        }

        if (pierwszyRuch && (newRow == row + kierunek || newRow == row + 2 * kierunek) && newCol == col && chessboard.plansza[newRow][newCol] == null) {
            return true;
        }

        if (newRow == row + kierunek && (newCol == col - 1 || newCol == col + 1)) {
            // Dodajemy warunek, czy na docelowym polu jest figura przeciwnego koloru
            if (newCol >= 0 && newCol < 8 && chessboard.plansza[newRow][newCol] != null && chessboard.plansza[newRow][newCol].czyBiały() != czyBiały()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public char getSymbol() {
        return czyBiały() ? 'P' : 'p';
    }
}