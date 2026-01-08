class Solution {
    private int MOD = 1_000_000_007 ;
    public int countHousePlacements(int n) {
        int[] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;
        fibo(n,dp) ;
        return (int)((1L * dp[n] * dp[n]) % MOD);
    }
    public int fibo(int n , int[] dp){
        if(n==1)return dp[1] = 2 ;
        if(n==2)return dp[2] = 3 ;
        if(dp[n]!=-1)return dp[n] ;
        return dp[n] = (fibo(n-1,dp)+fibo(n-2,dp))%MOD ;
    }
}