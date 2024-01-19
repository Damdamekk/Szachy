import java.util.Scanner;

public class ChessGame {
    private Chessboard chessboard;
    private boolean whiteTurn;

    public ChessGame() {
        chessboard = new Chessboard();
        whiteTurn = true;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            chessboard.displayBoard();
            System.out.println(whiteTurn ? "White's turn" : "Black's turn");
            System.out.print("Enter move (e.g., e2 e4): ");
            String move = scanner.nextLine();

            if (isValidMove(move)) {
                chessboard.moveFigure(1, 0, 2, 0);
                // TODO: Add logic for checking check, checkmate, stalemate, castling, en passant, etc.
                whiteTurn = !whiteTurn;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(String move) {
        // TODO: Implement validation logic for moves
        return true;
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.startGame();
    }
}
