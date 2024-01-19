public class Krol extends Figura {
    public Krol(int row, int col, boolean bialy, Chessboard chessboard) {
        super(row, col, bialy, chessboard);
    }

    @Override
    public void wykonajRuch(int newRow, int newCol) {
        // Implementacja ruchu Króla
        if (czyPoprawnyRuch(newRow, newCol)) {
            row = newRow;
            col = newCol;
        } else {
            System.out.println("Niepoprawny ruch króla.");
        }
    }


    @Override
    public boolean czyPoprawnyRuch(int newRow, int newCol) {
        // Sprawdź czy ruch jest zgodny z ruchem króla
        int deltaX = Math.abs(newRow - row);
        int deltaY = Math.abs(newCol - col);

        return (deltaX <= 1 && deltaY <= 1);
    }

    @Override
    public char getSymbol() {
        return czyBiały() ? 'K' : 'k';
    }
}
