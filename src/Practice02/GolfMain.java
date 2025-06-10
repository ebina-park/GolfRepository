package Practice02;

import java.util.Scanner;

public class GolfMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GolfMatch match = new GolfMatch();
 
        while (true) {
            System.out.print("選手名2人と36個のスコアをカンマ区切りで入力してください : ");
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("空の入力です。もう一度入力してください。");
                continue;
            }

            if (match.inputPlayersAndScores(input)) {
                match.printResult();
                break;
            }
        }
 
        sc.close();
    }
}
