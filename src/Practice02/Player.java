package Practice02;

public class Player {
    private String name;
    private int[] scores = new int[18];

    public Player(String name) {
        this.name = name;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public int calculateTotalScore(int[] pars) {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i] - pars[i];
        }
        return total;
    }

    public String getName() {
        return name;
    }
}
