class Solution {

    private static final int MOD = 1000000007;
    private static final int NEG = -1000000000;

    private List<String> board;
    private int n;

    class Pair {
        int score;
        int ways;

        Pair(int score, int ways) {
            this.score = score;
            this.ways = ways;
        }
    }

    Pair[][] dp;
    boolean[][] vis;

    private Pair recursion(int i, int j) {

        if (i >= n || j >= n)
            return new Pair(NEG, 0);

        if (board.get(i).charAt(j) == 'X')
            return new Pair(NEG, 0);

        if (i == n - 1 && j == n - 1)
            return new Pair(0, 1);

        if (vis[i][j])
            return dp[i][j];

        vis[i][j] = true;

        Pair down = recursion(i + 1, j);
        Pair right = recursion(i, j + 1);
        Pair diag = recursion(i + 1, j + 1);

        int best = Math.max(down.score, Math.max(right.score, diag.score));

        if (best == NEG) {
            dp[i][j] = new Pair(NEG, 0);
            return dp[i][j];
        }

        int ways = 0;

        if (down.score == best)
            ways = (ways + down.ways) % MOD;

        if (right.score == best)
            ways = (ways + right.ways) % MOD;

        if (diag.score == best)
            ways = (ways + diag.ways) % MOD;

        char ch = board.get(i).charAt(j);
        int val = Character.isDigit(ch) ? ch - '0' : 0;

        dp[i][j] = new Pair(best + val, ways);

        return dp[i][j];
    }

    public int[] pathsWithMaxScore(List<String> board) {

        this.board = board;
        this.n = board.size();

        dp = new Pair[n][n];
        vis = new boolean[n][n];

        Pair ans = recursion(0, 0);

        if (ans.ways == 0)
            return new int[] {0, 0};

        return new int[] {ans.score, ans.ways};
    }
}