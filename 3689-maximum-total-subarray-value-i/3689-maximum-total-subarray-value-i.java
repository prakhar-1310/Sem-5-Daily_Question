class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        long diff = nums[nums.length-1]-nums[0];
        return 1L*diff*k;
    }
}