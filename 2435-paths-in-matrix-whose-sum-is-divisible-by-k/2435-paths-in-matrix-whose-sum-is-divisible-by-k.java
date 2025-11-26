class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        return helper(grid,0,0,k,0);
    }

    public int helper(int grid[][], int i, int j, int k, int rem){
        if(i==grid.length-1 && j==grid[0].length-1){
            if((grid[i][j]+rem)%k==0){
                return 1;
            }
            return 0;
        }
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }

        int right = helper(grid,i,j+1,k,(rem+grid[i][j])%k);
      
        int down = helper(grid,i+1,j,k,(rem+grid[i][j])%k);

        return right+down;
    }
}