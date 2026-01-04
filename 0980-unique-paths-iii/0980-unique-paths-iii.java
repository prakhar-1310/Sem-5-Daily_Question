class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1){
                    count++;
                }
            }
        }
        count = grid.length*grid[0].length-count;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return helper(i,j,grid,count);
                }
            }
        }

        
        return -1;
    }

    public int helper(int i, int j, int grid[][], int count){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return 0;
        }

        if(grid[i][j]==2 && count==1){
            return 1;
        }

        int temp = grid[i][j];
        grid[i][j]=-1;
        // left
        int left = helper(i,j-1,grid,count-1);
        // right
        int right = helper(i,j+1,grid,count-1);
        // up
        int up = helper(i-1,j,grid,count-1);
        // down
        int down = helper(i+1,j,grid,count-1);

        grid[i][j]=temp;

        return left+right+up+down;
    }
}