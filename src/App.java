import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Use w a s d keys to play game...");
        System.out.println("Choose color(1-2-3)");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                setColor("07");
                break;
            case "2":
                setColor("80");
                break;
            case "3":
                setColor("61");
                break;
            default:
                setColor("07");
                break;
        }
        Game game = new Game();
        game.gameStart();
        System.out.println("The game is over.");
    }

    private static void setColor(String color) {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "color " + color).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
        }
    }
}
