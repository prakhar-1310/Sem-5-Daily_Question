class Solution {
    public int minDays(int n) {
        int sum=0;
        int i=1;
        while(sum<=n){
            sum+=i;
            i++;
        }
        int dp[][] = new int[n+1][i+1];
        for(int j[] : dp){
            Arrays.fill(j, -1);
        }
        return helper(0,n, 0, dp);
    }

    public int helper(int points, int n, int st, int dp[][]){
        if(points>n){
            return Integer.MAX_VALUE/2;
        }
        if(points == n){
            return 0;
        }
        if(dp[points][st]!=-1)return dp[points][st];

        

        // take
        int opt1 = helper(points+st+1, n, st+1, dp);
        
        // skip
        int opt2 = Integer.MAX_VALUE / 2;

        if (st > 0) {
            opt2 = helper(points, n, 0, dp);
        }

        return dp[points][st]=Math.min(opt1, opt2)+1;
    }
}