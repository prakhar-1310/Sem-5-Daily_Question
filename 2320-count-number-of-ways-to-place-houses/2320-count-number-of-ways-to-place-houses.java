class Solution {
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        int dp[] = new int[n+2];
        dp[0]=1;
        dp[1]=2;

        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }

        return (int)((1L*dp[n]*dp[n])%mod);
        
    }
}