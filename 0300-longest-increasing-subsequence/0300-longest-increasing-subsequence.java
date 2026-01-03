class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int len=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[len-1]){
                dp[len]=nums[i];
                len++;
            }
            else{
                int idx = bs(len,dp,nums[i]);
                dp[idx] = nums[i];
            }
        }

        return len;
    }

    public int bs(int len, int arr[], int tar){
        int low =0;
        int high = len-1;
        int idx = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=tar){
                idx = mid;
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return idx;
    }
}