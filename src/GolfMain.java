import java.util.Scanner;

public class GolfMain {
    public static void main(String[] args) {
        int[] pars = {4, 4, 3, 4, 5, 4, 5, 3, 4, 4, 3, 4, 5, 4, 3, 4, 5, 4};
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("スコアをカンマ区切りで入力してください :	 ");
            String line = sc.nextLine();

            if (line.trim().isEmpty()) {
                System.out.println("空の入力です。もう一度入力してください。");
                continue;
            }

            String[] arr = line.replace(" ", "").split(",");
            int[] scores = new int[18];
            int count = 0;
            boolean error = false;

            for (int i = 0; i < arr.length && count < 18; i++) {
                if (arr[i].isEmpty()) continue;
                try {
                    int n = Integer.parseInt(arr[i]);
                    if (n <= 0) {
                        System.out.println("0以下の数値が含まれています。");
                        error = true;
                        break;
                    }
                    scores[count] = n;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("不正な文字が含まれています。");
                    error = true;
                    break;
                }
            }

            if (count == 0 || error) continue;

            int total = 0;
            for (int i = 0; i < count; i++) {
                total += scores[i] - pars[i];
            }

            System.out.println(count + "ホール終了しました。スコア：" + total);

            break;
        }

        sc.close();
    }
}
