class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        for(int i=1;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]+=grid[i-1][j];
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            int sum=0;
            for(int j=0;j<grid[0].length;j++){
                sum+=grid[i][j];
                if(sum<=k){
                    ans++;
                }
                else{
                    break;
                }
            }
        }

        return ans;
    }
}