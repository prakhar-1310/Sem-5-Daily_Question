class Solution {
    public int findCircleNum(int[][] grid) {
        int count=0;
        boolean visited[] = new boolean[grid.length];
        for(int i=0;i<grid.length;i++){
            if(!visited[i]){
                count++;
                dfs(i,grid,visited);
            }
        }
        return count;
    }

    public void dfs(int i, int grid[][], boolean visited[]){
        visited[i] = true;

        for(int j=0;j<grid.length;j++){
            if(grid[i][j]==1 && !visited[j]){
                dfs(j,grid,visited);
            }
        }

    }
}