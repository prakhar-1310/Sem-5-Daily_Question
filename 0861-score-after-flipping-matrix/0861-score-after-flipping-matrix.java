class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                continue;
            }
            for(int j=0;j<m;j++){
                grid[i][j]=1-grid[i][j];
            }
        }

        int sum=(int)Math.pow(2, m-1)*n;

        for(int j=1;j<m;j++){
            int cnt=0;
            for(int i=0;i<n;i++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }

            cnt = Math.max(cnt, n-cnt);

            sum+=(int)Math.pow(2, m-j-1)*cnt;
        }

        return sum;
    }
}