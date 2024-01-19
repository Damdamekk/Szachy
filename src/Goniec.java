public class Goniec extends Figura {
    public Goniec(int row, int col, boolean biały, Chessboard chessboard) {
        super(row, col, biały, chessboard);
    }

    @Override
    public void wykonajRuch(int newRow, int newCol) {
        // Implementacja ruchu Gońca
        this.row = newRow;
        this.col = newCol;
    }

    @Override
    public boolean czyPoprawnyRuch(int newRow, int newCol) {
        // Sprawdź, czy ruch jest po skosie
        if (Math.abs(newRow - row) != Math.abs(newCol - col)) {
            System.out.println("Niepoprawny ruch gońca.");
            return false;
        }

        // Sprawdź, czy na drodze nie ma żadnych innych figur
        int rowIncrement = Integer.compare(newRow, row);
        int colIncrement = Integer.compare(newCol, col);

        for (int i = row + rowIncrement, j = col + colIncrement; i != newRow || j != newCol; i += rowIncrement, j += colIncrement) {
            if (chessboard.plansza[i][j] != null) {
                System.out.println("Na drodze gońca znajduje się inna figura. Niepoprawny ruch gońca.");
                return false;
            }
        }

        // Poprawny ruch, brak przeszkód na drodze
        return true;
    }

    @Override
    public char getSymbol() {
        return czyBiały() ? 'G' : 'g';
    }
}
