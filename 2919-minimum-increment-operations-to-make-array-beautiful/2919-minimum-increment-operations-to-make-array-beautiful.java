class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long dp[] = new long[n];
        Arrays.fill(dp, -1);

        return helper(0, nums, k, dp);
    }

    public long helper(int ind, int nums[], int k, long dp[]){
        if(ind+2>=nums.length)return 0;

        if(dp[ind]!=-1)return dp[ind];

        int index=-1;
        for(int i=ind;i<ind+3;i++){
            if(nums[i]>=k){
                index=i;
            }
        }

        long res=Long.MAX_VALUE;

        if(index!=-1){
            res = helper(index+1, nums, k, dp);
        }
        else{
            for(int i=ind;i<ind+3;i++){
                int temp = nums[i];

                res = Math.min(res, k-temp+helper(i+1, nums, k, dp));
            }
        }

        return dp[ind]=res;
    }
}