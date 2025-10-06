class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][] = new int[dungeon.length][dungeon[0].length];
        return helper(dungeon,0,0,dp);
    }

    public int helper(int arr[][], int i, int j, int dp[][]){
        if(i>=arr.length || j>=arr[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(i==arr.length-1 && j==arr[0].length-1){
            return Math.max(1,1-(arr[i][j]));
        }

        int right = helper(arr,i,j+1,dp);
        int down = helper(arr,i+1,j,dp);

        return dp[i][j]=Math.max(1,Math.min(right,down)-arr[i][j]);
    }
}