class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int dp[][] = new int [matrix.length][matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){    
                int n= helper(i,j,matrix,dp);
                ans= Math.max(ans,n);
            }
        }
        return ans;
    }

    public int helper(int i, int j, int grid[][], int dp[][]){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int ans=1;
        // left
        int nr = i;
        int nc = j-1;
        if(nc>=0){
            if(grid[nr][nc]>grid[i][j]){
                ans =Math.max(ans, 1+helper(nr,nc,grid,dp));
            }
        }

        // right
        nr = i;
        nc = j+1;
        if(nc<grid[0].length && grid[nr][nc]>grid[i][j]){
            ans =Math.max(ans, 1+helper(nr,nc,grid,dp));
        }

        // up
        nr = i-1;
        nc =j;
        if(nr>=0 && grid[nr][nc]>grid[i][j]){
            ans =Math.max(ans, 1+helper(nr,nc,grid,dp));
        }

        // down
        nr = i+1;
        nc =j;
        if(nr<grid.length && grid[nr][nc]>grid[i][j]){
            ans =Math.max(ans, 1+helper(nr,nc,grid,dp));
        }

        return dp[i][j]=ans;
    }
}