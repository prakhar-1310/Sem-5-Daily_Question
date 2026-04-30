class Solution {
    public int maxPathScore(int[][] grid, int k) {
        dp = new long[grid.length][grid[0].length][k+1];
        for(long i[][] : dp){
            for(long j[] : i){
                 Arrays.fill(j,-1);
            }
           
        }
        poss = false;

        long ret = helper(0,0, grid, k);
        
        if(poss==true){
            return (int)ret;
        }
        return -1;
    }
    boolean poss;
    long dp[][][];
    public long helper(int i, int j, int grid[][], int k){
        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]==0){
                
            }
            else{
                k-=1;
            }
            if(k<0){
                return Integer.MIN_VALUE;
            }
            poss = true;
            return grid[i][j];
        }
        
        if(i==grid.length || j==grid[0].length || k<0){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }

        long opt1 = grid[i][j];
        long opt2 = grid[i][j];

        if(grid[i][j]==0){
            opt1+= helper(i+1,j,grid,k);
            opt2+= helper(i,j+1,grid,k);
        }
        else{
            opt1+= helper(i+1,j,grid,k-1);
            opt2+= helper(i,j+1,grid,k-1);
        }

        return dp[i][j][k] = Math.max(opt1, opt2);
    }
}