class Solution {
    public int rob(int[] nums) {
        int dp[][] = new int[nums.length][2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(0, 0, nums, dp);
    }

    public int helper(int i, int first, int arr[], int dp[][]){
        if(i>=arr.length)return 0;

        if(dp[i][first]!=-1){
            return dp[i][first];
        }

        int ans=0;
        
        // take
        if(i==0){
            ans = arr[0] + helper(i+2, 1, arr, dp);
        }
        else if(i==arr.length-1 && first==1){
            //skip
        }
        else{
            ans = arr[i]+helper(i+2, first, arr, dp);
        }

        // skip
        ans = Math.max(ans, helper(i+1, first, arr, dp));

        return dp[i][first]=ans;
    }
}