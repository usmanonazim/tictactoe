
import java.util.Scanner;

public class Main {
    /**
     * Clear the terminal screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        boolean finished = false;
        while (!finished) {
            clearScreen();// clear terminal screen before redrawing the game board.
            System.out.println("Welcome to the world famous tictactoe\nPress a number (from 1-9) to begin\n");
            Board b = new Board();
            b.clearBoard();
            b.draw();
            b.play();
            System.out.println(
                    "Thank you for playing :) -  would you like to play again?(\"yes\" for yes, anything else for no)");
            Scanner reader = new Scanner(System.in);
            if (reader.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("let's go again!!!");
            } else {
                finished = true;
            }
        }

    }
}