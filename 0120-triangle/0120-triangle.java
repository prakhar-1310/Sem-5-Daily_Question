class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for(int arr[] : dp){
            Arrays.fill(arr, 100000);
        }
        return helper(triangle,0,0,dp);
    }
    public int helper(List<List<Integer>>list,int row, int col, int dp[][]){
        if(row==list.size()){
            return 0;
        }
        if(dp[row][col]!=100000){
            return dp[row][col];
        }
        int down = helper(list,row+1,col,dp);
        int downR = helper(list,row+1,col+1,dp);
        return dp[row][col]=list.get(row).get(col) + Math.min(down, downR);
    }
}