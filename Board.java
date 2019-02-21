import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
    private static String[][] board = new String[][] { { "-", "-", "-" }, { "-", "-", "-" }, { "-", "-", "-" } };

    private static int turnCount = 0;

    /**
     * Draw the board for the game Tic Tac Toe
     */
    void draw() {

        for (int rows = 0; rows < board.length; rows++) {
            System.out.println();
            for (int cols = 0; cols < board.length; cols++) {
                System.out.print(board[rows][cols] + " ");
            }
        }
        System.out.println();
    }

    void clearBoard() {
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board.length; cols++) {
                board[rows][cols] = "-";
            }
        }
    }

    /**
     * Change player each turn
     *
     * @return which player it is
     */
    private static String whichPlayer() {
        String playerX = "x";
        String playerY = "o";
        if (turnCount % 2 == 0) {
            return playerX;
        }
        return playerY;
    }

    private boolean isValid(int x) {
        if (x <= 3 && board[0][x - 1].equals("-")) {
            return true;
        } else if (x >= 4 && x <= 6 && board[1][x - 4].equals("-")) {
            return true;
        } else if (x >= 7 && x <= 9 && board[2][x - 7].equals("-")) {
            return true;
        }

        return false;
    }

    /**
     * Check whether the board is full (ie only contains x's or o's)
     *
     * @return true if no -'s are found
     */
    private boolean gameOver() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;

    }

    void play() {
        while (!gameOver()) {
            System.out.println("Enter your number b");
            Scanner reader = new Scanner(System.in);
            int input = reader.nextInt();
            if (isValid(input)) {
                if (input <= 3) {
                    board[0][input - 1] = whichPlayer();
                } else if (input <= 6) {
                    board[1][input - 4] = whichPlayer();
                } else if (input <= 9) {
                    board[2][input - 7] = whichPlayer();
                }

                turnCount++;
            } else {
                System.out.println();
                System.out.println("Invalid move - try again");
            }
            Main.clearScreen();
            draw();
            if (gameWon()) {
                turnCount++;
                System.out.println();
                System.out.println("\n" + whichPlayer() + " has won");
                break;
            }

        }
    }

    /**
     * Checks whether either player has won the game - currently only checks rows
     *
     * @return true if a row is all x's or o's
     */
    private static boolean gameWon() {
        // check horizontally
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols + 2 < board.length; cols++) {
                if (!board[rows][cols].equals("-") && board[rows][cols].equals(board[rows][cols + 1])
                        && board[rows][cols].equals(board[rows][cols + 2])) {
                    return true;
                }
            }
        } // check vertically
        for (int rows = 0; rows + 2 < board.length; rows++) {
            for (int cols = 0; cols < board.length; cols++) {
                if (!board[rows][cols].equals("-") && board[rows][cols].equals(board[rows + 1][cols])
                        && board[rows + 2][cols].equals(board[rows][cols])) {
                    return true;
                }

            }
        } // check top left to bottom right
        if (!board[0][0].equals("-") && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        } // top right to bottom left
        if (!board[0][2].equals("-") && board[0][2].equals(board[1][1]) && board[2][0].equals(board[0][2])) {
            return true;
        }
        return false;

    }

}
