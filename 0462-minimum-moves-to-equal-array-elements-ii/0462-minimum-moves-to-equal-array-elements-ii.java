class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int opr=0;
        int mid = nums[nums.length/2];
        for (int i : nums){
            opr+=Math.abs(mid-i);
        }
        return opr;
    }
}