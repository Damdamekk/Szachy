public class Pion {
    private int row;
    private int col;
    private boolean biały;
    private boolean pierwszyRuch;

    public Pion(int row, int col, boolean biały) {
        this.row = row;
        this.col = col;
        this.biały = biały;
        this.pierwszyRuch = true;
    }

    public boolean czyBiały() {
        return biały;
    }

    public void wykonajRuch(int newRow, int newCol) {
        this.row = newRow;
        this.col = newCol;
        this.pierwszyRuch = false;
    }

    public boolean czyPoprawnyRuch(int newRow, int newCol, boolean czyBicie) {
        int kierunek = biały ? -1 : 1;

        // Standardowy ruch o jedno pole do przodu
        if (!czyBicie && newRow == row + kierunek && (newCol == col || (pierwszyRuch && newCol == col && newRow == row + 2 * kierunek))) {
            return true;
        }

        // Bicie w przelocie
        if (czyBicie && newRow == row + kierunek && (newCol == col - 1 || newCol == col + 1)) {
            return true;
        }

        return false;
    }
}