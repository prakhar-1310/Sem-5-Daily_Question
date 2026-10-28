class Solution {
    public int minCost(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][1024];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j, -1);
            }
        }
        return helper(0,0, grid, 0, dp);
    }

    public int helper(int i, int j, int grid[][], int xor, int dp[][][]){
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE/2;
        }
        xor^=grid[i][j];

        if(dp[i][j][xor]!=-1){
            return dp[i][j][xor];
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return xor;
        }

        // right
        int right = helper(i, j+1, grid, xor, dp);

        // down
        int down = helper(i+1, j, grid, xor, dp);

        return dp[i][j][xor]=Math.min(right, down) ; 
    }
}