class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for(int i[] : dp){
            Arrays.fill(i,-1000000000);
        }
        return helper(0,0,nums1,nums2,dp);
    }
    public int helper(int i, int j, int nums1[], int nums2[],int dp[][]){
        if(i>=nums1.length || j>=nums2.length){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j]!=-1000000000){
            return dp[i][j];
        }

        int inc= nums1[i]*nums2[j] + Math.max(0,helper(i+1,j+1,nums1,nums2,dp));

        
        int opt1 = helper(i+1,j,nums1,nums2,dp);
        int opt2 = helper(i,j+1,nums1,nums2,dp);
        int exc = Math.max(opt1,opt2);

        return dp[i][j]=Math.max(inc,exc);
    }
}