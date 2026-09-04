class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row[] = new int[n];
        for(int i=0;i<n;i++){
            int max=grid[i][0];
            for(int j=1;j<m;j++){
                max = Math.max(grid[i][j], max);
            }
            row[i]=max;
        }

        int col[]= new int[m];
        for(int j=0;j<m;j++){
            int max = grid[0][j];
            for(int i=1;i<n;i++){
                max=Math.max(grid[i][j], max);
            }
            col[j]=max;
        }

        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Math.abs(grid[i][j]-Math.min(row[i], col[j]));
            }
        }

        return sum;
    }
}