class Solution {
    public int largestPerimeter(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        for(int i=nums.length-3;i>=0;i--){
            if(nums[i]+nums[i+1]> nums[i+2]){
                ans = nums[i]+nums[i+1]+nums[i+2];
                return ans;
            }
        }
        return ans;
    }
}