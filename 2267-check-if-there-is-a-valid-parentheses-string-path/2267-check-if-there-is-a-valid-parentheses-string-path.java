class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][n+m]; // 1-> true, -1--> false, 0--> default
        return helper(0,0,grid,0,dp);
    }

    public boolean helper(int i, int j, char grid[][], int bal, int dp[][][]){
        if(i>=grid.length || j>=grid[0].length){
            return false;
        }

        if(grid[i][j]=='(')bal++;
        else bal--;

        if(bal<0)return false;

        if(dp[i][j][bal]!=0)return dp[i][j][bal]==1?true:false;

        

        if(i==grid.length-1 && j==grid[0].length-1 && bal==0){
            return true;
        }

        // right
        boolean opt1 = helper(i, j+1, grid, bal, dp);

        boolean opt2 = helper(i+1, j, grid, bal, dp);
        dp[i][j][bal]=opt1||opt2==true?1:-1;
        return opt1||opt2;
    }
}