class Solution {
    public int swimInWater(int[][] grid) {
        int low = 0;
        int high = 50*50;
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            int visited[][] = new int [grid.length][grid[0].length];
            helper(visited,grid,mid,0,0);
            if(visited[grid.length-1][grid[0].length-1]==1){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public void helper(int vis[][], int grid[][], int mid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]==1 || grid[i][j]>mid){
            return;
        }
        vis[i][j]=1;
        helper(vis,grid,mid,i-1,j);//up
        helper(vis,grid,mid,i+1,j);//down
        helper(vis,grid,mid,i,j-1);//left
        helper(vis,grid,mid,i,j+1);//right
    }
}