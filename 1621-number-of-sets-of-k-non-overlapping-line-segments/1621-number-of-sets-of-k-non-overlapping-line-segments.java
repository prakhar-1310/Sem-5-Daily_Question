class Solution {
    long mod = 1000000007;
    long suff[][];
    public int numberOfSets(int n, int k) {
        long dp[][] = new long[n+1][k+1];
        suff = new long[n+1][k+1];
        for(long i[] : suff){
            Arrays.fill(i, -1);
        }
        for(long i[] : dp){
            Arrays.fill(i, -1);
        }
        return (int)((helper(1, k, 0, n, dp)+mod)%mod);
    }

    public long helper(int i, int k, int curr, int n, long dp[][]){
        if(curr==k){
            return 1;
        }

        if(i>=n)return 0;

        if(dp[i][curr]!=-1){
            return dp[i][curr];
        }

        long ans = suffix(i+1, k, curr+1, n, dp)%mod;
        long temp = helper(i+1, k, curr, n, dp)%mod;
        ans = (ans+temp)%mod;
        return dp[i][curr]=ans;
    }

    public long suffix(int i, int k, int curr, int n, long dp[][]){
        if(i>n)return 0;

        if(suff[i][curr]!=-1)return suff[i][curr];

        long ans=helper(i, k, curr, n, dp);

        ans = (ans+suffix(i+1, k, curr, n, dp))%mod;

        return suff[i][curr]=ans;
    }

}