class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int [cost.length];
        Arrays.fill(dp,-1);
        int a = helper(cost,0,dp);
        int b = helper(cost,1,dp);
        return Math.min(a,b);
    }
    public static int helper(int cost[], int idx,int dp[]){
        if(idx>=cost.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int a = cost[idx]+helper(cost, idx+1,dp);
        int b = cost[idx]+helper(cost,idx+2,dp);
        
        return dp[idx]= Math.min(a,b);
    }
}