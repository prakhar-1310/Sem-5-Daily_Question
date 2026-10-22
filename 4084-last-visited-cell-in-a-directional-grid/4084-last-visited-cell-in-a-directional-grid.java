class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visi[][] = new boolean[n][m];

        int x=0;
        int y=0;
        

        while(!visi[x][y]){
            visi[x][y]=true;

            if(grid[x][y]=='D'){
                if(x+1>=n || visi[x+1][y]){
                    break;
                }
                x+=1;
            }
            else if(grid[x][y]=='U'){
                if(x-1<0 || visi[x-1][y])break;
                x-=1;
            }
            else if(grid[x][y]=='L'){
                if(y-1<0 || visi[x][y-1])break;
                y-=1;
            }
            else{
                if(y+1>=m || visi[x][y+1])break;
                y+=1;
            }
        }

        return new int[]{x,y};
    }
}