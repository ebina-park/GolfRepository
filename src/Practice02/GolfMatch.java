package Practice02;

public class GolfMatch {
    private final int[] pars = {4,4,3,4,5,4,5,3,4,4,3,4,5,4,3,4,5,4};
    private Player player1;
    private Player player2;

    public boolean inputPlayersAndScores(String input) {
        String[] parts = input.replace(" ", "").split(",");

        if (parts.length != 38) {
            System.out.println("入力の形式が間違っています。名前2つとスコア36個が必要です。");
            return false;
        	}

        String playerName1 = parts[0];
        String playerName2 = parts[1];
        
        player1 = new Player(playerName1);
        player2 = new Player(playerName2);

        try {
            int[] scores1 = new int[18];
            int[] scores2 = new int[18];

            for (int i = 0; i < 18; i++) {
                scores1[i] = Integer.parseInt(parts[i + 2]);
                scores2[i] = Integer.parseInt(parts[i + 20]);

                if (scores1[i] <= 0 || scores2[i] <= 0) {
                    System.out.println("0以下の数値が含まれています。再入力してください。");
                    return false;
                }
            }

            player1.setScores(scores1);
            player2.setScores(scores2);

        } catch (NumberFormatException e) {
            System.out.println("不正な文字が含まれています。再入力してください。");
            return false;
        }

        return true;
    }

    public void printResult() {
        int total1 = player1.calculateTotalScore(pars);
        int total2 = player2.calculateTotalScore(pars);

        System.out.println("\n結果発表");
        System.out.println(player1.getName() + "のスコア: " + total1);
        System.out.println(player2.getName() + "のスコア: " + total2);

        if (total1 < total2) {
            System.out.println("勝者は「" + player1.getName() + "」です！");
        } else if (total1 > total2) {
            System.out.println("勝者は「" + player2.getName() + "」です！");
        } else {
            System.out.println("引き分けです！");
        }
    }
}
