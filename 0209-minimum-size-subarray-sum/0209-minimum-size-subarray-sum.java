class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target && left<=right){
                ans = Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        if (ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}