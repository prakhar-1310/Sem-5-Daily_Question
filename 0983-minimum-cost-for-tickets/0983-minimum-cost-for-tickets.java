class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[][] = new int[days.length][366+29];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        
        return helper(days,costs,0,0,dp);
    }

    public int helper(int days[], int costs[], int max, int idx,int dp[][]){
        if(idx==days.length){
            return 0;
        }

        if(dp[idx][max]!=-1){
            return dp[idx][max];
        }

        if(max>=days[idx]){ // means days[idx] is already covered
            return dp[idx][max]=helper(days,costs,max,idx+1,dp);
        }
    
        int ans = costs[0] + helper(days, costs, days[idx], idx+1,dp);
        ans = Math.min(costs[1] + helper(days, costs, days[idx]+6,idx+1,dp),ans);
        ans = Math.min(costs[2] + helper(days, costs, days[idx]+29,idx+1,dp),ans);
        
        return dp[idx][max]=ans;
    }
}