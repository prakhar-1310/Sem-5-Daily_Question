class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                }
            }
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}