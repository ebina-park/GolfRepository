import java.util.Scanner;

public class GolfMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GolfGame game = new GolfGame();

        while (true) {
            System.out.print("スコアをカンマ区切りで入力してください : ");
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("空の入力です。もう一度入力してください。");
                continue;
            }

            if (game.inputScores(input)) {
                game.calculateAndPrintScore();
                break;
            }
        }

        sc.close();
    }
}
