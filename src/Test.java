import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'x';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {

            System.out.println("BOARD: ");
            printBoard(board);

            System.out.print("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = hashWon(board, player);

                if (gameOver){
                    System.out.println("Player " + player + " Has Won ");
                }else {
                    if (player == 'x'){
                        player = 'o';
                    }else {
                        player = 'x';
                    }
                }

            } else {
                System.out.println("Invalid Move. Try Again!");
            }
        }

        printBoard(board);
    }

    private static boolean hashWon(char[][] board, char player) {

        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }

            for (int col = 0; col < board[row].length; col++){
                if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                    return true;
                }
            }

            if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }

            if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }
        }

        return false;
    }

    private static void printBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
