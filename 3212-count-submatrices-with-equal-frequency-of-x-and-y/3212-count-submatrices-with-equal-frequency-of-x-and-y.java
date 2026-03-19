class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int px[] = new int[grid[0].length];
        int py[] = new int[grid[0].length];
        int ans=0;

        for(int i=0;i<grid.length;i++){
            int cntX=0;
            int cntY=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='X'){
                    cntX++;
                }
                else if(grid[i][j]=='Y'){
                    cntY++;
                }
                px[j]+=cntX;
                py[j]+=cntY;

                if(px[j]==py[j] && px[j]>0){
                    ans++;
                }
            }
        }

        return ans;
    }
}