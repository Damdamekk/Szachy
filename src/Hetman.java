public class Hetman extends Figura {
    public Hetman(int row, int col, boolean biały, Chessboard chessboard) {
        super(row, col, biały, chessboard);
    }

    @Override
    public void wykonajRuch(int newRow, int newCol) {
        // Implementacja ruchu Hetmana
        this.row = newRow;
        this.col = newCol;
    }

    @Override
    public boolean czyPoprawnyRuch(int newRow, int newCol) {
        // Sprawdź, czy ruch jest w jednym z możliwych kierunków (pionowy, poziomy lub na ukos)
        if (newRow != row && newCol != col && Math.abs(newRow - row) != Math.abs(newCol - col)) {
            System.out.println("Niepoprawny ruch hetmana.");
            return false;
        }

        // Sprawdź, czy na drodze nie ma żadnych innych figur
        int rowIncrement = Integer.compare(newRow, row);
        int colIncrement = Integer.compare(newCol, col);

        for (int i = row + rowIncrement, j = col + colIncrement; i != newRow || j != newCol; i += rowIncrement, j += colIncrement) {
            if (chessboard.plansza[i][j] != null) {
                System.out.println("Na drodze hetmana znajduje się inna figura. Niepoprawny ruch hetmana.");
                return false;
            }
        }

        // Poprawny ruch, brak przeszkód na drodze
        return true;
    }

    @Override
    public char getSymbol() {
        return czyBiały() ? 'H' : 'h';
    }
}