class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int tot=0;
            for(int j=1;j<=i;j++){
                tot+=dp[j-1]*dp[i-j];
            }
            dp[i] = tot;
        }

        return dp[n];
    }
}