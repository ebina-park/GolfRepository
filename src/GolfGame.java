public class GolfGame {
    private final int[] pars = {4, 4, 3, 4, 5, 4, 5, 3, 4, 4, 3, 4, 5, 4, 3, 4, 5, 4};
    private int[] scores = new int[18];
    private int count = 0;

    public boolean inputScores(String input) {
        String[] parts = input.replace(" ", "").split(",");
        count = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;

            try {
                int n = Integer.parseInt(part);
                if (n <= 0) {
                    System.out.println("0以下の数値が含まれています。もう一度入力してください。");
                    return false;
                }
                if (count >= 18) break;
                scores[count++] = n;
            } catch (NumberFormatException e) {
                System.out.println("不正な文字が含まれています。もう一度入力してください。");
                return false;
            }
        }

        if (count == 0) {
            System.out.println("スコアが入力されていません。もう一度入力してください。");
            return false;
        }

        return true;
    }

    public void calculateAndPrintScore() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += scores[i] - pars[i];
        }
        System.out.println(count + "ホール終了しました。スコア：" + total);
    }
}
