class Solution {
    public int maxProfit(int[] arr) {
        int dp[][] = new int[arr.length][2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(0,arr,0,dp);
    }

    public int helper(int i, int arr[], int status, int dp[][]){
        if(i>=arr.length){
            return 0;
        }

        if(dp[i][status]!=-1){
            return dp[i][status];
        }

        int inc=0;
        if(status==0){//ready to buy
            inc = helper(i+1,arr,1,dp)-arr[i];
        }
        else if(status==1){//sell
            inc = helper(i+2,arr,0,dp)+ arr[i];
        }

        int exc = helper(i+1,arr,status,dp);

        return dp[i][status]=Math.max(inc,exc);
    }
}