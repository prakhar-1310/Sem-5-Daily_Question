class Solution {
    public int findChampion(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            int count=0;
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1 && i!=j){
                    count++;
                    if (count==grid.length-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}