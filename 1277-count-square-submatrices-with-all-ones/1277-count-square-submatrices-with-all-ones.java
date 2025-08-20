class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int [m][n];

        int ans=0;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]!=0){
                    if(i-1>=0 && j-1>=0){
                        dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                        ans+=dp[i][j];
                    }
                    else{
                        dp[i][j] = matrix[i][j];
                        ans+=dp[i][j];
                    }
                }
                else{
                    dp[i][j]=0;
                }
            }
        }

        return ans;
    }
}