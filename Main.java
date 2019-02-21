import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean finished = false;
        while (!finished) {
            Board b = new Board();
            b.clearBoard();
            b.draw();
            b.play();
            System.out.println("Thank you for playing :) -  would you like to play again?(anything)");
            Scanner reader = new Scanner(System.in);
            if (reader.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("let's go again!!!");
            } else {
                finished = true;
            }
        }
        // reader.close();
    }
}