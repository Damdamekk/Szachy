public class Chessboard {
    private Pion[][] plansza;

    public Chessboard() {
        plansza = initializeBoard();
    }

    private Pion[][] initializeBoard() {
        Pion[][] initialBoard = new Pion[8][8];

        // Utwórz piony i umieść je na planszy
        initialBoard[1][0] = new Pion(1, 0, false);
        initialBoard[1][1] = new Pion(1, 1, false);
        initialBoard[1][2] = new Pion(1, 2, false);
        initialBoard[1][3] = new Pion(1, 3, false);
        initialBoard[1][4] = new Pion(1, 4, false);
        initialBoard[1][5] = new Pion(1, 5, false);
        initialBoard[1][6] = new Pion(1, 6, false);
        initialBoard[1][7] = new Pion(1, 7, false);

        initialBoard[6][0] = new Pion(6, 0, true);
        initialBoard[6][1] = new Pion(6, 1, true);
        initialBoard[6][2] = new Pion(6, 2, true);
        initialBoard[6][3] = new Pion(6, 3, true);
        initialBoard[6][4] = new Pion(6, 4, true);
        initialBoard[6][5] = new Pion(6, 5, true);
        initialBoard[6][6] = new Pion(6, 6, true);
        initialBoard[6][7] = new Pion(6, 7, true);

        return initialBoard;
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
                    String oznaczeniePiona = plansza[i][j].czyBiały() ? "\u001B[31mP" : "\u001B[34mp"; // Czerwony P dla białych, niebieskie p dla czarnych
                    System.out.print(oznaczeniePiona);
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


    public void movePawn(int currentRow, int currentCol, int newRow, int newCol) {
        if (isValidMove(currentRow, currentCol, newRow, newCol) && plansza[currentRow][currentCol] instanceof Pion) {
            Pion pion = plansza[currentRow][currentCol];
            plansza[currentRow][currentCol] = null;  // Usunięcie piona z obecnej pozycji
            plansza[newRow][newCol] = pion;         // Przesunięcie piona na nową pozycję
            pion.wykonajRuch(newRow, newCol);       // Aktualizacja pozycji piona
        } else {
            System.out.println("Niepoprawny ruch piona");
        }
    }

    private boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol) {
        // Tutaj możesz dodać bardziej zaawansowaną logikę walidacji ruchu
        return (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8);
    }
}