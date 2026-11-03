class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];

        for(int i : nums){
            max = Math.max(max, i);
        }

        int tot=0;

        for(int i : nums){
            tot+=(max-i);
        }


        return tot;
    }
}