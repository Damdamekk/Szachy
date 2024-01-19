public abstract class Figura {
    protected int row;
    protected int col;
    protected boolean biały;
    protected Chessboard chessboard;

    public Figura(int row, int col, boolean biały, Chessboard chessboard) {
        this.row = row;
        this.col = col;
        this.biały = biały;
        this.chessboard = chessboard;
    }

    public boolean czyBiały() {
        return biały;
    }

    public abstract void wykonajRuch(int newRow, int newCol);

    public abstract boolean czyPoprawnyRuch(int newRow, int newCol);

    public abstract char getSymbol();
}
