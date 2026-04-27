class Solution {
    public boolean hasValidPath(int[][] grid) {
        return helper(0,0,grid);
    }

    public boolean helper(int i, int j, int grid[][]){
        if(i==grid.length-1 && j==grid[0].length-1){
            return true;
        }

        boolean temp=false;

        if(grid[i][j]==1){
            grid[i][j]=9;
            if(j+1<grid[0].length && grid[i][j+1]!=2 && grid[i][j+1]!=4 && grid[i][j+1]!=6 && grid[i][j+1]!=9){
                temp = helper(i,j+1,grid);
            }

            if(j-1>=0 && grid[i][j-1]!=2 && grid[i][j-1]!=3 && grid[i][j-1]!=5 && grid[i][j-1]!=9){
                temp = temp || helper(i,j-1,grid);
            }
            
            
        }
        else if(grid[i][j]==2){
            grid[i][j]=9;
            if(i+1<grid.length && grid[i+1][j]!=1 && grid[i+1][j]!=3 && grid[i+1][j]!=4 && grid[i+1][j]!=9){
                temp = helper(i+1,j,grid);
            }
            if(i-1>=0 && grid[i-1][j]!=1 && grid[i-1][j]!=5 && grid[i-1][j]!=6 && grid[i-1][j]!=9){
                temp = temp || helper(i-1,j,grid);
            }
        }
        else if(grid[i][j]==3){
            grid[i][j]=9;
            if(i+1<grid.length && grid[i+1][j]!=1 && grid[i+1][j]!=4 && grid[i+1][j]!=9){
                temp = helper(i+1, j, grid);
            }
            if(j-1>=0 && grid[i][j-1]!=2 && grid[i][j-1]!=5 && grid[i][j-1]!=9){
                temp = temp || helper(i, j-1, grid);
            }
        }
        else if(grid[i][j]==4){
            grid[i][j]=9;
            if(i+1<grid.length && grid[i+1][j]!=1 && grid[i+1][j]!=3 && grid[i+1][j]!=9){
                temp = helper(i+1, j, grid);
            }
            if(j+1<grid[0].length && grid[i][j+1]!=2 && grid[i][j+1]!=6 && grid[i][j+1]!=9){
                temp = temp || helper(i, j+1, grid);
            }
        }
        else if(grid[i][j]==5){
            grid[i][j]=9;
            if(j-1>=0 && grid[i][j-1]!=2 && grid[i][j-1]!=3 && grid[i][j-1]!=9){
                temp = helper(i, j-1, grid);
            }
            if(i-1>=0 && grid[i-1][j]!=1 && grid[i-1][j]!=6 && grid[i-1][j]!=9){
                temp = temp ||  helper(i-1, j, grid);
            }
        }
        else if(grid[i][j]==6){
            grid[i][j]=9;
            if(j+1<grid[0].length && grid[i][j+1]!=2 && grid[i][j+1]!=4 && grid[i][j+1]!=9){
                temp = helper(i, j+1, grid);
            }
            if(i-1>=0 && grid[i-1][j]!=1 && grid[i-1][j]!=5 && grid[i-1][j]!=9){
                temp = temp || helper(i-1, j, grid);
            }
        }

        return temp;
        

    }
}