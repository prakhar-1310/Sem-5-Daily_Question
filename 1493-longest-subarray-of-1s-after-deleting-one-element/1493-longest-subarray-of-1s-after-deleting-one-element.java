class Solution {
    public int longestSubarray(int[] nums) {
        int ans =0;
        int start =0;
        int end =0;
        int k=0;
        while (start<=end && end<nums.length){
            if (nums[end]==0){
                k++;
            }
            while (k>1 && start<=end){
                if (nums[start]==0){
                    k--;
                }
                start++;
            }
            ans = Math.max(ans,end-start);
            end++;
        }
        return ans;
    }
}