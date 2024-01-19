import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        chessboard.displayBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj ruch (np. a2 a4): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Koniec gry.");
                break;
            }

            try {
                String[] moves = input.split(" ");
                if (moves.length != 2) {
                    System.out.println("Nieprawidłowy format ruchu. Spróbuj ponownie.");
                    continue;
                }

                int startCol = moves[0].charAt(0) - 'a';
                int startRow = 8 - Character.getNumericValue(moves[0].charAt(1));

                int endCol = moves[1].charAt(0) - 'a';
                int endRow = 8 - Character.getNumericValue(moves[1].charAt(1));

                chessboard.moveFigure(startRow, startCol, endRow, endCol);
                chessboard.displayBoard();
            } catch (Exception e) {
                System.out.println("Wystąpił błąd: " + e.getMessage() + ". Spróbuj ponownie.");
            }
        }

        scanner.close();
    }
}