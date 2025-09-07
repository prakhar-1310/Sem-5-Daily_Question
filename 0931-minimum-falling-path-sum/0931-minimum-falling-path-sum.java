class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int [matrix.length][matrix[0].length];
        for(int arr[] : dp){
            Arrays.fill(arr,-1000000);
        }
        int ans=Integer.MAX_VALUE;
        for(int i = 0;i<matrix[0].length;i++){
            ans = Math.min(ans,helper(matrix,0,i,dp));
        }
        return ans;
    }
    public static int helper(int mat[][], int i, int j,int dp[][]){
        if(i>=mat.length || j >= mat[0].length || j<0){
            return Integer.MAX_VALUE;
        }
        if(i==mat.length-1){
            return mat[i][j];
        }
        if(dp[i][j]!=-1000000){
            return dp[i][j];
        }
        int leftd = helper(mat,i+1,j-1,dp);
        int down = helper(mat,i+1,j,dp);
        int rightd = helper(mat,i+1,j+1,dp);

        return dp[i][j]=mat[i][j]+Math.min(leftd,Math.min(down,rightd));
    }
}