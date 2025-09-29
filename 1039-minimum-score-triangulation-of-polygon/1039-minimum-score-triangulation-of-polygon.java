class Solution {
    public int minScoreTriangulation(int[] values) {
        int dp[][] = new int [values.length][values.length];
        return helper(values,0,values.length-1,dp);
        
    }

    public int helper(int arr[], int i, int j, int[][]dp){
        if(j-i<2){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans = Math.min(helper(arr,i,k,dp)+arr[i]*arr[j]*arr[k]+helper(arr,k,j,dp),ans);
        }
        return dp[i][j]=ans;
    }
}