public class Wieża extends Figura {
    public Wieża(int row, int col, boolean biały, Chessboard chessboard) {
        super(row, col, biały, chessboard);
    }

    @Override


    public void wykonajRuch(int newRow, int newCol) {
        // Implementacja ruchu Wieży
        this.row = newRow;
        this.col = newCol;
    }

    @Override
    public boolean czyPoprawnyRuch(int newRow, int newCol) {
        // Sprawdź, czy ruch jest w jednym z możliwych kierunków (pionowy lub poziomy)
        if (newRow != row && newCol != col) {
            System.out.println("Niepoprawny ruch wieży.");
            return false;
        }

        // Sprawdź, czy na drodze nie ma żadnych innych figur
        int rowIncrement = Integer.compare(newRow, row);
        int colIncrement = Integer.compare(newCol, col);

        for (int i = row + rowIncrement, j = col + colIncrement; i != newRow || j != newCol; i += rowIncrement, j += colIncrement) {
            if (chessboard.plansza[i][j] != null) {
                // Dodatkowa logika: nie można zbić własnej figury, jeśli pole docelowe nie jest puste
                if (chessboard.plansza[i][j].czyBiały() == czyBiały() && chessboard.plansza[newRow][newCol] != null) {
                    System.out.println("Niepoprawny ruch wieży. Nie można zbijać własnych figurek.");
                    return false;
                }
            }
        }

        // Poprawny ruch, brak przeszkód na drodze
        return true;
    }
    public char getSymbol() {
        return 'W';
    }
}