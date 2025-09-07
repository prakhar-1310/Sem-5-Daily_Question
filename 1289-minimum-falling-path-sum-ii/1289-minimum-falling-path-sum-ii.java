class Solution {
    public int minFallingPathSum(int[][] grid) {
        int dp[][] = new int [grid.length][grid[0].length];
        for(int arr[] : dp){
            Arrays.fill(arr,-1000000);
        }
        int ans=Integer.MAX_VALUE;
        for(int i = 0;i<grid[0].length;i++){
            ans = Math.min(ans,helper(grid,0,i,dp));
        }
        return ans;
    }
    public static int helper(int mat[][], int i, int j,int dp[][]){
        if(i>=mat.length || j >= mat[0].length || j<0){
            return Integer.MAX_VALUE;
        }
        if(i==mat.length-1){
            return mat[i][j];
        }
        if(dp[i][j]!=-1000000){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int col=0;col<mat[0].length;col++){
            if(col!=j){
                min = Math.min(min,helper(mat,i+1,col,dp));
            }
        }

        return dp[i][j]=mat[i][j]+min;
    }
}