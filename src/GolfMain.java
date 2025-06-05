import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GolfMain {
    private static final int[] PARS = {4, 4, 3, 4, 5, 4, 5, 3, 4, 4, 3, 4, 5, 4, 3, 4, 5, 4};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("スコアをカンマ区切りで入力してください > ");
            String input = scanner.nextLine().replace(" ", "");

            if (input.isEmpty()) {
                System.out.println("空の入力です。もう一度入力してください。");
                continue;
            }

            String[] tokens = input.split(",");
            List<Integer> scores = new ArrayList<>();
            boolean error = false;

            for (String token : tokens) {
                try {
                    int score = Integer.parseInt(token);
                    if (score <= 0) {
                        System.out.println("0以下の数値が含まれています。");
                        error = true;
                        break;
                    }
                    if (scores.size() < PARS.length) {
                        scores.add(score); // 19ホール以降は無視
                    }
                } catch (NumberFormatException e) {
                    System.out.println("不正な文字が含まれています。数字とカンマのみ使用してください。");
                    error = true;
                    break;
                }
            }

            if (error || scores.isEmpty()) continue;

            int total = 0;
            for (int i = 0; i < scores.size(); i++) {
                total += scores.get(i) - PARS[i];
            }

            System.out.printf("%dホール終了しました。スコア：%+d\n", scores.size(), total);
            break;
        }
        scanner.close();
    }
}
