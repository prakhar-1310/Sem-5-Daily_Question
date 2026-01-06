class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int [coins.length][amount+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        int ans= helper(0,amount,coins,dp);

        return ans==Integer.MAX_VALUE ?  -1:ans;
    }

    public int helper(int i, int amount,int coins[], int dp[][]){
        if(amount==0){
            return 0;
        }

        if(i>=coins.length){
            return Integer.MAX_VALUE;
        }

        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        int inc = Integer.MAX_VALUE;
        if(amount>=coins[i]){
            int opt1 = helper(i, amount-coins[i], coins,dp);
            if(opt1!=Integer.MAX_VALUE){
                inc= 1+opt1;
            }
        }

        int exc = helper(i+1, amount, coins,dp);

        return dp[i][amount]=Math.min(inc,exc);
    }
}