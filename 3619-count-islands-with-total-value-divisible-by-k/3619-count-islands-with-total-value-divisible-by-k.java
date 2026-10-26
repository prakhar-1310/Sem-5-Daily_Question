class Solution {
    public int countIslands(int[][] grid, int k) {
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    if(helper(i, j, grid, k)%k==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public int helper(int i, int j, int grid[][], int k){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }

        int ans = grid[i][j];

        grid[i][j]=0;
        // left
        int left = helper(i, j-1, grid, k)%k;

        // right
        int right = helper(i, j+1, grid, k)%k;

        // up
        int up = helper(i-1, j, grid, k)%k;

        // down
        int down = helper(i+1, j, grid, k)%k;

        return (ans+left+right+up+down)%k;
    }
}