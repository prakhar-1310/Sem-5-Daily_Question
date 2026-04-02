class Solution {
    public int maximumAmount(int[][] coins) {
        return (int)helper(0,0,coins, 0);
    }

    public long helper(int i, int j, int grid[][], int c){
        if(i>=grid.length || j>=grid[0].length){
            return -1000000;
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]<0 && c<2){
                return 0;
            }
            return grid[i][j];
        }

        long opt1 = grid[i][j] + helper(i+1, j, grid, c);
        long opt2 = grid[i][j] + helper(i, j+1, grid, c);
        long ans = Math.max(opt1, opt2);
        if(grid[i][j]<0 && c<2){
            ans = Math.max(ans, helper(i+1, j, grid, c+1));
            ans = Math.max(ans, helper(i, j+1, grid, c+1));
        }

        return ans;
    }
}