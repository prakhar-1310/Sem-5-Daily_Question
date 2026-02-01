class Solution {
    public int minimumCost(int[] nums) {
        int pre=nums[0];
        
        Arrays.sort(nums);

        return Math.max(pre+nums[0]+nums[1], nums[0]+nums[1]+nums[2]);
    }
}