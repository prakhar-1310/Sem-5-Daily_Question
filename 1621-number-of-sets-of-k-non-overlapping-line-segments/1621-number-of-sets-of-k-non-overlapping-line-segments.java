class Solution {
    long mod = 1000000007;
    public int numberOfSets(int n, int k) {
        long dp[][][] = new long[n+1][k+1][2];

        
        for(long i[][] : dp){
            for(long j[] : i){
                Arrays.fill(j, -1);
            }
        }
        return (int)((helper(1, k, 0, n, dp, 0)+mod)%mod);
    }

    public long helper(int i, int k, int curr, int n, long dp[][][], int start){
        if(k==curr) return 1;

        if(i>n)return 0;

        if(dp[i][curr][start]!=-1)return dp[i][curr][start];
        long ans=0;
        if(start==0){ // means need to start
            ans+= helper(i+1, k, curr, n, dp, 1)%mod;
        }
        else{ // means need to end
            ans+= helper(i, k, curr+1, n, dp, 0)%mod;
        }

        ans = (ans + helper(i+1, k, curr, n, dp, start))%mod; // skip

        return dp[i][curr][start]=ans;
    }
}