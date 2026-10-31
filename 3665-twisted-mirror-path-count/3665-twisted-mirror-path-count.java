class Solution {
    int mod = 1000000007;
    public int uniquePaths(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][2];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j, -1);
            }
            
        }

        return (helper(0,1,grid,1, dp)+helper(1,0,grid,0,dp))%mod;
    }

    // 1--> right
    // 0--> down

    public int helper(int i, int j, int grid[][], int prev, int dp[][][]){
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }

        if(dp[i][j][prev]!=-1){
            return dp[i][j][prev];
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }

        int ans=0;

        if(grid[i][j]==1){
            if(prev==1){ 
                int temp =helper(i+1, j, grid, 0, dp)%mod;
                ans = temp;
            }
            else{
                int temp =helper(i, j+1, grid, 1, dp)%mod;
                ans = temp;
            }

            return dp[i][j][prev]=ans;
        }

        // right
        if(j+1<grid[0].length && grid[i][j+1]==1){ // mirror
            // means will move down
            ans = helper(i+1, j+1, grid, 0, dp)%mod;
        }
        else if(j+1<grid[0].length){
            ans = helper(i, j+1, grid, 1, dp)%mod;
        }

        // down
        if(i+1<grid.length && grid[i+1][j]==1){ // mirror
            // means will move right
            ans= (ans + (helper(i+1, j+1, grid, 1, dp)%mod))%mod;
        }
        else if(i+1<grid.length){
            ans= (ans + (helper(i+1, j, grid, 0, dp)%mod))%mod;
        }

        return dp[i][j][prev]=ans;
    }
}