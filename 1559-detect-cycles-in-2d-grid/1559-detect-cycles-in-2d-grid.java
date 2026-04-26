class Solution {
    boolean visi[][];
    public boolean containsCycle(char[][] grid) {
        visi = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visi[i][j])continue;
                char temp = grid[i][j];

                if(helper(i,j,grid,temp,-1,-1)){
                    return true;
                }
                
                grid[i][j]=temp;
                
            }
        }
        return false;
    }

    public boolean helper(int i, int j, char grid[][], char tar, int pi, int pj){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=tar ){
            return false;
        }
        if(visi[i][j]){
            return true;
        }

        visi[i][j]=true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
   
            if (ni == pi && nj == pj) continue;

            if (helper(ni, nj, grid, tar, i, j)) {
                return true;
            }
        }

        return false;
    }
}