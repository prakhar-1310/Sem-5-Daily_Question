class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }
        return count;
    }

    public void helper(char grid[][], int i, int j){
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        helper(grid, i-1, j); // top
        helper(grid, i+1, j); // down
        helper(grid, i, j-1); // left
        helper(grid, i, j+1); // right
    }
}