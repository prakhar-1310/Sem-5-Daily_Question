class Solution {
    public int closedIsland(int[][] grid) {
        int cnt=0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(helper(i, j, grid)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;

    }

    public boolean helper(int i, int j, int grid[][]){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }

        if(grid[i][j]==1){
            return true;
        }

        grid[i][j]=1;

        boolean ans = true;

        // left
        boolean left = helper(i, j-1, grid);

        // right
        boolean right = helper(i, j+1, grid);

        // up
        boolean up = helper(i-1, j, grid);

        // down
        boolean down = helper(i+1, j, grid);

        return up && left && right && down;
    }
}