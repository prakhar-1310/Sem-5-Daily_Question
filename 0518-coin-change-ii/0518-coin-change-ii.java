class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount+1][coins.length];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(amount,coins,0,dp);
    }

    public int helper(int amount, int coins[], int i, int dp[][]){
        if(amount==0){
            return 1;
        }
        if(i>=coins.length){
            return 0;
        }
        if(dp[amount][i]!=-1){
            return dp[amount][i];
        }

        int inc=0;
        if(coins[i]<=amount){
            inc = helper(amount-coins[i],coins,i,dp);
        }

        int exc = helper(amount,coins,i+1,dp);

        return dp[amount][i]=inc+exc;
    }
    
}