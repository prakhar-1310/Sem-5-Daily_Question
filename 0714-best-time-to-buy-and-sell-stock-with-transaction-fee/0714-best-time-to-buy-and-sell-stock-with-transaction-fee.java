class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(0, 0, prices, fee, dp);
    }

    public int helper(int i, int tran, int price[], int fee, int dp[][]){
        if(i>=price.length)return 0;

        if(dp[i][tran]!=-1){
            return dp[i][tran];
        }

        int opt1=0;
        // sell
        if(tran==1){
            opt1 = price[i] - fee + helper(i+1, 0, price, fee, dp);
        }

        // buy
        if(tran==0){
            opt1 = -price[i] + helper(i+1, 1, price, fee, dp);
        }

        // skip

        int opt2 = helper(i+1, tran, price, fee, dp);

        return dp[i][tran]=Math.max(opt1, opt2);
    }
}