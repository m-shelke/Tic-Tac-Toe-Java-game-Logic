import java.util.Random;
import java.util.Scanner;

public class AITicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }


        Random random = new Random();
        boolean randomTurn = random.nextBoolean();
        char player;
        if (randomTurn){
             player = 'x';
        }else {
             player = 'o';
        }

        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);


        while (!gameOver) {

            System.out.println("BOARD: ");
            printBoard(board);

            if (player == 'o'){  // let's say 'o' is AI
                int row, col;

                do {
                    row = random.nextInt(3);
                    col = random.nextInt(3);
                }while (board[row][col] !=  ' ');

                board[row][col] = player;
                System.out.println("AI played at : " + row + ", " + col);
                printBoard(board);
                gameOver = hashWon(board,player);

                if (gameOver){
                    System.out.println("Player " + player + " Has Won");
                }else {
                    player = 'x';
                }

            }

            System.out.print("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {

                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    gameOver = hashWon(board, player);

                    if (gameOver) {
                        System.out.println("Player " + player + " Has Won ");
                    } else {
                        if (player == 'x') {
                            player = 'o';
                        } else {
                            player = 'x';
                        }
                    }

                } else {
                    System.out.println("Invalid Move. Try Again!");
                }
            }else {
                System.out.println("Invalid Position. Try Again!");
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
