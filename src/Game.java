import java.io.IOException;
import java.util.Scanner;

public class Game {
    private Board b1;

    public Game() {
        Board board = new Board();
        this.b1 = board;
    }

    public void gameStart() {
        this.b1.generateNew();
        this.b1.generateNew();
        this.b1.display();
        try (Scanner in = new Scanner(System.in)) {
            while (!this.b1.isBoardFull()) {
                String input = in.nextLine();
                if (input.equalsIgnoreCase("W")) {
                    clear();
                    this.b1.moveUp();
                    if (!this.b1.isBoardFull())
                        this.b1.generateNew();
                    this.b1.display();
                } else if (input.equalsIgnoreCase("S")) {
                    clear();
                    this.b1.moveDown();
                    if (!this.b1.isBoardFull())
                        this.b1.generateNew();
                    this.b1.display();
                } else if (input.equalsIgnoreCase("A")) {
                    clear();
                    this.b1.moveLeft();
                    if (!this.b1.isBoardFull())
                        this.b1.generateNew();
                    this.b1.display();
                } else if (input.equalsIgnoreCase("D")) {
                    clear();
                    this.b1.moveRight();
                    if (!this.b1.isBoardFull())
                        this.b1.generateNew();
                    this.b1.display();
                }
            }
            System.out.println("The game is over. Press letter s to continue...");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("S")) {
                clear();
                System.out.println("The game is restarting.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameRestart();
            }
        }
        clear();
        this.b1.display();
        return;
    }

    private void gameRestart() {
        this.b1 = new Board();
        gameStart();
    }

    private void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {

        }
    }
}
