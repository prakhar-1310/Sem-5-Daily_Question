class Solution {
    public int minimumArea(int[][] grid) {
        int minr = Integer.MAX_VALUE;
        int maxr = Integer.MIN_VALUE;
        int minc = Integer.MAX_VALUE;
        int maxc = Integer.MIN_VALUE;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minr = Math.min(i,minr);
                    maxr = Math.max(i,maxr);
                    minc = Math.min(j,minc);
                    maxc = Math.max(j,maxc);
                }
            }
        }
        if(minr == Integer.MAX_VALUE){ //  means none of element is 1
            return 0;
        }
        int height = maxr-minr+1;
        int width = maxc-minc+1;

        return (height*width);
    }
}