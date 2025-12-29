class Solution {
    public int orangesRotting(int[][] grid) {
        int count=0;
        int time = 0;
        Queue<Pair>q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair rem = q.poll();

            int row = rem.r;
            int col = rem.c;

            time = Math.max(time,rem.time);

            if(row-1>=0 && grid[row-1][col]==1){
                grid[row-1][col]=2;
                q.add(new Pair(row-1,col,rem.time+1));
            }
            if(row+1<grid.length && grid[row+1][col]==1){
                grid[row+1][col]=2;
                q.add(new Pair(row+1,col,rem.time+1));
            }
            if(col-1>=0 && grid[row][col-1]==1){
                grid[row][col-1]=2;
                q.add(new Pair(row,col-1,rem.time+1));
            }
            if(col+1<grid[0].length && grid[row][col+1]==1){
                grid[row][col+1]=2;
                q.add(new Pair(row,col+1,rem.time+1));
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time;
    }

    class Pair{
        int r;
        int c;
        int time;

        public Pair(int i, int j, int time){
            this.r=i;
            this.c=j;
            this.time= time;
        }
    }
}