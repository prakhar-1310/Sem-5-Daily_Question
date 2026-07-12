class Solution {
    public int numSquares(int n) {
        int dp[][] = new int[n+1][(int)Math.sqrt(n)+1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }
        return helper(n, dp, 1);
    }

    public int helper(int n, int dp[][], int i){
        if(n==0){
            return 0;
        }
        if(n<0 || i*i>n){
            return Integer.MAX_VALUE/2;
        }
        if(dp[n][i]!=-1){
            return dp[n][i];
        }

        // take
        int opt1 = 1+helper(n-(i*i), dp, i);
        // skip
        int opt2 = helper(n, dp, i+1);

        return dp[n][i]=Math.min(opt1, opt2);
    }
}