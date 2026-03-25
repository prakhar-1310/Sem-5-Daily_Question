class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long row[] = new long[n];
        long col[] = new long[m];
        long tot =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                row[i]+=grid[i][j];
                col[j]+=grid[i][j];
                tot+=grid[i][j];
            }
        }

        if(tot%2!=0)return false;

        boolean checkRow = helper(row, tot);
        boolean checkCol = helper(col, tot);

        return checkRow || checkCol;
    }

    public boolean helper(long arr[], long tot){
        long left=0;
        long right=tot;

        for(long i : arr){
            left+=i;
            right-=i;
            if(left==right){
                return true;
            }
        }

        return false;
    }
}