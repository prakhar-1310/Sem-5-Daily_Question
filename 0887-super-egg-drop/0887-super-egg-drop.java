class Solution {
    public int superEggDrop(int k, int n) {
        // Best (choices) of the worst(luck)
        // where luck involved choose worst
        // where choice involved choose best

        // Min of the maxes

        int dp[][] = new int[k+1][n+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(k,n,dp);
    }

    public int helper(int k, int n, int dp[][]){
        if(n==0 || n==1){
            return n;
        }
        if(k==1){
            return n;
        }

        if(dp[k][n]!=-1){
            return dp[k][n];
        }

        int low=0;
        int high=n;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            int Break = helper(k-1,mid-1,dp);
            int survive = helper(k,n-mid,dp);

            int worst = 1 + Math.max(Break,survive);

            ans = Math.min(ans,worst);

            if(survive>Break){
                low=mid+1;
            }
            else{
                high = mid-1;
            }

        }

        return dp[k][n]=ans;
    }
}