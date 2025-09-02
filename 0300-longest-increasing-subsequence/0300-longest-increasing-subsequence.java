class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
        
    }
    public static int lis(int nums[]){
        int dp[] = new int [nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    
                }
            }
        }

        int ans=0;
        for(int i : dp){
            ans = Math.max(ans,i);
        }
        return ans;
    }
}