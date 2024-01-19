public class Chessboard {
    public Figura[][] plansza;

    public Chessboard() {
        plansza = new Figura[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Umieść piony
        for (int i = 0; i < 8; i++) {
            plansza[1][i] = new Pion(1, i, false, this);
            plansza[6][i] = new Pion(6, i, true, this);
        }

        // Umieść wieże
        plansza[0][0] = new Wieża(0, 0, false, this);
        plansza[0][7] = new Wieża(0, 7, false, this);
        plansza[7][0] = new Wieża(7, 0, true, this);
        plansza[7][7] = new Wieża(7, 7, true, this);

        // Umieść gońce
        plansza[0][2] = new Goniec(0, 2, false, this);
        plansza[0][5] = new Goniec(0, 5, false, this);
        plansza[7][2] = new Goniec(7, 2, true, this);
        plansza[7][5] = new Goniec(7, 5, true, this);

        // Umieść hetmanów
        plansza[0][3] = new Hetman(0, 3, false, this);
        plansza[7][3] = new Hetman(7, 3, true, this);
        // Umieść skoczki
        plansza[0][1] = new Skoczek(0, 1, false, this);
        plansza[0][6] = new Skoczek(0, 6, false, this);
        plansza[7][1] = new Skoczek(7, 1, true, this);
        plansza[7][6] = new Skoczek(7, 6, true, this);

        // Umieść króle
        plansza[0][4] = new Krol(0, 4, false, this);
        plansza[7][4] = new Krol(7, 4, true, this);
    }

    public void displayBoard() {
        System.out.println("  a b c d e f g h");
        System.out.println(" +----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "|");
            for (int j = 0; j < 8; j++) {
                String kolorPola = (i + j) % 2 == 0 ? "\u001B[48;5;238m" : "\u001B[48;5;237m";
                System.out.print(kolorPola);

                if (plansza[i][j] != null) {
                    String oznaczenieFigury = plansza[i][j].czyBiały() ? "\u001B[31m" : "\u001B[34m"; // Czerwony dla białych, niebieski dla czarnych
                    System.out.print(oznaczenieFigury + plansza[i][j].getSymbol());
                } else {
                    System.out.print(" ");
                }

                // Resetowanie koloru tła
                System.out.print("\u001B[0m ");
            }
            System.out.println("|");
        }
        System.out.println(" +----------------");
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol) {
        if (currentRow < 0 || currentRow >= 8 || currentCol < 0 || currentCol >= 8 ||
                newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            System.out.println("Ruch poza zakresem planszy.");
            return false;
        }

        Figura figura = plansza[currentRow][currentCol];

        if (figura == null) {
            System.out.println("Na pozycji początkowej nie ma figury.");
            return false;
        }

        if (!figura.czyPoprawnyRuch(newRow, newCol)) {
            System.out.println("Niepoprawny ruch figury.");
            return false;
        }

        Figura figuraNaDocelowym = plansza[newRow][newCol];
        if (figuraNaDocelowym != null && figuraNaDocelowym.czyBiały() == figura.czyBiały()) {
            System.out.println("Na docelowej pozycji znajduje się figura tego samego koloru. Niepoprawny ruch figury.");
            return false;
        }

        return true;
    }

    public void moveFigure(int currentRow, int currentCol, int newRow, int newCol) {
        Figura figura = plansza[currentRow][currentCol];

        if (figura != null && figura.czyPoprawnyRuch(newRow, newCol)) {
            // Sprawdź, czy pole docelowe jest puste
            if (plansza[newRow][newCol] == null) {
                plansza[currentRow][currentCol] = null;
                plansza[newRow][newCol] = figura;
                figura.wykonajRuch(newRow, newCol);
            } else {
                // Sprawdź, czy zbijamy figurę przeciwnego koloru
                if (figura.czyBiały() != plansza[newRow][newCol].czyBiały()) {
                    plansza[currentRow][currentCol] = null;
                    plansza[newRow][newCol] = figura;
                    figura.wykonajRuch(newRow, newCol);
                    System.out.println("Figura zbita!");
                } else {
                    System.out.println("Na docelowej pozycji znajduje się figura tego samego koloru. Niepoprawny ruch figury.");
                }
            }
        } else {
            System.out.println("Niepoprawny ruch figury");
        }
    }
}
