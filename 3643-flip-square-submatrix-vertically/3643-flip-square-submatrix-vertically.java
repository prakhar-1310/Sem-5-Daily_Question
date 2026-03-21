class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int dup[][] = new int[k][k];
        int rev = k-1;
        for(int i=0;i<k;i++){
            int arr[] = new int[k];
            for(int j=0;j<k;j++){
                arr[j]=grid[i+x][j+y];
            }

            dup[rev--]=arr;
        }

        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                grid[i][j]=dup[i-x][j-y];
            }
        }

        return grid;
    }
}