class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(0,0,obstacleGrid,dp);

    }

    public int helper(int i, int j, int grid[][], int dp[][]){
        if(i>=grid.length || j>=grid[0].length || grid[i][j]==1){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }

        int right = helper(i,j+1,grid,dp);
        int down = helper(i+1,j,grid,dp);

        return dp[i][j]=down + right;
    }
}