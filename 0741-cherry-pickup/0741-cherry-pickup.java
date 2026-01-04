class Solution {
    public int cherryPickup(int[][] grid) {
        helper(0,0,grid,0);
        return maxC;
    }
    int maxC=0;
    // top -> bottom
    public void helper(int i, int j, int grid[][],int c){ 
        if(i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return;
        }

        int cherry = grid[i][j];
        grid[i][j]=0;

        if(i==grid.length-1 && j==grid[0].length-1){
            helper2(i,j,grid,c+cherry);
        }

        helper(i,j+1,grid,c+cherry);
        helper(i+1,j,grid,c+cherry);

        grid[i][j]=cherry;
    }

    public void helper2(int i, int j, int grid[][], int c){ 
        if(i<0 || j<0 || grid[i][j]==-1){
            return;
        }

        int cherry = grid[i][j];
        grid[i][j]=0;

        if(i==0 && j==0){
            maxC = Math.max(maxC, cherry+c);
        }

        helper2(i-1,j,grid,c+cherry);
        helper2(i,j-1,grid,c+cherry);

        grid[i][j]=cherry;
    }
}